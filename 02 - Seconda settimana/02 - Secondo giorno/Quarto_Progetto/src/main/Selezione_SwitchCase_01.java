package main;

public class Selezione_SwitchCase_01 
{
	public static void main(String[] args) 
	{
		String pizza = "margherita";
		double prezzo = 0;
		
		switch(pizza.toLowerCase()) {
		case "margherita":
			// qui scrivo il codice da esseguire nel caso in cui 
			// il valore di pizza sia margherita
			prezzo = 5;
		break;
		case "marinara":
			prezzo = 4;
		break;
		case "esplosiva":
			prezzo = 10;
		break;
		default:
			prezzo = 15;
		break;
		}
	}
}
