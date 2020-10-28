package entities;

public class Movie {
	public String title;
	public String director;
	public String genre; 
	public int year;
	
	public String scheda() {
		String res = 	title				+	"\n"					+
						"---- Director: " 	+ 	director 	+  	"\n"	+
						"---- Genre: "		+ 	genre		+	"\n"	+
						"---- Year: "		+ 	year					;
		return res;
	}
	
	//
}
