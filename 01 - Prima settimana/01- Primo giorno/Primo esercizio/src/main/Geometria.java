package main;

public class Geometria 
{
	public static void main(String[] args) 
	{
		// Calcolo area quadrato con lato 5
		double latoQuadrato;
		double areaQuadrato;
		String output1;
		latoQuadrato = 5.0;
		areaQuadrato = latoQuadrato * latoQuadrato;
		output1 = "L'area del quadrato di lato " + latoQuadrato + " �: " + areaQuadrato;
		System.out.println(output1);
		
		// Calcolo area rettaongolo con base 5 e altezza 2.5
		double baseRettangolo;
		double altezzaRettangolo;
		double areaRettangolo;
		String output2;
		baseRettangolo = 5;
		altezzaRettangolo = 2.5;
		areaRettangolo = baseRettangolo * altezzaRettangolo;
		output2 = "L'area del rettangolo di base " + baseRettangolo + " e altezza " + altezzaRettangolo + " �: " + areaRettangolo;
		System.out.println(output2);
		
		// Calcolo area triangolo con base = 2* altezzaRettangolo, altezza = 1/2 latoQuadrato
		double baseTriangolo;
		double altezzaTriangolo;
		double areaTriangolo;
		String output3;
		baseTriangolo = 2 * altezzaRettangolo;
		altezzaTriangolo = latoQuadrato / 2;
		areaTriangolo = (baseTriangolo * altezzaTriangolo) / 2;
		output3 = "L'area del triangolo di base " + baseTriangolo + " e altezza " + altezzaTriangolo + " �: " + areaTriangolo;
		System.out.println(output3);
				
		// Calcolo area cerchio con raggio = area del triangolo
		double raggioCerchio;
		double piGreco;
		double areaCerchio;
		String output4;
		raggioCerchio = areaTriangolo;
		piGreco = 3.14;
		areaCerchio = raggioCerchio * raggioCerchio * piGreco ;
		output4 = "L'area del cerchio di raggio " + raggioCerchio +" �: " + areaCerchio;
		System.out.println(output4);
	}
}
