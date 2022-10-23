package com.example.persistencia;

import android.provider.BaseColumns;

public class StatusContract {//Definicion de la database
    public static final String DB_NAME = "storyBoard.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "decisions";
    public static final String DEFAULT_SORT = Column.ROL + " DESC";

    public class Column {//Definicion de las columnas de la database
        public static final String ID = BaseColumns._ID;

        public static final String ROL = "rol";
        public static final String ROUND = "round";

        public static final String TITLE = "title";
        public static final String PHOTO = "idPhoto";
        public static final String DESCRIPTION = "description";


        public static final String BUTTON1DESCRIPTION = "button1Description";
        public static final String BUTTON2DESCRIPTION = "button2Description";
        public static final String BUTTON3DESCRIPTION = "button3Description";
        public static final String BUTTON4DESCRIPTION = "button4Description";

        public static final String BUTTON1RESULT = "button1Result";
        public static final String BUTTON2RESULT = "button2Result";
        public static final String BUTTON3RESULT = "button3Result";
        public static final String BUTTON4RESULT = "button4Result";


    }
}
