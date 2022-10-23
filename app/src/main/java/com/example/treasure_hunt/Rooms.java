package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//Activity para la creación o el acceso a las salas.
public class Rooms extends AppCompatActivity {

    EditText crearSala, unirseSala;
    Button bCrear, bUnirse;

    String playerName;

    FirebaseDatabase database;
    DatabaseReference roomsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        Bundle extras = getIntent().getExtras();
        playerName = extras.getString("playerName");

        crearSala = findViewById(R.id.editTextTextPersonName);
        unirseSala = findViewById(R.id.editTextTextPersonName);
        bCrear = findViewById(R.id.button3);
        bUnirse = findViewById(R.id.button4);

        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");

        bCrear.setOnClickListener(new View.OnClickListener() {

            //Función cuando se pulsa el botón de crear sala.
            @Override
            public void onClick(View view) {
                String nombreSala = crearSala.getText().toString();
                //Si no se ha escrito nada en el código de la sala, lo notifica.
                if(nombreSala.equals("")) {
                   Toast.makeText(Rooms.this, "Introduce un nombre de sala.", Toast.LENGTH_SHORT).show();
                } else {
                    //Se obtiene la referencia al directorio de las salas de Firebase
                    DatabaseReference existingRoomsRef = database.getReference().child("rooms");
                    existingRoomsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //Se comprueba que no existe alguna sala con el nombre ya introducido
                            Boolean roomExists = false;
                            Iterable<DataSnapshot> rooms = snapshot.getChildren();
                            for (DataSnapshot dataSnapshot : rooms) {
                                if (dataSnapshot.getKey().toString().equals(nombreSala)) {
                                    roomExists = true;
                                    Toast.makeText(Rooms.this, "Ya existe una sala con ese nombre.", Toast.LENGTH_SHORT).show();
                                }
                            }
                            //Si no existe se crea la sala
                            if (!roomExists)
                                nextActivity(nombreSala, playerName);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        //Función cuando se pulsa el botón de unirse.
        bUnirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreSala = unirseSala.getText().toString();
                DatabaseReference existingRoomsRef = database.getReference().child("rooms");
                existingRoomsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Se comprueba si existe la sala con el mismo nombre que el indicado, y si hay hueco en la sala (6 miembros max. por sala)
                        Boolean roomExists = false;
                        Iterable<DataSnapshot> rooms = snapshot.getChildren();
                        for(DataSnapshot dataSnapshot : rooms){
                            if(dataSnapshot.getKey().toString().equals(nombreSala) && snapshot.child(nombreSala).child("players").getChildrenCount()<6){
                                roomExists = true;
                                nextActivity(nombreSala, playerName);

                            }
                        }
                        //Si no existe la sala indicada, lo informa
                        if(!roomExists)
                        Toast.makeText(Rooms.this, "No existe sala con ese nombre.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    //Añade en Firebase al jugador en la sala indicada
    private void nextActivity(String nombreSala, String playerName){
        roomsRef = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("players").child(playerName);
        //Se pasa a la actividad de seleccion de rol pasando los valores necesarios.
        Intent intent = new Intent(getApplicationContext(), SeleccionRol.class);
        intent.putExtra("playerName", playerName);
        intent.putExtra("nombreSala", nombreSala);
        startActivity(intent);
        finish();

    }
}