package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "votacao.db";
    private static final int DATABASE_VERSION = 6;
    private static final String TABLE_NAME = "votos";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "primeiroNome TEXT, " +
                "estadoCivil TEXT, " +
                "idade INTEGER, " +
                "sexo TEXT, " +
                "telefone TEXT, " +
                "data TEXT, " +
                "hora TEXT, " +
                "voto TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String nome, String estadoCivil, String idade, String sexo, String telefone, String data, String hora, String voto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("primeiroNome", nome);
        contentValues.put("estadoCivil", estadoCivil);
        contentValues.put("idade", idade);
        contentValues.put("sexo", sexo);
        contentValues.put("telefone", telefone);
        contentValues.put("data", data);
        contentValues.put("hora", hora);
        contentValues.put("voto", voto);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
