package com.example.treasure_hunt;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import android.os.Environment;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import com.google.firebase.database.FirebaseDatabase;

/*
 Activity que trata y muestra los resultados
 */
public class Results extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 200;

    String rol = "";
    ArrayList<String> resultados = new ArrayList<>();
    String nombreSala;
    String playerName;
    String aux = "";

    TextView tituloResultados, textoResultados;
    Button salirDeResult,descargar;

    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = this.getIntent().getExtras();
        rol = extras.getString("rol");
        resultados = extras.getStringArrayList("resultados");
        nombreSala = extras.getString("nombreSala");
        playerName = extras.getString("playerName");

        tituloResultados = findViewById(R.id.textViewTituloResultados);
        textoResultados = findViewById(R.id.textViewTextoResultados);
        salirDeResult = findViewById(R.id.salirResultados);
        descargar = findViewById(R.id.descargar);

        database = FirebaseDatabase.getInstance("https://treasurehunt-f9edc-default-rtdb.europe-west1.firebasedatabase.app");

        tituloResultados.setText("Resultados del " + rol);

        //Se concatenan los resultados del ArrayList y se les da formato
        for(int i = 0; i < resultados.size(); i++){
            if(i == 0 || i != 0 && !resultados.get(i).equals(""))
            aux = aux +"·   " +resultados.get(i) + "\n\n";
        }
        textoResultados.setText(aux);

        //Comprobamos si se han concedido permisos, si no, se solicitan
        if (checkPermission()) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }

        //Al pulsar el boton se invoca a la función para generar el pdf
        descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePDF(aux);
            }
        });

        //Al pulsar el boton se genera el intent con los recursos necesarios
        //para la siguiente Activity
        salirDeResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rooms.class);
                intent.putExtra("playerName", playerName);
                startActivity(intent);
                finish();
            }
        });
    }

    private void generatePDF(String resultados){

        //Dimensiones PDF
        int pageHeight = 1120;
        int pagewidth = 792;

        PdfDocument pdfDocument = new PdfDocument();
        Paint title = new Paint();

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pagewidth,pageHeight,1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        //Titulo del PDF
        title.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
        title.setTextSize(22);
        title.setColor(ContextCompat.getColor(this, R.color.black));
        canvas.drawText("TREASURE HUNT", 300, 75, title);

        //Subtitulo PDF
        title.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
        title.setTextSize(18);
        title.setColor(ContextCompat.getColor(this, R.color.black));
        canvas.drawText("Resultados del " + rol, 55, 105, title);

        title.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
        title.setTextSize(18);
        title.setColor(ContextCompat.getColor(this, R.color.black));
        canvas.drawText("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯", 50, 115, title);

        //Cuerpo del PDF
        title.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL));
        title.setTextSize(12);
        title.setColor(ContextCompat.getColor(this, R.color.black));

        TextPaint mTextPaint = new TextPaint();
        StaticLayout mTextLayout = new StaticLayout( resultados ,mTextPaint, canvas.getWidth() - 120, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        canvas.save();
        int textX = 50;
        int textY = 125;
        canvas.translate(textX, textY);
        mTextLayout.draw(canvas);
        canvas.restore();
        pdfDocument.finishPage(page);

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Resultados "+rol+".pdf");

        try{
            //Creacion del documento
            pdfDocument.writeTo(new FileOutputStream(file));

            Toast.makeText(Results.this, "El PDF se ha descargado correctamente", Toast.LENGTH_SHORT).show();
        } catch (IOException e){
            e.printStackTrace();
        }
        pdfDocument.close();
    }

    private boolean checkPermission() {
        //Comprobación de permisos
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        //Peticion de permisos
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}
