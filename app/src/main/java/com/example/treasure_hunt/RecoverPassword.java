package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.util.SimpleMail;

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

// Esta actividad contiene la logica de recuperacion de contrasennas
public class RecoverPassword extends AppCompatActivity {

    EditText user;
    Button button;
    private static final String TAG = RecoverPassword.class.getSimpleName();

    String playerName;
    String pass;
    String email;
    FirebaseDatabase database;
    DatabaseReference playerRef;

    // Obtiene una referencia a la base de datos, inicializa las vistas y annade listener al boton de envio
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        user = findViewById(R.id.editTextUserRecover);
        button = findViewById(R.id.buttonSendRecover);
        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerName = user.getText().toString();
                playerRef = database.getReference("users");
                if(!playerName.equals("")){
                    addEventListener();
                }
                else  Toast.makeText(RecoverPassword.this, "Introduzca nombre de usuario.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Envia un email al correo electronico proveido por el usuario con la contrasenna
    // Si el correo introducido no existe en la bd no muestra msg de error para no dar demasiada informacion a usuarios maliciosos.
    private void addEventListener() {
        //lee de la base de datos
        playerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Boolean nameFlag = false;
                pass = "";
                email = "";
                Iterable<DataSnapshot> nombres = snapshot.getChildren();
                for (DataSnapshot dataSnapshot : nombres) {
                    if (playerName.equals(dataSnapshot.getKey())) {
                        nameFlag = true;
                        email = dataSnapshot.child("email").getValue().toString();
                        pass = dataSnapshot.child("password").getValue().toString();
                    }
                }
                if (nameFlag){
                    try {
                        SimpleMail.sendMail(email, playerName, pass);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(RecoverPassword.this, "Contraseña enviada al email vinculado al usuario." , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("playerName", playerName);
                    startActivity(intent);
                    finish();
                }
            }

            // Si se produce un error
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                button.setText("INICIAR SESIÓN");
                button.setEnabled(true);
                Toast.makeText(RecoverPassword.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}