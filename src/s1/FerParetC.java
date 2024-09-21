package s1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FerParetC {

	public static void main(String[] args) throws InterruptedException {
		//Definim l'executor dels processos
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		int numPaletes = 5, ti, te, numMaons = 10;
		
		//instanciem els paletes
		PaletaP[] P = new PaletaP[numPaletes];
						
		//comencem a contar el temps
		ti = (int) System.currentTimeMillis();
		//Donem nom als paletes i els posem a fer fer la paret
		for (int i=0;i<numPaletes;i++) {
			P[i] = new PaletaP("Paleta-"+i,numMaons);
			executor.execute(P[i]);
		}

		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		/*while (!executor.isTerminated()) {
		}*/

		//Han acabat i agafem el temps final
		te = (int) System.currentTimeMillis();
				
		System.out.println("Han trigat: " + (te - ti)/1000 + " segons");
		
	}

}
