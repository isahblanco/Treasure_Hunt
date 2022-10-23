package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.persistencia.DbDecisions;
import com.example.persistencia.DbHelper;
import com.example.persistencia.Script;
import com.example.persistencia.StatusContract;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

// Clase inicial de la aplicacion. Contiene la logica de hacer login y redirige a las actividades de registro y recuperacion de contraseña
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText editText;
    EditText editTextP;
    Button button;

    String playerName = "";
    String pass = "";


    FirebaseDatabase database;
    DatabaseReference playerRef;

    //Inicializa la actividad, coge una referencia a la base de datos y annade listeners a los botones
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editTextP = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.button);

        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");

        DbHelper dbH = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbH.getWritableDatabase();
        DbDecisions decisions = new DbDecisions(MainActivity.this);

        Script.script(db);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerName = editText.getText().toString();
                pass = editTextP.getText().toString();
                playerRef = database.getReference("users");
                if(!(playerName.equals("") || pass.equals(""))){
                    addEventListener();
                }
                else  Toast.makeText(MainActivity.this, "Introduzca usuario y contraseña.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Logica de inicio de sesion de los usuarios. Muestra mensajes de error cuando los datos introducidos no estan en la BD
    private void addEventListener() {
        // Lee de la base de datos
        playerRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Boolean nameFlag = false;
                    Iterable<DataSnapshot> nombres = snapshot.getChildren();
                    for (DataSnapshot dataSnapshot : nombres) {               
                        if (playerName.equals(dataSnapshot.getKey()) && pass.equals(dataSnapshot.child("password").getValue())) {
                            nameFlag = true;
                            button.setText("INICIAR SESIÓN");
                            button.setEnabled(true);
                            break;
                        }
                    }
                    if (nameFlag){
                        button.setText("INICIANDO...");
                        button.setEnabled(false);
                        Intent intent = new Intent(getApplicationContext(), Rooms.class);
                        intent.putExtra("playerName", playerName);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "No existe usuario con los datos especificados.", Toast.LENGTH_LONG).show();
                    }
                }
            
            // Si se cancela el inicio de sesion (hay error) 
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                button.setText("INICIAR SESIÓN");
                button.setEnabled(true);
                Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Redirige a la actividad de recuperacion de contrasenna
    public void openRecoverPassword(View view) {
        Intent intent = new Intent(MainActivity.this, RecoverPassword.class);
        startActivity(intent);
    }

    // Redirige a la actividad de registro de usuario
    public void openRegister(View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}