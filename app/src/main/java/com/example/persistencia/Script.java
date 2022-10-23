package com.example.persistencia;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Script {
    //Clase encargada de ejecutar el script completo de la DB SQLite

    public static void script(SQLiteDatabase db){
        ContentValues values = new ContentValues(); //objeto que almacenara los valores de la nueva
                                                    //instancia de la DB

    /****************RONDA_1**********************/
        /*TRIPULACION*/
        values.clear();                             //metodo que resetea los valores almacenados en
                                                    //el objeto values
        values.put(StatusContract.Column.ID, 1);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "1");

        values.put(StatusContract.Column.TITLE, "Preparación del viaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno1");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION, "El viaje hasta la isla del tesoro es una travesía larga y que en ocasiones se puede tornar complicada. Antes de partir, es necesario realizar  una planificación del viaje, recoger y almacenar los víveres...");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Colaboro en la recogida de víveres para ayudar al resto de la tripulación.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Colaboro en la recogida porque el mar es mi pasión.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Colaboro porque quiero encontrar el tesoro.");


        values.put(StatusContract.Column.BUTTON1RESULT, "Se siente identificado con la organización en la que trabaja, por lo que quiere permanecer en dicha organización.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Se identifican con el trabajo que hacen y realmente les importa lo que hacen. Esto influye en su autovaloración.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El trabajador continúa en la organización porque tiene una motivación de carácter económica (salario) que percibirá si se queda y no se marcha.");

        int i = (int) db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_REPLACE);//metodo que ejecuta la inserccion SQL de la nueva instancia

        /*CAPITAN*/
        values.clear();
        values.put(StatusContract.Column.ID, 2);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "1");

        values.put(StatusContract.Column.TITLE, "Preparación del viaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno1");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION, "El viaje hasta la isla del tesoro es una travesía larga y que en ocasiones se puede tornar complicada. Antes de partir, es necesario realizar  una planificación del viaje, recoger y almacenar los víveres...");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Dejar que la tripulación recoja los víveres que considere oportunos.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Decide qué víveres se recogen y que miembro recoge cada tipo.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Consultará con la tripulación la lista de bienes que se tienen que subir a bordo.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Comportamiento de liderazgo pasivo y menos eficaz que consiste en dejar hacer a los trabajadores y no tomar decisiones.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Toma las decisiones por su cuenta, sin tener en cuenta la opinión del resto. Supone tomar decisiones, lo cual es una de las responsabilidades y deberes de un líder.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Capacidad del líder de inspirar a los demás más allá de sus intereses personales inmediatos. Tiene en cuenta al resto de trabajadores en la toma de decisiones, esto puede suponer un problema si siempre toma las decisiones de esto modo ya que no estaría cumpliendo con sus responsabilidades como líder.");

        i = (int) db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_REPLACE);       //metodo que ejecuta la inserccion SQL de la nueva instancia

    /**********************RONDA_2*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 3);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "2");

        values.put(StatusContract.Column.TITLE, "La noche antes del viaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno2");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION, "La noche antes de levar anclas, la tripulación tiene por costumbre juntarse para contar viejas historias de marineros siguiendo el orden de antigüedad. Se juntan mitos con experiencias reales, empapándose todos de una vida de mar.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Acudes a la reunión para escuchar las historias y beber una botella de ron.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Decides no asistir y echarte a dormir, mañana es un día importante.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Realmente no te apetece mucho asistir, pero el resto de la tripulación ha insistido en que será divertido. Acabas aceptando.");


        values.put(StatusContract.Column.BUTTON1RESULT, "La extroversión implica que el individuo tiene un buen nivel de confianza en sus relaciones. Tienden a ser personas gregarias, asertivas y sociales.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La introversión implica un bajo nivel de confianza en sus relaciones. Tienden a ser personas reservadas, tímidas y calladas");
        values.put(StatusContract.Column.BUTTON3RESULT, "La afabilidad es la propensión de un individuo a complacer a los demás. Son personas cooperadoras, cálidas y confiadas");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_REPLACE);

        /*CAPITAN*/
        values.clear();
        values.put(StatusContract.Column.ID, 4);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "2");

        values.put(StatusContract.Column.TITLE, "La noche antes del viaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno2");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION, "La noche antes de levar anclas, la tripulación tiene por costumbre juntarse para contar viejas historias de marineros siguiendo el orden de antigüedad. Se juntan mitos con experiencias reales, empapándose todos de una vida de mar.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_REPLACE);

    /**********************RONDA_3*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 5);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "3");

        values.put(StatusContract.Column.TITLE, "Inicio del viaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno3");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION, "La tripulación ha pasado de contar historias " +
                "acompañados de una botella de ron a ponerse manos a la obra e iniciar el viaje. Cada " +
                "uno realiza sus tareas: unos atando cabos, otros arrienda el velamen... Por el momento " +
                "las condiciones son favorables, el tiempo acompaña. La ruta a seguir no es una cualquiera, " +
                "muchos otros piratas la han iniciado pero ninguno ha conseguido llegar a la isla debido a " +
                "los numerosos peligros. El timonel espera impacientemente la orden del capitán para orientar " +
                "el timón pero el capitán tiene dudas sobre qué hacer.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 6);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "3");

        values.put(StatusContract.Column.TITLE, "Inicio del viaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno3");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION, "La tripulación ha pasado de contar historias " +
                "acompañados de una botella de ron a ponerse manos a la obra e iniciar el viaje. Cada " +
                "uno realiza sus tareas: unos atando cabos, otros arrienda el velamen... Por el momento " +
                "las condiciones son favorables, el tiempo acompaña. La ruta a seguir no es una cualquiera, " +
                "muchos otros piratas la han iniciado pero ninguno ha conseguido llegar a la isla debido a " +
                "los numerosos peligros. El timonel espera impacientemente la orden del capitán para orientar " +
                "el timón pero el capitán tiene dudas sobre qué hacer.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Consultar con el resto de la tripulación el rumbo a tomar.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Guiarse por sus conocimientos en el mar y las estrellas, así como de su intuición, por lo que decide esperar a la noche para hacer un cambio de rumbo.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Seguir el rumbo marcado y ver hacia dónde les lleva.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Si es racional, pedirá ayuda/consejo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La gente con gran estabilidad emocional tiende a ser tranquila, segura y autoconfiada.");
        values.put(StatusContract.Column.BUTTON3RESULT, "");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

    /**********************RONDA_4*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 7);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "4");

        values.put(StatusContract.Column.TITLE, "Cancion pirata");
        values.put(StatusContract.Column.PHOTO, "drawable/turno4");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Hay momentos de la travesía en los que los ánimos " +
                "y actitud de la tripulación decaen por lo que una de las opciones es cantar canciones. La " +
                "travesía es larga y el silencio del mar es abrumador, de manera que las canciones hacen salir a " +
                "la tripulación de la monotonía de sus labores.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Eres el primero que se pone a cantar y animas al resto de la tripulación a que se una a ti.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Esperas a que alguien empiece a cantar y luego te unes.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Decides no cantar porque eso afecta a tu rendimiento.");

        values.put(StatusContract.Column.BUTTON1RESULT, "La extroversión implica la existencia de confianza por parte del individuo con sus relaciones; la apertura implica el rango de intereses y la fascinación por la novedad del individuo (supone que el individuo es creativo, curioso y artísticamente sensible). Favoreces la cohesión del grupo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Relacionado con la afabilidad, es decir, no tiene problemas en complacer a los demás. Favorecer la cohesión del grupo.");
        values.put(StatusContract.Column.BUTTON3RESULT, "La meticulosidad mide la fiabilidad de la persona, por lo que se trata de personas responsables, organizadas, persistentes y fiables. No favoreces la cohesión del grupo.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 8);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "4");

        values.put(StatusContract.Column.TITLE, "Cancion pirata");
        values.put(StatusContract.Column.PHOTO, "drawable/turno4");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Hay momentos de la travesía en los que los ánimos " +
                "y actitud de la tripulación decaen por lo que una de las opciones es cantar canciones. La " +
                "travesía es larga y el silencio del mar es abrumador, de manera que las canciones hacen salir a " +
                "la tripulación de la monotonía de sus labores.\n" +
                "Sabes que las canciones ayudan a fomentar la cohesión de la tripulación y aunque en " +
                "ocasiones pueden hacer que los marineros no trabajen tan bien como debieran.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Animas a la tripulación a cantar canciones piratas, aunque eso ponga en riesgo el desarrollo de sus tareas.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Prohibes que canten cualquier tipo de canción, lo importante es que trabajen y sean eficientes.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Te animas a cantar con el resto de la tripulación.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Se está interesado en mantener buenas relaciones personales con los miembros del grupo. Favoreces la cohesión del grupo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Se está interesado en la productividad de los miembros del grupo. No favoreces la cohesión del grupo.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Se está interesado en mantener buenas relaciones personales con los miembros del grupo. Favoreces la cohesión del grupo.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);


    /**********************RONDA_5*******************************************/

        values.clear();
        values.put(StatusContract.Column.ID, 9);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "5");

        values.put(StatusContract.Column.TITLE, "Nuevo reclutamiento");
        values.put(StatusContract.Column.PHOTO, "drawable/turno5");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"En un barco pirata siempre hay cosas que hacer, " +
                "últimamente la tripulación no tiene mucho tiempo para descansar, lo que está repercutiendo " +
                "en su eficacia. Aprovechando que en un día el barco pasará por Isla Tortuga…");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 10);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "5");

        values.put(StatusContract.Column.TITLE, "Nuevo reclutamiento");
        values.put(StatusContract.Column.PHOTO, "drawable/turno5");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"En un barco pirata siempre hay cosas que hacer, " +
                "últimamente la tripulación no tiene mucho tiempo para descansar, lo que está repercutiendo " +
                "en su eficacia. Aprovechando que en un día el barco pasará por Isla Tortuga…\n" +
                "Pensando en lo mejor para encontrar el tesoro, la idea de introducir nuevos marineros " +
                "es un tanto atractiva. En caso de llevar a cabo el reclutamiento, se les pagará con una parte del botín.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Contratar a 5 marineros más.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "No contratar a nadie, piensas que la tripulación se distrae bastante y que muchas noches se dedican a beber ron. Podrían esforzarse más y evitar distracciones.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "No contratar a nadie, nuestra tripulación puede con el trabajo si todos nos esforzamos.  La gran recompensa merece el esfuerzo de todos.");
        values.put(StatusContract.Column.BUTTON4DESCRIPTION, "Consensuar con el resto de la tripulación.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Toma la decisión más elocuente con la situación, resuelve un problema de forma satisfactoria y suficiente.");
        values.put(StatusContract.Column.BUTTON2RESULT, "El individuo cuando observa la conducta de una persona piensa que esta conducta está bajo el personal de esa persona,menospreciando  las causas externas.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El líder se muestra excesivamente optimista a la hora de tomar decisiones. Esto puede suponer que la persona presenta unas habilidades intelectuales e interpersonales peores.");
        values.put(StatusContract.Column.BUTTON4RESULT, "Capacidad del líder de inspirar a los demás más allá de sus intereses personales inmediatos. Tiene en cuenta al resto de trabajadores en la toma de decisiones, esto puede suponer un problema si siempre toma las decisiones de esto modo ya que no estaría cumpliendo con sus responsabilidades como líder.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);


        /**********************RONDA_6*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 11);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "6");

        values.put(StatusContract.Column.TITLE, "A la caza de la ballena");
        values.put(StatusContract.Column.PHOTO, "drawable/turno6");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"La travesía coincide con el recorrido que realizan las ballenas. " +
                "Durante un día de aguas calmadas y clima cálido, el vigía avista un grupo de ballenas en la lejanía" +
                " fácilmente alcanzables.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 12);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "6");

        values.put(StatusContract.Column.TITLE, "A la caza de la ballena");
        values.put(StatusContract.Column.PHOTO, "drawable/turno6");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"La travesía coincide con el recorrido que realizan las ballenas. " +
                "Durante un día de aguas calmadas y clima cálido, el vigía avista un grupo de ballenas en la lejanía" +
                " fácilmente alcanzables.\n" +
                "Sabes que el aceite que se extrae de las ballenas supone un ingreso importante.");


        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Decides avisar a la tripulación para que preparen los arpones para cazarlas.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Decides no cazarlas, sabes que las ballenas están en peligro de extinción y no te parece correcto.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Decides no cazarlas ya que si lo descubre la Armada te enfrentarías a una multa o incluso ir a prisión.");

        values.put(StatusContract.Column.BUTTON1RESULT, "La toma de decisiones se realiza exclusivamente en función de los resultados o consecuencias, de manera que se pretende proporcionar el mayor bien posible al mayor número de personas.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Implica que el individuo toma decisiones coherentes con las libertades y privilegios fundamentales, por lo que las decisiones que se toman respetan y protegen los derechos básicos de los individuos.");
        values.put(StatusContract.Column.BUTTON3RESULT, "La persona impone y aplica normas de forma justa e imparcial para lograr una distribución equitativa de los beneficios y costes.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);


        /**********************RONDA_7*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 13);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "7");

        values.put(StatusContract.Column.TITLE, "Epidemia");
        values.put(StatusContract.Column.PHOTO, "drawable/turno7");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Últimamente parece que los marineros están cayendo enfermos, " +
                "se piensa que es culpa de la pesca de la semana pasada, porque entre los peces había peces globo. " +
                "Los peces globo tienen una sustancia llamada tetrodo-toxina y puede provocar alteraciones digestivas " +
                "y reacciones alérgicas que, en ocasiones, pueden ser muy graves.\n" +
                "La semana pasada has participado en la pesca, por lo que piensas que te tendrías que " +
                "haber dado cuenta del tipo de pescado que estaba entrando en las redes. Te sientes " +
                "culpable del estado de tus compañeros. ¿Qué haces?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "No dices nada, ya que piensas que otros miembros de la tripulación tienen tareas más relacionadas con este problema.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Te preocupa que el resto de la tripulación pueda considerarte responsable, por lo que te disculpas y prometes tener más cuidado la próxima vez.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Por no enfrentarse al jefe de la pesca, quien tiene una mayor posición dentro del barco, no dijiste nada.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Tendencia de los individuos a esforzarse menos cuando trabajan colectivamente que cuando trabajan individualmente.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Forma en que los demás consideran que debería comportarse un individuo en una determinada situación. La forma en que nos comportamos viene determinada en gran medida por el papel que se tiene en la organización.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El poder que esgrime un individuo sobre los demás: los individuos que controlan los resultados de un grupo con su poder tienden a ser percibidos como individuos de estatus elevado.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 14);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "7");

        values.put(StatusContract.Column.TITLE, "Epidemia");
        values.put(StatusContract.Column.PHOTO, "drawable/turno7");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Últimamente parece que los marineros están cayendo enfermos, " +
                "se piensa que es culpa de la pesca de la semana pasada, porque entre los peces había peces globo. " +
                "Los peces globo tienen una sustancia llamada tetrodo-toxina y puede provocar alteraciones digestivas " +
                "y reacciones alérgicas que, en ocasiones, pueden ser muy graves.\n" +
                "Ante esta grave situación tienes que repartir las medicinas. El principal problema es que " +
                "son escasas para toda la tripulación y el tiempo se está agotando.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Reparte la medicación en función del rango que se ocupa dentro de la tripulación.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Reparte la medicación a los miembros de la tripulación más antiguos y con los que tienes una mayor confianza.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Reparte la medicación en función de quien considera imprescindible para encontrar el tesoro.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Grado de influencia del líder sobre aspectos clave como contratar, despedir, disciplinar, dar promociones o incrementos salariales... El líder es visto como un individuo de estatus elevado.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Grado de seguridad, confianza y respeto que tienen los miembros en el líder. Un individuo cuyas características personales son valoradas positivamente por el grupo tiende normalmente a tener un estatus superior al de un individuo con atributos menos valorados.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Los individuos cuyas contribuciones son críticas para el éxito del grupo tienden a disfrutar de un elevado estatus.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        /**********************RONDA_8*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 15);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "8");

        values.put(StatusContract.Column.TITLE, "Reasignación de tareas");
        values.put(StatusContract.Column.PHOTO, "drawable/turno8");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"A raíz de la epidemia hay tareas cotidianas que " +
                "se han visto desatendidas pero que son cruciales para el buen funcionamiento del barco.\n" +
                "Como hemos dicho en un barco pirata hay muchas cosas que hacer, ¿qué te parecería cargar " +
                "con el trabajo de tus compañeros?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Lo haría sin ningún problema, ya que sé que mis compañeros lo harían por mí.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Lo haría sin ningún problema porque nuestro objetivo es llegar a la isla y encontrar el tesoro.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Lo haría aunque esto suponga una saturación de trabajo y puede conllevar a peleas entre la tripulación.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Apego emocional hacia la organización y sus valores.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Valor económico percibido de permanecer en una organización en comparación con irse de la misma.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Obligación percibida de permanecer en la organización por cuestiones morales o éticas.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 16);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "8");

        values.put(StatusContract.Column.TITLE, "Reasignación de tareas");
        values.put(StatusContract.Column.PHOTO, "drawable/turno8");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"A raíz de la epidemia hay tareas cotidianas que " +
                "se han visto desatendidas pero que son cruciales para el buen funcionamiento del barco.\n" +
                "sabes que esas tareas que están desatendidas son cruciales para llegar al tesoro, " +
                "por lo que se te ocurre que una reasignación de tareas puede ser la solución");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Modificas la rutina de la tripulación para realizar sus tareas, de manera que la realización de las suyas y las desatendidas no suponga un esfuerzo a mayores. La realización de este cambio puede beneficiar la productividad de la tripulación.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Piensas en repartir esas tareas basándote en que las nuevas se parezcan a las que ya realizan. De esta manera la tripulación será más eficaz y se especializará en una labor.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Al principio del viaje repartiste las tareas de cada miembro en función de sus capacidades, por lo que el hacer un cambio en eso puede suponer un retraso. Mantienes esa asignación de tareas y las desatendidas se reparten entre todos.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Cuando en la organización se detecta un error, se corrige mediante la modificación de los objetivos, políticas y rutinas de la organización.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Basada en la especialización, crea muros que separan a las distintas funciones independientes. Da importancia a la experiencia obtenida para incrementar la autoeficacia, si se ha podido realizar la tarea con éxito anteriormente, tendrá más confianza en poder volvero a hacer en el futuro.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Cuando se detectan errores, el proceso de correción recurre a las rutinas pasadas y a las políticas actuales.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        /**********************RONDA_9*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 17);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "9");

        values.put(StatusContract.Column.TITLE, "Al abordaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno9");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Es conveniente que un barco pirata siempre esté" +
                " preparado para afrontar los peligros que trae la mar. La labor del vigía es " +
                "preverlos y la del artillero afrontarlos. Pues bien ha llegado la hora de ponernos a prueba. " +
                "El vigía grita: “¡¡Barco corsario a la vista!!”");


        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 18);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "9");

        values.put(StatusContract.Column.TITLE, "Al abordaje");
        values.put(StatusContract.Column.PHOTO, "drawable/turno9");
        values.put(StatusContract.Column.DESCRIPTION,"Es conveniente que un barco pirata siempre esté" +
                " preparado para afrontar los peligros que trae la mar. La labor del vigía es " +
                "preverlos y la del artillero afrontarlos. Pues bien ha llegado la hora de ponernos a prueba. " +
                "El vigía grita: “¡¡Barco corsario a la vista!!”\n" +
                "Reconoces la bandera, se trata de uno de los barcos corsarios más temidos de los 7 mares. " +
                "En tus manos está abordar el barco o no.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Decides abordarlo a pesar del riesgo que conlleva. Los posibles beneficios y el abastecimiento de víveres pueden ser necesarios para concluir la expedición.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Decides no abordarlo al reconocer la bandera, ya has tenido problemas con ellos y prefieres evitarlos.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Consensuar con la tripulación la decisión.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Influencia sobre los agentes que toman las decisiones sugiriendo cuáles son las elecciones preferibles en cuanto a recompensa personal.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La toma de decisiones se realiza en un contexto, por lo que lo ocurrido en el pasado puede afectar a las decisiones presentes.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Capacidad del líder de inspirar a los demás más allá de sus intereses personales inmediatos. Tiene en cuenta al resto de trabajadores en la toma de decisiones, esto puede suponer un problema si siempre toma las decisiones de esto modo ya que no estaría cumpliendo con sus responsabilidades como líder.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        /**********************RONDA_10*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 19);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "10");

        values.put(StatusContract.Column.TITLE, "Tormenta");
        values.put(StatusContract.Column.PHOTO, "drawable/turno10");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Nubes negras empiezan a cubrir el cielo y luces de relámpagos " +
                "brillan en el horizonte. La travesía de nuestro barco se dirige directamente al centro de una tormenta. " +
                "Esto podría afectar tanto a la integridad del barco como a la de la tripulación.\n" +
                "Como se trata de una situación excepcional, es muy importante la colaboración de todos " +
                "los miembros para asegurar el velamen, lo cual genera cierto estrés en cubierta");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "El trabajar bajo presión lo ves como una oportunidad para mostrar tu destreza a la hora de hacer nudos.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Trabajar bajo presión no es lo tuyo, y aunque te esfuerces al máximo los nudos no te saldrán igual que si los hicieras tranquilamente.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Ante la llegada de la tormenta, realizas la aseguración del velamen de forma tranquila y sin preocuparte por dicha situación.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Estrés relacionado con los retos del entorno laboral que favorece la actividad del individuo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Estrés que le impide a uno alcanzar sus metas.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El estrés no genera ningún tipo de influencia sobre el individuo.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 20);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "10");

        values.put(StatusContract.Column.TITLE, "Tormenta");
        values.put(StatusContract.Column.PHOTO, "drawable/turno10");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Nubes negras empiezan a cubrir el cielo y luces de relámpagos " +
                "brillan en el horizonte. La travesía de nuestro barco se dirige directamente al centro de una tormenta. " +
                "Esto podría afectar tanto a la integridad del barco como a la de la tripulación.\n" +
                "Por tu experiencia sabes que ante la llegada de una tormenta es importante mantener la calma y asegurar el " +
                "velamen de una forma correcta. Pero en ocasiones la presión que esta situación genera " +
                "sobre la tripulación puede afectar a su desempeño.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Piensas que estas situaciones suponen un reto para la tripulación, por lo que tras el paso de la tormenta, el ver que las velas están en perfecto estado  generará satisfacción entre los miembros.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Prefieres evitar las tormentas, ya que la presión que genera sobre los trabajadores tiene efectos negativos en su desempeño.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Ves la tormenta como un contratiempo para encontrar el tesoro, lo cual genera un estrés tanto para la tripulación como para ti mismo.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Estrés relacionado con los retos del entorno laboral que favorece la actividad del individuo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Estrés relacionado con los retos del entorno laboral que perjudica la actividad del individuo.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Estrés que le impide a uno alcanzar sus metas");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        /**********************RONDA_11*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 21);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "11");

        values.put(StatusContract.Column.TITLE, "Vela rota");
        values.put(StatusContract.Column.PHOTO, "drawable/turno11");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Debido a la tormenta, la vela del mástil mayor " +
                "se ha visto dañada impidiendo que se pueda seguir navegando a no ser que se repare de alguna forma. " +
                "En el barco no hay una vela de repuesto, por lo que hay que buscar otra solución. ¿Qué opinas " +
                "que sería lo mejor para resolver este inconveniente?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Lo mejor es contar con alguien en la tripulación que sepa manejar una aguja e hilo.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Reunir a un grupo creativo, que utilicen alguno de los elementos del barco para arreglar la vela, por ejemplo, que utilicen los cuadros del camarote del capitán para coser la vela.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Consideras que arreglar la vela rota en medio del mar es todo un reto, por lo que utilizas tus capacidades y habilidades para llevarlo a cabo.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Se promueve el potencial cuando los individuos tienen habilidades, conocimientos, competencias y experencia.");
        values.put(StatusContract.Column.BUTTON2RESULT, "El individuo es más creativo cuando tiene un buen estado de ánimo. El individuo presenta características de la personalidad relacionadas con la creatividad, la habilidad de utilizar analogías y el talento de ver las cosas desde otra perspectiva.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El deseo de trabajar en algo porque es interesante, apasionante, excitante, satisfactorio o constituye un reto persona.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 22);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "11");

        values.put(StatusContract.Column.TITLE, "Vela rota");
        values.put(StatusContract.Column.PHOTO, "drawable/turno11");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Debido a la tormenta, la vela del mástil mayor " +
                "se ha visto dañada impidiendo que se pueda seguir navegando a no ser que se repare de alguna forma. " +
                "En el barco no hay una vela de repuesto, por lo que hay que buscar otra solución. ¿Qué opinas " +
                "que sería lo mejor para resolver este inconveniente?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Lo mejor es contar con alguien en la tripulación que sepa manejar una aguja e hilo.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Reunir a un grupo creativo, que utilicen alguno de los elementos del barco para arreglar la vela, por ejemplo, que utilicen los cuadros del camarote del capitán para coser la vela.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Consideras que arreglar la vela rota en medio del mar es todo un reto, por lo que utilizas tus capacidades y habilidades para llevarlo a cabo.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Se promueve el potencial cuando los individuos tienen habilidades, conocimientos, competencias y experencia.");
        values.put(StatusContract.Column.BUTTON2RESULT, "El individuo es más creativo cuando tiene un buen estado de ánimo. El individuo presenta características de la personalidad relacionadas con la creatividad, la habilidad de utilizar analogías y el talento de ver las cosas desde otra perspectiva.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El deseo de trabajar en algo porque es interesante, apasionante, excitante, satisfactorio o constituye un reto persona.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        /**********************RONDA_12*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 23);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "12");

        values.put(StatusContract.Column.TITLE, "Los rumores del loro Blue");
        values.put(StatusContract.Column.PHOTO, "drawable/turno12");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Todo el mundo sabe que los asuntos que se tratan " +
                "en el camarote principal son confidenciales, estando bajo la atenta mirada de Blue, " +
                "el loro del capitán. Cuando el capitán está ocupado deja al contramaestre a cargo del loro; " +
                "una de estas veces, el contramaestre tiene un descuido y deja abierta la jaula, por lo que " +
                "Blue vuela a su antojo por el barco. \n" +
                "\n" +
                "Al loro se le escucha decir: “Somos demasiados”; “El tesoro”;  “Se acaba”. Ante estas palabras " +
                "la tripulación empieza a dudar y aumenta su grado de nerviosismo.\n" +
                "Sabes que Blue no es más que un loro, pero que repite lo que oye. Personalmente que piensas:");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Simplemente es un loro un tanto parlanchín, por lo que no te crees nada que no provenga directamente del capitán.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "“Si el río suena, agua lleva”. Tienes cierta preocupación, pues te parece lógico que el loro haya repetido lo que se ha hablado en el camarote.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "El loro te ha dado en qué pensar y decides hablarlo con el resto de la tripulación para ver si también están preocupados y hacéis algo al respecto.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Atributo favorable para el individuo al dar más importancia a la información formal sobre la informal.");
        values.put(StatusContract.Column.BUTTON2RESULT, "El individuo minimiza las consecuencias negativas de los rumores al limitar su alcance y su impacto.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Puede tener consecuencias negativas en el desempeño del individuo. En situaciones de ambigüedad, donde la información no es completa, podrá generar estrés en la plantilla.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 24);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "12");

        values.put(StatusContract.Column.TITLE, "Los rumores del loro Blue");
        values.put(StatusContract.Column.PHOTO, "drawable/turno12");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Todo el mundo sabe que los asuntos que se tratan " +
                "en el camarote principal son confidenciales, estando bajo la atenta mirada de Blue, " +
                "el loro del capitán. Cuando el capitán está ocupado deja al contramaestre a cargo del loro; " +
                "una de estas veces, el contramaestre tiene un descuido y deja abierta la jaula, por lo que " +
                "Blue vuela a su antojo por el barco. \n" +
                "\n" +
                "Al loro se le escucha decir: “Somos demasiados”; “El tesoro”;  “Se acaba”. Ante estas palabras " +
                "la tripulación empieza a dudar y aumenta su grado de nerviosismo.\n" +
                "Sales a cubierta para dar tu paseo rutinario y encuentras a Blue  repitiendo las mismas " +
                "frases una y otra vez, y a la tripulación un tanto desconcertada. ¿Qué haces al respecto?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Aunque el asunto parece que se va calmando, decides aclararlo y dar explicaciones de esas conversaciones del camarote.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Como la conversación del camarote no tiene nada que ver con la tripulación, optas por no decir nada.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Aunque no te gusta que la tripulación vaya extendiendo rumores por el barco, esto te permite conocer sus preocupaciones acerca del tesoro.");

        values.put(StatusContract.Column.BUTTON1RESULT, "El líder minimiza las consecuencias negativas de los rumores al limitar su alcance y su impacto, lo cual no puede generar tanta ansiedad como la que genera un hecho imaginado del que no se habla en la organización.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La actitud pasiva de un líder ante rumores no favorece la resolución de situaciones ambiguas en el lugar de trabajo, provocando un clima laboral negativo y estrés.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El líder tiene la oportunidad de hacerse una idea de la moral de la organización.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);
        /**********************RONDA_13*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 25);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "13");

        values.put(StatusContract.Column.TITLE, "Motín");
        values.put(StatusContract.Column.PHOTO, "drawable/turno13");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"La travesía por la búsqueda del tesoro se está alargando más de lo previsto.  " +
                "Además, hay que tener en cuenta las diferentes situaciones de estrés y presión que se han vivido " +
                "desde que comenzó la travesía (el reclutamiento de nueva tripulación, la tormenta, los rumores de Blue…), " +
                "por lo que el ambiente en cubierta es bastante tenso. \n" +
                "\n" +
                "En bastantes ocasiones, los tripulantes no se ponen de acuerdo en como hacer ciertas tareas. Pues" +
                " aunque tradicionalmente se venían desarrollando de cierta manera y existen defensores acérrimos" +
                " de esa forma de hacerlo porque resulta eficaz , otros discuten por hacerlo con otro procedimiento. \n");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "No te agrada la situación, la tensión no es buena para tener un ambiente agradable el viaje, y por tanto para evitar que el problema llegue a más, sigues el proceder tradicional del barco.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Piensas que aunque no sea el mejor ambiente para el barco, es natural que la gente discuta en el modo de hacer las cosas y que esta situación puede en cierta forma, resultar positiva.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Esta situación no te supone ningún inconveniente, incluso te gusta participar en los conflictos dando tu punto de vista, pues lo ves como una forma de que la tripulación avance en sus objetivo.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Se piensa que es necesario evitar los conflictos ya que para esta perspectiva indican un mal funcionamiento dentro del grupo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Sobre el conflicto se piensa que es el resultado natural e inevitable en cualquier grupo, y que no tiene por qué ser algo malo, sino que tiene más bien el potencial de ser una fuerza que afecta de forma positiva el desempeño del grupo.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Sobre el conflicto se piensa que es absolutamente necesario que exista en cierto grado para que el grupo pueda tener un desempeño eficaz, por tanto se ve el conflicto como algo bueno que tiene el potencial de ser una fuerza que afecta de forma positiva el desempeño del grupo.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 26);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "13");

        values.put(StatusContract.Column.TITLE, "Motín");
        values.put(StatusContract.Column.PHOTO, "drawable/turno13");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"La travesía por la búsqueda del tesoro se está alargando más de lo previsto.  " +
                "Además, hay que tener en cuenta las diferentes situaciones de estrés y presión que se han vivido " +
                "desde que comenzó la travesía (el reclutamiento de nueva tripulación, la tormenta, los rumores de Blue…), " +
                "por lo que el ambiente en cubierta es bastante tenso. \n" +
                "\n" +
                "En bastantes ocasiones, los tripulantes no se ponen de acuerdo en como hacer ciertas tareas. Pues" +
                " aunque tradicionalmente se venían desarrollando de cierta manera y existen defensores acérrimos" +
                " de esa forma de hacerlo porque resulta eficaz , otros discuten por hacerlo con otro procedimiento. \n" +
                " Las tensiones existentes entre la tripulación pueden suponer un motín en tu contra.");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Toma medidas para tratar de solucionar el conflicto y evitar un posible motín.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "No hace nada, deja que el contramaestre decida.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Decide tomar represalias contra aquellos que han creado los conflictos - pasear por la tabla.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Negociación distributiva.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Negociación integradora.");
        values.put(StatusContract.Column.BUTTON3RESULT, "No negociación.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);
        /**********************RONDA_14*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 27);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "14");

        values.put(StatusContract.Column.TITLE, "Llega la armada");
        values.put(StatusContract.Column.PHOTO, "drawable/turno14");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"El tiempo que se pasa en el mar hace que la tripulación se vaya conociendo " +
                "poco a poco y se cuenten confidencias acerca de su vida en tierra firme. En un día de zonas calmas y " +
                "con ausencia de viento, la tripulación se puso a hablar de como se iniciaron en el mundo de la piratía. " +
                "Uno de los miembros de la tripulación, trabajador y admitido por el resto, relató su historia: “Serví " +
                "durante 10 años en la Armada de su majestad. Dimos caza a cientos de piratas, se apresó, torturó y juzgó" +
                " injustamente a muchos. En la última de las escaramuzas, me encontré con un joven asustado de no más de" +
                " 12 años que servía a las órdenes de un pirata que llevaba tiempo atemorizando y burlando a la Armada. Mi" +
                " capitán por aquel entonces quería hacer pagar las mofas de las que había sido objeto, sin importarle" +
                " quien fuera colgado. Decidí liberarlo, solo era un niño… Y tomar esa decisión hizo que huyera a Isla Tortuga" +
                " y ahora sea yo quien busca mi capitán sin cesar”.\n" +
                " A lo lejos se divisa el casco de un barco, con la bandera de Inglaterra, que se aproxima. Descubres que es la Armada y que pregunta " +
                "por tu camarada pirata. Intuyendo que el resto de la tripulación protegerá al compañero haciendo honor al código pirata, ¿qué haces?\n");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "La traición a un capitán es algo grave, tanto como para delatarlo a pesar de que dicha traición haya sido realizada a un oficial de la Armada. Les dices que el hombre que buscan está en el barco.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "A pesar de que la traición es algo intolerable en un barco pirata, decides no delatarlo para que el resto no piense que tú serías capaz de delatar a un compañero.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Como el resto de la tripulación lo considera un buen hombre y delatarlo retrasaría el viaje, no lo delatas y lo cubres ante la Armada. Ante todo hay que respetarse entre piratas y cumplir el código.");

        values.put(StatusContract.Column.BUTTON1RESULT, "La sinceridad es un atributo de cierta importancia en un trabajador que garantiza un buen ambiente de trabajo a pesar de que las opiniones entre los miembros del equipo sean distintas. El individuo expresa su punto de vista sin realizar las tareas automáticamente; su opinión sirve para que el directivo o jefe conozca las opiniones de sus trabajadores.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La expectativa de rol es la forma en que el resto de los individuos consideran que debería comportarse en determinada situación. La presión social es una de las desventajas del trabajo en grupo y que lleva al individuo a realizar actos con los que no está de acuerdo por miedo a la reacción de sus compañeros. Supone una pérdida de valor tanto para el trabajador como para la empresa al no expresar su punto de vista o idea.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Busca como individuo la aceptación en el grupo por lo que trata de ajustarse a las normas del grupo.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 28);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "14");

        values.put(StatusContract.Column.TITLE, "Llega la armada");
        values.put(StatusContract.Column.PHOTO, "drawable/turno14");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"El tiempo que se pasa en el mar hace que la tripulación se vaya conociendo " +
                "poco a poco y se cuenten confidencias acerca de su vida en tierra firme. En un día de zonas calmas y " +
                "con ausencia de viento, la tripulación se puso a hablar de como se iniciaron en el mundo de la piratía. " +
                "Uno de los miembros de la tripulación, trabajador y admitido por el resto, relató su historia: “Serví " +
                "durante 10 años en la Armada de su majestad. Dimos caza a cientos de piratas, se apresó, torturó y juzgó" +
                " injustamente a muchos. En la última de las escaramuzas, me encontré con un joven asustado de no más de" +
                " 12 años que servía a las órdenes de un pirata que llevaba tiempo atemorizando y burlando a la Armada. Mi" +
                " capitán por aquel entonces quería hacer pagar las mofas de las que había sido objeto, sin importarle" +
                " quien fuera colgado. Decidí liberarlo, solo era un niño… Y tomar esa decisión hizo que huyera a Isla Tortuga" +
                " y ahora sea yo quien busca mi capitán sin cesar”.\n" +
                " A lo lejos se divisa el casco de un barco, con la bandera de Inglaterra, que se aproxima. Descubres que es la Armada y que pregunta " +
                "por tu camarada pirata. Intuyendo que el resto de la tripulación protegerá al compañero haciendo honor al código pirata, ¿qué haces?\n");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "La traición a un capitán es algo grave, tanto como para delatarlo a pesar de que dicha traición haya sido realizada a un oficial de la Armada. Les dices que el hombre que buscan está en el barco.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "A pesar de que la traición es algo intolerable en un barco pirata, decides no delatarlo para que el resto no piense que tú serías capaz de delatar a un compañero.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Como el resto de la tripulación lo considera un buen hombre y delatarlo retrasaría el viaje, no lo delatas y lo cubres ante la Armada. Ante todo hay que respetarse entre piratas y cumplir el código.");

        values.put(StatusContract.Column.BUTTON1RESULT, "La sinceridad es un atributo de cierta importancia en un trabajador que garantiza un buen ambiente de trabajo a pesar de que las opiniones entre los miembros del equipo sean distintas. El individuo expresa su punto de vista sin realizar las tareas automáticamente; su opinión sirve para que el directivo o jefe conozca las opiniones de sus trabajadores.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La expectativa de rol es la forma en que el resto de los individuos consideran que debería comportarse en determinada situación. La presión social es una de las desventajas del trabajo en grupo y que lleva al individuo a realizar actos con los que no está de acuerdo por miedo a la reacción de sus compañeros. Supone una pérdida de valor tanto para el trabajador como para la empresa al no expresar su punto de vista o idea.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Busca como individuo la aceptación en el grupo por lo que trata de ajustarse a las normas del grupo.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);
        /**********************RONDA_15*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 29);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "15");

        values.put(StatusContract.Column.TITLE, "Tierra a la vista");
        values.put(StatusContract.Column.PHOTO, "drawable/turno15");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Después de un largo viaje el vigía grita desde la cofa la " +
                "frase que todos desean oír: “Tierra a la vista”. Una vez echado el ancla en la " +
                "costa de la isla, es necesario que el capitán organice la tripulación en botes, decidir quién " +
                "se queda cuidando el barco y qué tareas se van a realizar en tierra.\n" +
                "Pone en duda la forma de organizar la llegada a la isla propuesta por el capitán, de hecho usted " +
                "tiene mejores ideas. El problema es que el capitán se muestra reacio. ¿Cómo haría cambiar al capitán de opinión?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Irías a hablar con él, recordándole que elegiste formar parte de su tripulación por considerarlo un gran pirata y que llevas mucho tiempo con él. Piensas que eso es razón para que tenga en cuenta tu idea.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Irías a hablar con él detallando todos los aspectos de tu idea y demostrándole que es mejor que la suya.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Piensas que lo mejor es hacer que piense que tu idea es la suya, y le propones esa idea en forma de una consulta.");
        values.put(StatusContract.Column.BUTTON4DESCRIPTION, "Recuerdas al capitán que hay mucha gente está dispuesta a desobedecer sus órdenes,  y que tu idea está más apoyada dentro de la tripulación, por lo que si cambia de opinión será beneficioso para todos.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Utilización de halagos, alabanzas o una conducta amistosa para hacer una petición.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Presentación de argumentos lógicos y de hechos para demostrar que la petición es razonable. Es una buena táctica de poder a la hora de lograr influenciar al individuo y a valorar en un empleado.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Aumento de la motivación y respaldo del individuo objetivo, involucrándolo en la decisión de cómo realizar el plan o el cambio");
        values.put(StatusContract.Column.BUTTON4RESULT, "Utilización de advertencias, solicitudes repetidas y amenazas. Quienes usan este tipo de tácticas de poder tendrán a largo plazo consecuencias negativas");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 30);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "15");

        values.put(StatusContract.Column.TITLE, "Tierra a la vista");
        values.put(StatusContract.Column.PHOTO, "drawable/turno15");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Después de un largo viaje el vigía grita desde la cofa la " +
                "frase que todos desean oír: “Tierra a la vista”. Una vez echado el ancla en la " +
                "costa de la isla, es necesario que el capitán organice la tripulación en botes, decidir quién " +
                "se queda cuidando el barco y qué tareas se van a realizar en tierra.\n" +
                "Tu puesto implica tomar diversas decisiones como la organización de la tripulación, pero las distintas " +
                "situaciones vividas a lo largo del viaje ha favorecido que la tripulación ponga en duda tu capacidad de " +
                "liderazgo. ¿Qué crees que es mejor para que acaten tus órdenes?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Tu tripulación te debe sumisión, es tu barco y puedes echarles, no puedes consentir faltas de respeto como que se te ponga en duda.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Necesitas a tu tripulación por lo que la mejor opción es recordarles que el objetivo es el tesoro, que tenéis que trabajar juntos, y que tu manera de organizarlas es rápido y eficaz.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Al entrar en el barco todos han aceptado que tú les guies, por lo que les recuerdas, que el que no te obedecieran sería un riesgo muy grande.");
        values.put(StatusContract.Column.BUTTON4DESCRIPTION, "Llevas muchísimos años en el mar, de hecho eres el miembro que cuenta con más experiencia y conocimientos sobre el mar. Lo más inteligente es que te obedezcan por ello.");

        values.put(StatusContract.Column.BUTTON1RESULT, "Ejercer el poder basado en la coerción hace que los empleados obedezcan por miedo a resultados negativos en caso de no hacerlo. Descansa en la aplicación o amenaza de sanciones.");
        values.put(StatusContract.Column.BUTTON2RESULT, "Contrario al poder de coerción. Los individuos acatan voluntariamente este tipo de órdenes porque al hacerlo obtienen beneficios, por lo que el líder que ofrezca recompensas valoradas positivamente por el resto tendrá el poder sobre esas personas.");
        values.put(StatusContract.Column.BUTTON3RESULT, "Representa la autoridad formal de controlar y utilizar los recursos de la organización. El cargo de autoridad es más genérico que el poder de coerción y el de recompensa; concretamente incluye la aceptación de la autoridad de quien ostenta un cargo por parte de los miembros de la organización.");
        values.put(StatusContract.Column.BUTTON4RESULT, "Influencia que se ejerce gracias a la pericia, habilidad especial o conocimientos que se tienen. Ha medida que los puestos se especializan se depende cada vez más de expertos para alcanzar las metas, por lo que este poder tiene una importancia en aumento.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);
        /**********************RONDA_16*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 31);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "16");

        values.put(StatusContract.Column.TITLE, "A por el tesoro");
        values.put(StatusContract.Column.PHOTO, "drawable/turno16");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Una vez alcanzada la isla del tesoro, la tripulación tiene " +
                "que seguir al pie del cañón pues aún falta encontrar el lugar exacto donde está enterrado el tesoro: habrá " +
                "que hacer un reconocimiento del terreno, seguir el mapa... Lo mejor es dividirse por grupos, ya que de " +
                "esa forma el terreno a cubrir será mayor.\n" +
                "Si pudieses elegir el grupo con el que vas  a buscar el tesoro, ¿en función de qué lo seleccionarías?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Amistad.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Te interesa el tesoro. Buscas la consecución de metas, por eso decides unirte al grupo que más contacto tiene con el capitán, así dispondrás de información más valiosa.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Los peligros en la isla son desconocidos, te unes a miembros de la tripulación que sean fuertes.");
        values.put(StatusContract.Column.BUTTON4DESCRIPTION, "Quieres ser uno de los miembros de la tripulación que desentierre el tesoro (te gustaría que cuando cuenten la historia acerca de esta búsqueda, tu nombre sea uno de los mencionados), por eso te unes al grupo del capitán. El capitán es quien lleva el mapa, es más probable que encuentre el tesoro.");

        values.put(StatusContract.Column.BUTTON1RESULT, "El individuo busca pertenecer a un grupo en base a la tenencia de una o más características comunes. Se suelen formar más allá del ámbito de trabajo.");
        values.put(StatusContract.Column.BUTTON2RESULT, "El individuo busca pertenecer a un grupo con el que pueda lograr de forma grupal aquello que haciéndolo por su cuenta no es capaz. El ser muchos da poder.");
        values.put(StatusContract.Column.BUTTON3RESULT, "El individuo busca la inclusión en el grupo con el objetivo de no “estar solo”. Los individuos que buscan formar grupos con este propósito se sienten más fuertes, tienen menos dudas de si mismos, y son más resistentes a las amenazas cuando forman parte de un grupo.");
        values.put(StatusContract.Column.BUTTON4RESULT, "El individuo busca unirse a grupos en base a que le proporcione reconocimiento y estatus.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 32);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "16");

        values.put(StatusContract.Column.TITLE, "A por el tesoro");
        values.put(StatusContract.Column.PHOTO, "drawable/turno16");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Una vez alcanzada la isla del tesoro, la tripulación tiene " +
                "que seguir al pie del cañón pues aún falta encontrar el lugar exacto donde está enterrado el tesoro: habrá " +
                "que hacer un reconocimiento del terreno, seguir el mapa... Lo mejor es dividirse por grupos, ya que de " +
                "esa forma el terreno a cubrir será mayor.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);
        /**********************RONDA_17*******************************************/
        values.clear();
        values.put(StatusContract.Column.ID, 33);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "17");

        values.put(StatusContract.Column.TITLE, "Reparto del botín");
        values.put(StatusContract.Column.PHOTO, "drawable/turno17");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Siguiendo el mapa del tesoro, el capitán detiene a " +
                "la tripulación que lo acompaña frente a un imponente acantilado. Allí, sin demora alguna, " +
                "se empieza a cavar. Bajo un montón de arena, tal y como contaban las historias, el  viejo " +
                "cofre contenía el tesoro de un barco de la Armada.\n" +
                "Desenterrado el botín es hora de recibir la recompensa por el trabajo realizado este tiempo en la mar. Sabes que el capitán es justo y por tanto recompensará tu labor.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 34);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "17");

        values.put(StatusContract.Column.TITLE, "Reparto del botín");
        values.put(StatusContract.Column.PHOTO, "drawable/turno17");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"Siguiendo el mapa del tesoro, el capitán detiene a " +
                "la tripulación que lo acompaña frente a un imponente acantilado. Allí, sin demora alguna, " +
                "se empieza a cavar. Bajo un montón de arena, tal y como contaban las historias, el  viejo " +
                "cofre contenía el tesoro de un barco de la Armada.\n" +
                "Como almas que lleva el diablo, todos te están mirando expectantes para el reparto del tesoro. " +
                "Cómo repartirlo es la cuestión que hará que la tripulación quede o no satisfecha. ¿En base a qué criterio te parece mejor hacer ese reparto?");

        values.put(StatusContract.Column.BUTTON1DESCRIPTION, "Decides dar a los miembros de la tripulación que más se han implicado durante la travesía una mayor proporción del tesoro que a aquellos que simplemente han realizado sus tareas.");
        values.put(StatusContract.Column.BUTTON2DESCRIPTION, "Decides repartir el tesoro en función del puesto que ocupan los miembros dentro de la tripulación. De esta forma tú serás el que tenga un mayor beneficio, seguido del contramaestre, timonel, artillero, cocinero, vigía y resto de grumetes.");
        values.put(StatusContract.Column.BUTTON3DESCRIPTION, "Decides repartir el botín entre todos por igual, ya que todos habéis llegado a la isla y lo habéis encontrado por haber trabajo en equipo.");

        values.put(StatusContract.Column.BUTTON1RESULT, "La retribución por la labor realizada depende de los resultados en las evaluaciones de desempeño. Esto beneficia a la organización, ya que es una importante fuente motivacional para el individuo; sin embargo, esas evaluaciones de desempeño no siempre son válidas.");
        values.put(StatusContract.Column.BUTTON2RESULT, "La retribución que percibirá el empleado depende del puesto que tenga dentro de la organización, por lo que cuanta mayor importancia se tenga, el salario que se perciba será mayor.");
        values.put(StatusContract.Column.BUTTON3RESULT, "La retribución igualitaria no diferencia entre los puestos o la actividad realizada para la consecución del fin. Todos los miembros que han participado en esas tareas reciben la misma retribución.");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        /********************FINAL***************************/
        values.clear();
        values.put(StatusContract.Column.ID, 35);
        values.put(StatusContract.Column.ROL, "tripulacion");
        values.put(StatusContract.Column.ROUND, "18");

        values.put(StatusContract.Column.TITLE, "Final");
        values.put(StatusContract.Column.PHOTO, "drawable/turnofinal");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"La búsqueda del tesoro ha llegado a su fin, es hora de volver a casa y disfrutar de la recompensa obtenida. Un pirata no permanece mucho tiempo en tierra, por lo que se embarcará en nuevas aventuras pronto. \n" +
                "\n" +
                "Esperamos que hayas disfrutado de la aventura ofrecida por TREASURE HUNT.\n" +
                "\n" +
                "¡Hasta la próxima grumete!\n");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        values.clear();
        values.put(StatusContract.Column.ID, 36);
        values.put(StatusContract.Column.ROL, "capitan");
        values.put(StatusContract.Column.ROUND, "18");

        values.put(StatusContract.Column.TITLE, "Final");
        values.put(StatusContract.Column.PHOTO, "drawable/turnofinal");//stakeholder
        values.put(StatusContract.Column.DESCRIPTION,"La búsqueda del tesoro ha llegado a su fin, es hora de volver a casa y disfrutar de la recompensa obtenida. Un pirata no permanece mucho tiempo en tierra, por lo que se embarcará en nuevas aventuras pronto. \n" +
                "\n" +
                "Esperamos que hayas disfrutado de la aventura ofrecida por TREASURE HUNT.\n" +
                "\n" +
                "¡Hasta la próxima grumete!\n");

        db.insertWithOnConflict(StatusContract.TABLE, null,
                values, SQLiteDatabase.CONFLICT_IGNORE);

        db.close();//Cierre del objeto de la DB
    }
}
