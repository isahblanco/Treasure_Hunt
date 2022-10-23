package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//Activity para que cada usuario en una sala obtenga un rol determinado.
public class SeleccionRol extends AppCompatActivity {

    Button capitan, cocinero, vigia, contramaestre, artillero, timonel;
    String playerName = "";
    String nombreSala= "";
    String rol ="";


    FirebaseDatabase database;
    DatabaseReference rolRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_rol);
        Bundle extras = getIntent().getExtras();
        playerName = extras.getString("playerName");
        nombreSala = extras.getString("nombreSala");

        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");

        //Se obtienen los botones que se asignan con cada rol
        capitan = findViewById(R.id.Capitan);
        cocinero = findViewById(R.id.Cocinero);
        vigia = findViewById(R.id.Vigia);
        contramaestre = findViewById(R.id.Contramaestre);
        artillero = findViewById(R.id.Artillero);
        timonel = findViewById(R.id.Timonel);

        //Se crean los listener para cada botón, donde se llamará a una función cambiando los parámetros de entrada según el botón.
        capitan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarRol("capitan", capitan);
            }
        });

        cocinero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarRol("cocinero", cocinero);
            }
        });

        vigia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarRol("vigia",vigia);
            }
        });

        contramaestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarRol("contramaestre", contramaestre);
            }
        });

        artillero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarRol("artillero", artillero);
            }
        });

        timonel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarRol("timonel", timonel);
            }
        });
        //Se comprueba que roles ya están escogidos.
        addRolRepetidoEventListener();
    }

    //Método que detecta roles ya escogidos por otros jugadores
    private void addRolRepetidoEventListener() {
        DatabaseReference rolesRef = database.getReference("rooms/" + nombreSala + "/players");
        rolesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Se recorren todos los roles de la sala y aquellos que ya están elegidos, se bloquea el botón.
                Iterable<DataSnapshot> roles = snapshot.getChildren();
                String rolOcupado = "";
                for(DataSnapshot dataSnapshot : roles){
                    rolOcupado = dataSnapshot.getValue().toString();
                    switch (rolOcupado){
                        case "capitan":
                            capitan.setEnabled(false);
                            capitan.setText("Ya escogido");
                            break;

                        case "cocinero":
                            cocinero.setEnabled(false);
                            cocinero.setText("Ya escogido");
                            break;

                        case "vigia":
                            vigia.setEnabled(false);
                            vigia.setText("Ya escogido");
                            break;

                        case "contramaestre":
                            contramaestre.setEnabled(false);
                            contramaestre.setText("Ya escogido");
                            break;

                        case "artillero":
                            artillero.setEnabled(false);
                            artillero.setText("Ya escogido");
                            break;

                        case "timonel":
                            timonel.setEnabled(false);
                            timonel.setText("Ya escogido");
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Método para asociar un rol a un jugador.
    private void asignarRol(String r, Button b){
        b.setText("Rol Escogido");
        b.setEnabled(false);
        rol = r;
        //Se añade el rol al jugador en firebase
        rolRef = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("players").child(playerName);
        rolRef.setValue(rol);
        //Se continúa informandole al rol pasandole a la Activity los recursos necesarios.
        Intent intent = new Intent(getApplicationContext(), InfoRol.class);
        intent.putExtra("rol", rol);
        intent.putExtra("playerName", playerName);
        intent.putExtra("nombreSala", nombreSala);
        startActivity(intent);
        finish();
    }
}