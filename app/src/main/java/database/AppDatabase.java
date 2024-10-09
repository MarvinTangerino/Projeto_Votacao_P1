package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import room.Voto;
import room.VotoDao;

@Database(entities = {Voto.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VotoDao votoDao();
}
