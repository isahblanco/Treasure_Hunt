package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

// Activity que contiene la logica de registro de nuevos usuarios
public class Register extends AppCompatActivity {

    private static final String TAG = Register.class.getSimpleName();
    FirebaseDatabase database;
    DatabaseReference usersRef;
    Button button;
    EditText name;
    EditText email;
    EditText pass1;
    EditText pass2;

    //Coge la referencia de la base de datos, annade listeners al boton de enviar e inicializa el contenido de la vista
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");
        button = findViewById(R.id.buttonRegister);
        name = findViewById(R.id.editTextUserName);
        email = findViewById(R.id.editTextEmail);
        pass1 = findViewById(R.id.editPass1);
        pass2 = findViewById(R.id.editTextPass2);

        // Annade un listener al boton de enviar y valida que los datos sean correctos
        // Ningun campo vacio, email correcto, contraseñas iguales y de mas de 8 caracteres
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usersRef = database.getReference("users");
                String nameT = name.getText().toString();
                String emailT = email.getText().toString();
                String pass1T = pass1.getText().toString();
                String pass2T = pass2.getText().toString();
                if(nameT.equals("") || emailT.equals("") || pass1T.equals("") || pass2T.equals("")) {
                    Toast.makeText(Register.this, "Rellene todos los campos.", Toast.LENGTH_SHORT).show();
                }
                else if (pass1T.toString().length() < 8) {
                    Toast.makeText(Register.this, "Las contraseña debe contener más de 7 caracteres.", Toast.LENGTH_SHORT).show();
                }
                else if (!pass1T.toString().equals(pass2T.toString())) {
                    Toast.makeText(Register.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                } else {
                    addEventListener();
                }
            }
        });
    }

    // Procesa el registro de un usuario y lo annade a la base de datos.
    // Controla que no exista otro usuario con el mismo nick
    private void addEventListener() {
        //lee de la base de datos
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Boolean userFlag = false;
                String nameT = name.getText().toString();
                String emailT = email.getText().toString();
                String pass1T = pass1.getText().toString();
                String pass2T = pass2.getText().toString();
                Iterable<DataSnapshot> nombres = snapshot.getChildren();
                for (DataSnapshot dataSnapshot : nombres) {
                    if (nameT.equals(dataSnapshot.getKey())) {
                        userFlag = true;
                        Toast.makeText(Register.this, "El usuario ya existe.", Toast.LENGTH_LONG).show();
                    }
                }
                if (!userFlag){
                    button.setText("REGISTRANDO...");
                    button.setEnabled(false);
                    DatabaseReference userRef = database.getReference().child("users").child(String.valueOf(nameT));
                    userRef.setValue(nameT);
                    DatabaseReference emailRef = database.getReference().child("users").child(String.valueOf(nameT)).child("email");
                    emailRef.setValue(emailT);
                    DatabaseReference passRef = database.getReference().child("users").child(String.valueOf(nameT)).child("password");
                    passRef.setValue(pass1T);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            // Si se produce un error
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                button.setText("INICIAR SESIÓN");
                button.setEnabled(true);
                Toast.makeText(Register.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
