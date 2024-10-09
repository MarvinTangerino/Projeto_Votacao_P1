package room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "votos")
public class Voto {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String primeiroNome;
    public String estadoCivil;
    public int idade;
    public String sexo;
    public String telefone;
    public String data;
    public String hora;
    public String voto;
}
