package s1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;



public class Examen {

	public static void main(String[] args) throws InterruptedException {
		//Definim l'executor dels processos
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		//Definim la llista dels alumnes
	 	List<AlumneP> llistaAlumnes = new ArrayList<AlumneP>();
	 	//Nombre d'alumnes i modul del que s'examinen
	 	int numAlumnes = 10, ti, te;
	 	String Modul = "M9";
	 	
	 	
	 	//Es creen els alumnes i s'afegeixen a la llista per fer l'examen
	 	for (int i=0;i<numAlumnes;i++) {
			AlumneP A_m9 = new AlumneP(Modul+"-"+i);
			llistaAlumnes.add(A_m9);
	 	}
	 	
	 	//es crea la llista de resultats de l'examen
	 	List <Future<Integer>> llistaResultats;
	 	//Comencem a contar el temps
	 	ti = (int) System.currentTimeMillis();
	 	//Els alumnes s'exameinen
		llistaResultats = executor.invokeAll(llistaAlumnes);
		//Els alumnes acaben i agafem el temps
		te = (int) System.currentTimeMillis();
		//No deixem examinar a més alumnes
		executor.shutdown();
	 	
		//Ensenyem els resultats i el temps que han trigat
	 	for (int i = 0; i < llistaResultats.size(); i++) {
	 		Future<Integer> resultat = llistaResultats.get(i);
	 		try {
	 			System.out.println(llistaAlumnes.get(i).getNom() + ": " + resultat.get());
	 			} catch (InterruptedException | ExecutionException e) {
	 				e.getStackTrace();
	 			}
	 	}

	 	System.out.println("Han trigat: " + (te - ti)/1000 + " segons");

	}

}
