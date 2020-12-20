import com.generation.utility.database.Database;

public class TestScuola 
{
	public static void main(String[] args) 
	{
		// Voglio prendere da database tutti i dati relativi allo 
		// studente con id 1
		
		Database db = new Database("root", "root", "scuolawebproject");
		
		String query = "select * from persone inner join studenti "
					+ "on persone.id = studenti.id "
					+ "where persone.id = ?";
		
		System.out.println(db.row(query, "1"));

	}
}
