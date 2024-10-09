package room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import room.Voto;

@Dao
public interface VotoDao {
    @Insert
    void insertVoto(Voto voto);

    @Query("SELECT * FROM votos")
    List<Voto> getAllVotos();
}
