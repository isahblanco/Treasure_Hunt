package com.example.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();

    // Constructor
    public DbHelper(Context context) {
        super(context, StatusContract.DB_NAME, null, StatusContract.DB_VERSION);
    }

    //Metodo que se encarga de crear las columnas de la tabla de la DB SQLite
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format(
                "create table %s (%s int primary key, %s text, %s text," +
                        " %s text, %s text, %s text," +
                        " %s text, %s text, %s text, %s text," +
                        " %s text, %s text, %s text, %s text)",
                StatusContract.TABLE,
                StatusContract.Column.ID,
                StatusContract.Column.ROL,
                StatusContract.Column.ROUND,

                StatusContract.Column.TITLE,
                StatusContract.Column.PHOTO,
                StatusContract.Column.DESCRIPTION,

                StatusContract.Column.BUTTON1DESCRIPTION,
                StatusContract.Column.BUTTON2DESCRIPTION,
                StatusContract.Column.BUTTON3DESCRIPTION,
                StatusContract.Column.BUTTON4DESCRIPTION,

                StatusContract.Column.BUTTON1RESULT,
                StatusContract.Column.BUTTON2RESULT,
                StatusContract.Column.BUTTON3RESULT,
                StatusContract.Column.BUTTON4RESULT);


        db.execSQL(sql);

    }

    //Metodo que se encarga de actualizar la base de datos siempre que se realiza una modificacion
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //En primer lugar se elimina la tabla con todos sus valores
        db.execSQL("drop table if exists " + StatusContract.TABLE);

        //Por ultimo se vuelve a crear para que pueda modificarse sin causar conflictos de integridad
        onCreate(db);
    }
}

