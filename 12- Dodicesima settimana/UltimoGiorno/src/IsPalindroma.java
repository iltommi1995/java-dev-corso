import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IsPalindroma 
{
	/*
	 * Una stringa è palindroma se 
	 * può essere letta da inistra verso destra e da destra verso sinistra indifferentemente
	 */
	//1 2 3 4 5 6 7  8  9  10 11  12
	//1 1 2 3 5 8 13 21 34 55 89 144//
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.println(contaParole());
		
		String string = "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr'q ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc spj.";
		
		for(int i = 0; i < string.length(); i++)  
		{
			char c = string.charAt(i); 
			c = c + 2; 
			string.charAt(i) = c;
		}
		
		
	}
	
	public static boolean isPalindroma(String word)
	{
		String[] wordSplit = word.replace(" ", "").split("");
		for(int i = 0; i < wordSplit.length; i++)
		{
			if(!wordSplit[i].equalsIgnoreCase(wordSplit[wordSplit.length -1 - i]))
				return false;
		}
		return true;
	}
	
	public static int fibonacci(int posizione)
	{
		int num1 = 1;
		int num2 = 1;
		int ris = 1;
		for(int i = 0; i < (posizione-2); i++)
		{
			ris = num1 + num2;
			num1 = num2;
			num2 = ris;
		}
		return ris;
	}
	
	public static List<String> fibonacciList(int posizione)
	{
		int num1 = 1;
		int num2 = 1;
		int ris = 1;
		List<String> li = new ArrayList<String>();
		if(posizione > 1)
			li.add(1+"");
		if(posizione > 2)
			li.add(1+"");
		for(int i = 0; i < (posizione-2); i++)
		{
			ris = num1 + num2;
			num1 = num2;
			num2 = ris;
			li.add(ris+"");
		}
		return li;
	}
	
	/*
	 * Fare la somma di questi due numeri: 
	 * String a = "6478748972819784624871927189478943289" e 
	 * String b = "48978732072107487389172892172819"
	 */
	
	// somma = 6 478 797 951 551 856 732 359 316 362 371 116 108
	// mio   = 6 478 797 951 551 856 732 359 316 362 371 116 108
	
	public static String somma() {
		String a = "6478748972819784624871927189478943289";
		String b = "48978732072107487389172892172819";
		String[] as = a.split("");
		String[] bs = b.split("");
		String ris = "";
		int num = 0;
		int prox = 0;
		int resto = 0;
		String[] nums = a.split("");
		for(int i = 0; i < as.length; i++)
		{
			if((as.length-1-i) >= 0 && (bs.length -1-i) >= 0)
			{
				num = Integer.parseInt(as[as.length-1-i]) + Integer.parseInt(bs[bs.length -1-i]) + prox;
				nums = (num+"").split("");
			}
			else if((as.length-1-i) < 0 && (bs.length -1-i) >= 0)
			{
				num = 0 + Integer.parseInt(bs[bs.length -1-i]) + prox;
				nums = (num+"").split("");
			}
			else if((as.length-1-i) >= 0 && (bs.length -1-i) < 0)
			{
				num = Integer.parseInt(as[as.length-1-i]) + 0 + prox;
				nums = (num+"").split("");
			}
			
			if(nums.length==1)
			{
				resto = Integer.parseInt(nums[0]);
				prox = 0;
			}
			if(nums.length==2)
			{
				resto = Integer.parseInt(nums[1]);
				prox = Integer.parseInt(nums[0]);
			}
			ris = resto + ris;
		}
		
		return ris;
	}
	
	//Creare un file di testo in cui ci copiate il primo canto della
    //divina commedia. Scrivere un programma che legga il file e che 
    //mi stampi qual è la parola più utilizzata e quante volte compare
	
	
	public static Map<String,String> contaParole() throws FileNotFoundException{
		Map<String,String> ris = new LinkedHashMap<String,String>();
		String path = "C:\\Users\\duckf\\Desktop\\Corso Java\\Workspace\\12- Dodicesima settimana\\UltimoGiorno\\src\\divina.txt";
		Scanner file = new Scanner(new File(path));
		Map<String,Integer> parole = new LinkedHashMap<String,Integer>();
		int conteggio = 0;
		while(file.hasNextLine())
		{
			String[] riga = file.nextLine()
					.replace(".", "").replace(",", "").replace(";", "").replace("!", "")
					.replace("»", "").replace("«", "").replace("’", " ").replace("?", "")
					.toLowerCase().split(" ");
			
			for(int i = 0; i < riga.length; i++)
			{
				if(parole.containsKey(riga[i]))
				{
					conteggio = parole.get(riga[i]) + 1;
					parole.replace(riga[i], conteggio);
				}
				else 
				{
					parole.put(riga[i], 1);
				}
			}
		}
		System.out.println(parole);
		int max = 0;
		List<String> parola = new ArrayList<String>();
		
		for(String s : parole.keySet())
		{
			if(max < parole.get(s))
			{
				max = parole.get(s);
				parola = new ArrayList<String>();
				parola.add(s);
			}
			if(max == parole.get(s))
			{
				parola.add(s);
			}	
		}
		
		for(String p : parola)
		{
			ris.put(p, parole.get(p)+"");
		}
	
		return ris;
	}
	
	
	
}
