package com.example.treasure_hunt;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/*
 Activity que muestra el nombre e información del rol seleccionado
 */
public class InfoRol extends AppCompatActivity {

    String rol = "";
    String playerName = "";
    String nombreSala;

    Button avanzar;
    ImageView role;
    TextView roleName, roleDescription;

    FirebaseDatabase database;
    DatabaseReference startRefRol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rol);

        Bundle extras = getIntent().getExtras();
        rol = extras.getString("rol");
        nombreSala = extras.getString("nombreSala");
        playerName = extras.getString("playerName");

        avanzar = findViewById(R.id.continuar);
        role = findViewById(R.id.imageViewRol);
        roleName = findViewById(R.id.textViewNombreRol);
        roleDescription = findViewById(R.id.textViewDescripcionRol);

        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");
        startRefRol = database.getReference().child("rooms").child(String.valueOf(nombreSala)).child("startGame").child(rol);
        startRefRol.setValue(false);

        //Al pulsar el boton se genera el intent con los recursos necesarios
        //para la siguiente Activity
        avanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avanzar.setEnabled(false);
                avanzar.setText("Levando anclas...");
                Intent intent = new Intent(getApplicationContext(), Introduction.class);
                intent.putExtra("rol", rol);
                intent.putExtra("playerName", playerName);
                intent.putExtra("nombreSala", nombreSala);
                startActivity(intent);
                finish();
            }
        });

        //Muestra el nombre del rol y su información en función del rol
        // seleccionado en la Activity SeleccionRol
        if(rol.equals("capitan")){
            role.setImageResource(R.drawable.captain);
            roleName.setText("-CAPITÁN-");
            roleDescription.setText("Viejo lobo de mar siendo su objetivo principal encontrar " +
                    "el tesoro para poder remodelar su preciado barco. Siempre va acompañado de su " +
                    "loro Blue, a quien le encanta ir contando todo lo que oye. Por las historias que " +
                    "ha oído acerca de los intentos de otros piratas para encontrar el tesoro, " +
                    "sabe que el rumbo hasta llegar al tesoro.");


        } else if(rol.equals("cocinero")) {
                role.setImageResource(R.drawable.cook);
                roleName.setText("-COCINERO-");
                roleDescription.setText("Se encarga de la alimentación de la tripulación y " +
                        "del control de los suministros (agua/ron y comida). " +
                        "Gracias a sus conocimientos en la cocina, suele ser " +
                        "quien se encargue de coser alguna que otra herida.");
        }
        else if(rol.equals("vigia")) {
            role.setImageResource(R.drawable.lookout);
            roleName.setText("-VIGÍA-");
            roleDescription.setText("Persona que se pasa las horas en la cofa oteando el " +
                    "horizonte. Tiene una gran responsabilidad con la tripulación ya que es " +
                    "quien se encarga de avistar tierra o barcos enemigos");
        }
        else if(rol.equals("contramaestre")) {
            role.setImageResource(R.drawable.quarter);
            roleName.setText("-CONTRAMAESTRE-");
            roleDescription.setText("Persona de confianza del capitán que le ha acompañado " +
                    "desde el primer momento que tomó el control del barco. Se encarga de " +
                    "controlar el funcionamiento de la tripulación reportando cualquier tipo " +
                    "de ineficiencia. Uno de sus bienes más preciados es una pequeña brújula " +
                    "que le regaló su padre.");
        }
        else if(rol.equals("timonel")) {
            role.setImageResource(R.drawable.sail);
            roleName.setText("-TIMONEL-");
            roleDescription.setText("Se encarga de gobernar la dirección del barco, por lo que " +
                    "también es una persona de confianza del capitán. Cuando está en tierra " +
                    "le gusta acudir a tabernas para oír historias y conocer nuevas rutas, " +
                    "por lo que sabe que en el norte hay zonas con aguas peligrosas que han " +
                    "causado numerosos naufragios.");
        }
        else if(rol.equals("artillero")) {
            role.setImageResource(R.drawable.gunner);
            roleName.setText("-ARTILLERO-");
            roleDescription.setText("Gran experto en el manejo de las armas, aunque le falte " +
                    "una pierna debido a un abordaje a un barco de la Armada. Conoce una gran" +
                    " cantidad de historias de barcos piratas y de naufragios que le gusta " +
                    "contar a sus compañeros.");
        }
    }
}
