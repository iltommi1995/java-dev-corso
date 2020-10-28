package entities;

public class Cd {
	public String title;
	public String artist;
	public String genre;
	public int tracks;
	public int year;
	
	public String scheda() {
		String res = 	title				+	"\n"					+
						"---- Artist: " 	+ 	artist 	+  		"\n"	+
						"---- Genre: "		+ 	genre	+		"\n"	+
						"---- Tracks: "		+ 	tracks	+		"\n"	+
						"---- Year: "		+ 	year					;
		return res;
	}
}
