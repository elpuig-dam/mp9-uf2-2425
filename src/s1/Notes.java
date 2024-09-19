package s1;

public class Notes {

	public static void main(String[] args) {
		int numAlumnes = 10,te,ti;
		String Modul = "M9";
		int notes[] = new int[numAlumnes];
		
		//instanciem els alumnes
		Alumne[] A_m9 = new Alumne[numAlumnes];
		
		//comencem a contar el temps
		ti = (int) System.currentTimeMillis();
		//Donem nom als alumnes i els posem a fer l'examen
		for (int i=0;i<numAlumnes;i++) {
			A_m9[i] = new Alumne(Modul+"-"+i);
			notes[i] = A_m9[i].Examinar();
		}
		//Han acabat i agafem el temps final
		te = (int) System.currentTimeMillis();
		
		//traiem els resultats i el temps que han trigat
		for (int i=0;i<numAlumnes;i++) {
			System.out.println("Alumne "+A_m9[i].getNom()+" : " + notes[i]);
		}
		System.out.println("Han trigat: " + (te - ti)/1000 + " segons");
	}
	
	

}
