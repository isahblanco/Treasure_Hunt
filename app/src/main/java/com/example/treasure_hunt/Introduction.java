package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/*
 Activity que muestra la introducción y espera a todos
 los jugadores antes de comenzar el juego
 */
public class Introduction extends AppCompatActivity {

    String rol;
    String playerName;
    String nombreSala;

    Button inicio;

    FirebaseDatabase database;
    DatabaseReference startRefRol, startRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        Bundle extras = getIntent().getExtras();
        rol = extras.getString("rol");
        nombreSala = extras.getString("nombreSala");
        playerName = extras.getString("playerName");

        inicio = findViewById(R.id.buttonStartTurn1);

        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");
        startRef = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("startGame");
        startRefRol = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("startGame").child(rol);

        //Al pulsar el boton se establece el valor a true en firebase de que el
        // jugador está listo para comenzar y se espera al resto de jugadores
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inicio.setEnabled(false);
                inicio.setText("Esperando al resto de la tripulación...");
                startRefRol.setValue(true);
                //Comprueba que todos los jugadores esten listos
                addStartGameListener();

            }
        });

    }

    private void addStartGameListener(){
        startRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                boolean flag = true;
                //Comprueba que todos los usuarios tengan el valor true en firebase para comenzar
                Iterable<DataSnapshot> usuariosEmpezado = snapshot.getChildren();
                for(DataSnapshot dataSnapshot : usuariosEmpezado){

                    if(!(boolean) dataSnapshot.getValue()){
                        flag = false;
                    }
                }
                //Si todos true, se genera el intent con los recursos necesarios para la siguiente Activity
                if(flag) {
                    Intent intent = new Intent(getApplicationContext(), StoryTelling.class);
                    intent.putExtra("rol", rol);
                    intent.putExtra("playerName", playerName);
                    intent.putExtra("turno",  1);
                    intent.putExtra("nombreSala", nombreSala);
                    intent.putExtra("resultados", new ArrayList<String>());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}