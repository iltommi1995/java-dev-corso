package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database 
{

private static Connection con;
	
	public static Connection getConnection() {
		// Se la connessione è nulla allora anddrò a definirla
		if(con == null) {
			String path = "jdbc:mysql://localhost:3306/aziendajava2";
            String user = "root";
            String pw   = "root";
            try 
            {
                Class.forName("com.mysql.jdbc.Driver"); 
                con = DriverManager.getConnection(path, user, pw);
                System.out.println("Siamo dentro");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
		}
		
		// In ogni caso, quando il metodo termina, restituisco con
		
		return con;
	}
}
