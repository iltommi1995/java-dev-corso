package entities;

public class Fumetto {
	public String title;
	public String author;
	public String genre;
	public int pages;
	public int year;
	
	public String scheda() {
		String res = 	title				+	"\n"					+
						"---- Author: " 	+ 	author 	+  		"\n"	+
						"---- Genre: "		+ 	genre	+		"\n"	+
						"---- Pages: "		+ 	pages	+		"\n"	+
						"---- Year: "		+ 	year					;
		return res;
	}
}
