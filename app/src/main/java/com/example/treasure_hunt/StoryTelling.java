package com.example.treasure_hunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.persistencia.DbDecisions;
import com.example.persistencia.DbHelper;
import com.example.persistencia.Script;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

//Clase principal encargada de la historia y la toma de decisiones.
public class StoryTelling extends AppCompatActivity {

    String rol = "";
    String playerName;
    String nombreSala;
    ArrayList<String> resultados;
    int turno;

    Button enviar;
    TextView title, tareaTitle, description;
    ImageView imagenTurno;

    DatabaseReference continuarRef, mensajesRef;

    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_telling);


        Bundle extras = getIntent().getExtras();
        rol = extras.getString("rol");
        resultados = extras.getStringArrayList("resultados");
        turno = extras.getInt("turno");
        nombreSala = extras.getString("nombreSala");
        playerName = extras.getString("playerName");

        imagenTurno = findViewById(R.id.imageViewTurno);
        description = findViewById(R.id.textViewDescripcionTurno);
        enviar = findViewById(R.id.button2);
        title = findViewById(R.id.textViewTareaRol);
        tareaTitle = findViewById(R.id.textViewTitulo);
        RadioButton[] radioButtons = {findViewById(R.id.radioButton),findViewById(R.id.radioButton2),
                findViewById(R.id.radioButton3), findViewById(R.id.radioButton4)};

        //Se recupera la base de datos local que contiene la historia
        DbHelper dbH = new DbHelper(StoryTelling.this);
        SQLiteDatabase db = dbH.getWritableDatabase();
        DbDecisions decisions = new DbDecisions(StoryTelling.this);


        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");
        //Se guarda en Firebase una referencia para saber si todos los usuarios han elegido una opción y poder continuar con la historia.
        continuarRef = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("mensajes").child(rol);
        continuarRef.setValue(false);
        mensajesRef = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("mensajes");
        enviar.setEnabled(false);

        //Se detecta si somos el capitán o tripulación para mostrar un tipo de preguntas u otras.
        String rolGeneral ="";
        if (rol.equals("capitan")){
            rolGeneral = rol;
        }
        else{
           rolGeneral = "tripulacion";
        }

        ArrayList<String> historia = decisions.retreaveDecision(String.valueOf(turno),rolGeneral);

        title.setText("TURNO " + turno + " - " + rol.toUpperCase());
        int id = getApplicationContext().getResources().getIdentifier(historia.get(4),null, getApplicationContext().getPackageName());
        imagenTurno.setImageResource(id);
        //Se obtiene la historia de la base de datos y las decisiones según el número de las mismas que se deba mostrar
        for(int i = 0; i<radioButtons.length; i++){
            //Si en algún momento el rol en cuestón no requiere una respuesta, no se muestra las opciones de decisión.
            if(historia.get(i+6) == null){
                radioButtons[i].setVisibility(View.GONE);
            } else { radioButtons[i].setText(historia.get(i+6));}
        }

        //Si no se requiere tomar una decisión, activa el botón de enviar sin necesidad de escoger una decisión.
        if(historia.get(6) == null) enviar.setEnabled(true);

        description.setText(historia.get(5));

        tareaTitle.setText(historia.get(3)+"\n_________________________\n");

        //Si hemos terminado, se cambia el botón del final por "ver resultados".
        if(turno == 18){
            enviar.setText("Ver resultados");
        }

        //Copia del array de resultados
        ArrayList<String> finalHistoria = historia;
        //Se crea el listener del botón de enviar la decisión.
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviar.setEnabled(false);
                enviar.setText("Esperando al resto de la tripulación...");

                //Actualiza en Firebase el valor para continuar con el juego.
                continuarRef.setValue(true);

                //Se inhabilita la selección de otra opción y añade al array de resultados la consecuencia a la opción tomada
                for(int i = 0; i < radioButtons.length; i++){
                    radioButtons[i].setEnabled(false);
                    if(radioButtons[i].isChecked()) resultados.add(finalHistoria.get(i + 10));
                }
                nextTarea();
            }
        });
    }

    //Función que continúa con el flujo de la aplicación.
    private void nextTarea(){
        mensajesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean flag = true;

                //Comprueba que todos los usuarios hayan escogido una opción
                Iterable<DataSnapshot> usuarioContinua = snapshot.getChildren();
                for(DataSnapshot dataSnapshot : usuarioContinua){
                    if(!(boolean) dataSnapshot.getValue()){
                        flag = false;
                    }
                }

                //Si todos han elegido opcion
                if(flag){
                    //Si no hemos llegado al final de la historia
                    if(turno < 18 ) {
                        //Se volvera a llamar a si misma con datos actualizados como Extras del Intent
                        Intent intent = new Intent(getApplicationContext(), StoryTelling.class);
                        intent.putExtra("rol", rol);
                        intent.putExtra("playerName", playerName);
                        intent.putExtra("turno", turno + 1);
                        intent.putExtra("resultados", resultados);
                        intent.putExtra("nombreSala", nombreSala);
                        startActivity(intent);
                        finish();

                    } else {
                        //Si  hemos terminado, se pasará a la Activity de resultados
                        Intent intent2 = new Intent(getApplicationContext(), Results.class);
                        intent2.putExtra("rol", rol);
                        intent2.putExtra("playerName", playerName);
                        intent2.putExtra("resultados", resultados);
                        intent2.putExtra("nombreSala", nombreSala);
                        startActivity(intent2);
                        finish();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Si se escoge una opción, se habilita el botón de enviar.
    public void onRadioButtonClicked(View view) {
        enviar.setEnabled(true);
    }
}