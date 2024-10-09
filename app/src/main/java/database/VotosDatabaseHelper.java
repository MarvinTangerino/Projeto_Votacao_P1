package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VotosDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "votacao.db";
    private static final int DATABASE_VERSION = 6;
    private static final String TABLE_VOTOS = "VotosBotoes";

    public VotosDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_VOTOS_TABLE = "CREATE TABLE " + TABLE_VOTOS + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome TEXT,"
                + "quantidade INTEGER"
                + ")";
        db.execSQL(CREATE_VOTOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOTOS);
        onCreate(db);
    }

    public void adicionarVoto(String nome) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT quantidade FROM " + TABLE_VOTOS + " WHERE nome = ?", new String[]{nome});

        if (cursor != null && cursor.moveToFirst()) {
            int quantidadeAtual = cursor.getInt(0);
            ContentValues values = new ContentValues();
            values.put("quantidade", quantidadeAtual + 1);
            db.update(TABLE_VOTOS, values, "nome = ?", new String[]{nome});
        } else {
            ContentValues values = new ContentValues();
            values.put("nome", nome);
            values.put("quantidade", 1);
            db.insert(TABLE_VOTOS, null, values);
        }

        cursor.close(); // Fecha o cursor após o uso
        db.close(); // Fecha o banco de dados
    }

    public Cursor getAllVotos() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_VOTOS, null);
    }

    public int getTotalVotos() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(quantidade) FROM " + TABLE_VOTOS, null);

        int totalVotos = 0;
        if (cursor.moveToFirst()) {
            totalVotos = cursor.getInt(0);  // Obtém o valor da soma
        }

        cursor.close();
        return totalVotos;
    }
}
