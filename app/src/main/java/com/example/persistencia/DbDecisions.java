package com.example.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DbDecisions extends DbHelper{

    Context context;

    public DbDecisions(Context context) {
        super(context);
        this.context = context;
    }

    /**
     * Clase que se encarga de crear una nueva instancia de usuario en la base de datos SQLite,
     * incluye la descripcion de los botones y su correspondencia con el aspecto al que hace
     * referencia.
     */

    public long createDecision(String id, String rol, String round,
                                String title, String id_photo, String description,
                                String button1Description, String button2Description, String button3Description,
                                String button1Result, String button2Result, String button3Result){

        long resultado = 0;

        try {
            DbHelper dbH = new DbHelper(context);           //inicializa las columnas de la base de datos
            SQLiteDatabase db = dbH.getWritableDatabase();  //devuelve la base de datos creada anteriormente

            ContentValues values = new ContentValues();     //objeto que almacenara los valores de la nueva
                                                            //instancia de la DB

            values.put(StatusContract.Column.ID, id);
            values.put(StatusContract.Column.ROL, rol);
            values.put(StatusContract.Column.ROUND, round);

            values.put(StatusContract.Column.TITLE, title);
            values.put(StatusContract.Column.PHOTO, id_photo);//stakeholder
            values.put(StatusContract.Column.DESCRIPTION, description);

            values.put(StatusContract.Column.BUTTON1DESCRIPTION, button1Description);
            values.put(StatusContract.Column.BUTTON2DESCRIPTION, button2Description);
            values.put(StatusContract.Column.BUTTON3DESCRIPTION, button3Description);

            values.put(StatusContract.Column.BUTTON1RESULT, button1Result);
            values.put(StatusContract.Column.BUTTON2RESULT, button2Result);
            values.put(StatusContract.Column.BUTTON3RESULT, button3Result);

            resultado = db.insert(StatusContract.TABLE, null, values);//inserccion de la nueva instancia
        }
        catch (Exception e){
            e.toString();
        }
        return resultado;
    }
    /**
     * Clase que se encarga de devolver una instancia de usuario de la base de datos SQLite
     * correspondiente a los parametros de condicion introducidos.
     */
    public ArrayList<String> retreaveDecision(String round, String rol){

        DbHelper dbH = new DbHelper(context);           //inicializa las columnas de la base de datos
        SQLiteDatabase db = dbH.getWritableDatabase();  //devuelve la base de datos creada anteriormente

        ArrayList<String> resultado = new ArrayList<>();    //Lista que almacena todos los campos de la consulta

        //metodo que ejecuta la consulta solicitada
        Cursor cursorDecision = db.rawQuery("SELECT * FROM decisions WHERE round=? AND rol=?", new String[]{round, rol});

        cursorDecision.moveToFirst();   //metodo que devuelve la primera instancia de todas las que ha devuelto la consulta
        resultado.add(String.valueOf(cursorDecision.getInt(0)));//_id
        resultado.add(cursorDecision.getString(1));//rol
        resultado.add(cursorDecision.getString(2));//round

        resultado.add(cursorDecision.getString(3));//title
        resultado.add(cursorDecision.getString(4));//foto
        resultado.add(cursorDecision.getString(5));//descripcion

        resultado.add(cursorDecision.getString(6));//button 1 description
        resultado.add(cursorDecision.getString(7));//button 2 description
        resultado.add(cursorDecision.getString(8));//button 3 description
        resultado.add(cursorDecision.getString(9));//button 4 description

        resultado.add(cursorDecision.getString(10));//button 1 result
        resultado.add(cursorDecision.getString(11));//button 2 result
        resultado.add(cursorDecision.getString(12));//button 3 result
        resultado.add(cursorDecision.getString(13));//button 4 result


        return resultado;
    }
}
