package mx.edu.utng.manualhtml5;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 19/04/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        String sqld = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTD + " ( "
                + KEY_IDD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESD
                + " TEXT, " + KEY_ANSWERD+ " TEXT, "+KEY_OPTAD +" TEXT, "
                +KEY_OPTBD +" TEXT, "+KEY_OPTCD+" TEXT)";
        String sqlt = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTT + " ( "
                + KEY_IDT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUEST
                + " TEXT, " + KEY_ANSWERT+ " TEXT, "+KEY_OPTAT +" TEXT, "
                +KEY_OPTBT +" TEXT, "+KEY_OPTCT+" TEXT)";
        String sqlc = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTC + " ( "
                + KEY_IDC+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESC
                + " TEXT, " + KEY_ANSWERC+ " TEXT, "+KEY_OPTAC +" TEXT, "
                +KEY_OPTBC +" TEXT, "+KEY_OPTCC+" TEXT)";
        String sqls = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTSS + " ( "
                + KEY_IDS + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESS
                + " TEXT, " + KEY_ANSWERSS+ " TEXT, "+KEY_OPTAS +" TEXT, "
                +KEY_OPTBS +" TEXT, "+KEY_OPTCS+" TEXT)";

        db.execSQL(sql);
        db.execSQL(sqld);
        db.execSQL(sqlt);
        db.execSQL(sqlc);
        db.execSQL(sqls);
        //Rellenar Base de datos
        addQuestions();
        addQuestionsDos();
        addQuestionsTres();
        addQuestionsCuatro();
        addQuestionsSinco();
        //db.close();
    }

    private void addQuestions()
    {
        Question q1=new Question("¿Qué significa las siglas HTML?","Hiper Text Markup Languaje", "Hipter Tax Marked ", "Hiper texto", "Hiper Text Markup Languaje");
        this.addQuestion(q1);
        Question q2=new Question("¿Para qué sirve la etiqueta DOCTYPE?", "Es la base de la página web", "Es el cuerpo de la pagina", "no sirve para nada", "Es la base de la página web");
        this.addQuestion(q2);
        Question q3=new Question("¿Para qué sirve html?","Para envolver todo el código", "Iniciar a programar","Ninguna de las anteriores","Para envolver todo el código");
        this.addQuestion(q3);
        Question q4=new Question("¿Qué hace la etiqueta title?", "Poner titulo", "Para diseño", "Ninguna de las anteriores","Poner titulo");
        this.addQuestion(q4);
        Question q5=new Question("¿Qué es HTML5?","Lenguaje de programacion","Lenguaje de maquetación","Ninguna","Lenguaje de maquetación");
        this.addQuestion(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getPREGUNTA());
        values.put(KEY_ANSWER, quest.getRESPUESTA());
        values.put(KEY_OPTA, quest.getOPCIONA());
        values.put(KEY_OPTB, quest.getOPCIONB());
        values.put(KEY_OPTC, quest.getOPCIONC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setPREGUNTA(cursor.getString(1));
                quest.setRESPUESTA(cursor.getString(2));
                quest.setOPCIONA(cursor.getString(3));
                quest.setOPCIONB(cursor.getString(4));
                quest.setOPCIONC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    //Tabla dos
    private static final String TABLE_QUESTD = "questdos";
    // tasks Table Columns names
    private static final String KEY_IDD = "id";
    private static final String KEY_QUESD = "question";
    private static final String KEY_ANSWERD = "answer"; //correct option
    private static final String KEY_OPTAD= "opta"; //option a
    private static final String KEY_OPTBD= "optb"; //option b
    private static final String KEY_OPTCD= "optc"; //option c

    private void addQuestionsDos()
    {
        Question d1=new Question("¿Para qué es la etiqueta body?","Para empezar a realizar la página", "Es la estructura del cuerpo", "Da el titulo", "Es la estructura del cuerpo");
        this.addQuestiondos(d1);
        Question d2=new Question("¿Para qué sirve la etiqueta header?", "Es proveer información introductoria", "Es la cabecera", "Es el cuerpo", "Es proveer información introductoria");
        this.addQuestiondos(d2);
        Question d3=new Question("¿Para qué sirve la etiqueta nav?","Para el titulo", "Barra de navegación","Ninguna de las anteriores","Barra de navegación");
        this.addQuestiondos(d3);
        Question d4=new Question("¿Para qué sirve la etiqueta section?", "Contiene la información más relevante", "Secciona el cuerpo", "Secciona la organizacion","Contiene la información más relevant");
        this.addQuestiondos(d4);
        Question d5=new Question("¿Para qué sirve aside?","para realizar código","Para el diseño","En un típico diseño web","En un típico diseño web");
        this.addQuestiondos(d5);
    }

    // Adding new question
    public void addQuestiondos(Question questtio) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESD, questtio.getPREGUNTA());
        values.put(KEY_ANSWERD, questtio.getRESPUESTA());
        values.put(KEY_OPTAD, questtio.getOPCIONA());
        values.put(KEY_OPTBD, questtio.getOPCIONB());
        values.put(KEY_OPTCD, questtio.getOPCIONC());
        // Inserting Row
        dbase.insert(TABLE_QUESTD, null, values);
    }
    public List<Question> getAllQuestionsdos() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTD;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setPREGUNTA(cursor.getString(1));
                quest.setRESPUESTA(cursor.getString(2));
                quest.setOPCIONA(cursor.getString(3));
                quest.setOPCIONB(cursor.getString(4));
                quest.setOPCIONC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    //Tabla tres
    private static final String TABLE_QUESTT = "questt";
    // tasks Table Columns names
    private static final String KEY_IDT = "id";
    private static final String KEY_QUEST = "question";
    private static final String KEY_ANSWERT = "answer"; //correct option
    private static final String KEY_OPTAT= "opta"; //option a
    private static final String KEY_OPTBT= "optb"; //option b
    private static final String KEY_OPTCT= "optc"; //option c
    private void addQuestionsTres()
    {
        Question q1=new Question("¿Qué es article?","Son articulos", "Es el contenido clave mostrado en pantalla", "Articulos en la pagina", "Es el contenido clave mostrado en pantalla");
        this.addQuestionT(q1);
        Question q2=new Question("¿Para qué es hgroup?", "Para construir cabeceras", "Para ordenar", "Para mostrar la pagina", "Para construir cabeceras");
        this.addQuestionT(q2);
        Question q3=new Question("¿Para qué sirve declarar figure?","para declarar el contenido del documento", "Para hacer figuras","Para nada","para declarar el contenido del documento");
        this.addQuestionT(q3);
        Question q4=new Question("¿Para qué sirve figcaption?",	"Imprimir Mensaje", "Captar código", "Para relacionar el texto con figure","Para relacionar el texto con figure");
        this.addQuestionT(q4);
        Question q5=new Question("¿Para qué es la etiqueta H1?","Hacer mas grande la letra","Hacer titulos","Estructura principal","Hacer mas grande la letra");
        this.addQuestionT(q5);
    }

    // Adding new question
    public void addQuestionT(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUEST, quest.getPREGUNTA());
        values.put(KEY_ANSWERT, quest.getRESPUESTA());
        values.put(KEY_OPTAT, quest.getOPCIONA());
        values.put(KEY_OPTBT, quest.getOPCIONB());
        values.put(KEY_OPTCT, quest.getOPCIONC());
        // Inserting Row
        dbase.insert(TABLE_QUESTT, null, values);
    }
    public List<Question> getAllQuestionsTres() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTT;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setPREGUNTA(cursor.getString(1));
                quest.setRESPUESTA(cursor.getString(2));
                quest.setOPCIONA(cursor.getString(3));
                quest.setOPCIONB(cursor.getString(4));
                quest.setOPCIONC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    //Creacion de tabla 4
    private static final String TABLE_QUESTC = "questc";
    // tasks Table Columns names
    private static final String KEY_IDC = "id";
    private static final String KEY_QUESC = "question";
    private static final String KEY_ANSWERC = "answer"; //correct option
    private static final String KEY_OPTAC= "opta"; //option a
    private static final String KEY_OPTBC= "optb"; //option b
    private static final String KEY_OPTCC= "optc"; //option c


    private void addQuestionsCuatro() {
        Question q1 = new Question("¿Para qué es la etiqueta Mark?"," Resaltar parte de un texto", "Marcar letras", "Maquear", " Resaltar parte de un text");
        this.addQuestionC(q1);
        Question q2 = new Question("¿Para qué sirve small?", "Pequeña la pagina", "Pequeñas las imagenes", "Cualquier texto con letra pequeñas", "Cualquier texto con letra pequeñas");
        this.addQuestionC(q2);
        Question q3 = new Question("¿Para qué sirve la etiqueta cite?","Rellenar", "Encerrar titulo","citar","Encerrar titulo");
        this.addQuestionC(q3);
        Question q4 = new Question("¿Para qué sirve la etiqueta address?",	"Direccion", "Para la información del contacto", "Hubicacion","Para la información del contacto");
        this.addQuestionC(q4);
        Question q5 = new Question("¿Para qué sirve la etiqueta time?","Dar la fecha","Para la hora","Para los dias","Dar la fecha");
        this.addQuestionC(q5);
    }
    // Adding new question
    public void addQuestionC(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESC, quest.getPREGUNTA());
        values.put(KEY_ANSWERC, quest.getRESPUESTA());
        values.put(KEY_OPTAC, quest.getOPCIONA());
        values.put(KEY_OPTBC, quest.getOPCIONB());
        values.put(KEY_OPTCC, quest.getOPCIONC());
        // Inserting Row
        dbase.insert(TABLE_QUESTC, null, values);
    }
    public List<Question> getAllQuestionsC() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTC;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setPREGUNTA(cursor.getString(1));
                quest.setRESPUESTA(cursor.getString(2));
                quest.setOPCIONA(cursor.getString(3));
                quest.setOPCIONB(cursor.getString(4));
                quest.setOPCIONC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    //Tabla cinco

    private static final String TABLE_QUESTSS = "quests";
    // tasks Table Columns names
    private static final String KEY_IDS = "id";
    private static final String KEY_QUESS = "question";
    private static final String KEY_ANSWERSS = "answer"; //correct option
    private static final String KEY_OPTAS= "opta"; //option a
    private static final String KEY_OPTBS= "optb"; //option b
    private static final String KEY_OPTCS= "optc"; //option c
    private void addQuestionsSinco()
    {
        Question q1=new Question("¿Qué es la cadena de responsabilidad?","Evita acoplar el emisor de una petición", "Responder una aplicación", "Encadena cosas", "Evita acoplar el emisor de una petición");
        this.addQuestionS(q1);
        Question q2=new Question("¿Cúales son sus implementaciones?", "Definir enlaces, usar los enlaces existentes", "Definir las variables, Definir las clases", "Definir los grados, Definir la eficiencia", "Definir enlaces, usar los enlaces existentes");
        this.addQuestionS(q2);
        Question q3=new Question("Definición del Command","Petición de encapusulacion de objetos", "Tratado de forma de los objetos","Trasnsfondo del uso de objetos", "Petición de encapusulacion de objetos" );
        this.addQuestionS(q3);
        Question q4=new Question("¿Qué es Interpreter?", "Representacion de la gramática junto a un interprete", "Formación de diccionarios", "Trasnformación de clases a diccionarios","Representacion de la gramática junto a un interprete");
        this.addQuestionS(q4);
        Question q5=new Question("¿Qué es un Iterator?","Modo de acceder a los elementos de un objeto","Son repercusiones de cursos","Interpretacion grafica","Modo de acceder a los elementos de un objeto");
        this.addQuestionS(q5);
    }

    // Adding new question
    public void addQuestionS(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUESS, quest.getPREGUNTA());
        values.put(KEY_ANSWERSS, quest.getRESPUESTA());
        values.put(KEY_OPTAS, quest.getOPCIONA());
        values.put(KEY_OPTBS, quest.getOPCIONB());
        values.put(KEY_OPTCS, quest.getOPCIONC());
        // Inserting Row
        dbase.insert(TABLE_QUESTSS, null, values);
    }
    public List<Question> getAllQuestionsS() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTSS;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setPREGUNTA(cursor.getString(1));
                quest.setRESPUESTA(cursor.getString(2));
                quest.setOPCIONA(cursor.getString(3));
                quest.setOPCIONB(cursor.getString(4));
                quest.setOPCIONC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }


}


