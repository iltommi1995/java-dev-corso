package util;

public class Utils {
	
	public static int MINCARATTERI = 2;
	public static int MAXCARATTERI = 120;
	public static final double MINDOUBLE = 3;
	public static final double MAXDOUBLE = 10;
	public static final double MININT = 14;
	public static final double MAXINT = 150;
	
	public static boolean controllaString(String parametro) {
		boolean ris = false;
		if (parametro.length() >= MINCARATTERI && parametro.length() < MAXCARATTERI)
			ris = true;
		return ris;
	}
	
	public static boolean controllaDouble(double parametro) {
		boolean ris = false;
		if(parametro > MINDOUBLE && parametro < MAXDOUBLE)
			ris = true;
		return ris;
	}
	
	public static boolean controllaInt(int parametro) {
		boolean ris = false;
		if(parametro > MININT && parametro < MAXINT)
			ris = true;
		return ris;
	}
}
