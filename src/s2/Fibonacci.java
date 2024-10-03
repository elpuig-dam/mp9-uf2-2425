package s2;

import java.util.concurrent.ForkJoinPool;

public class Fibonacci {

	public Fibonacci() {}

	public static void main(String[] args) {
		int n=7;
		// Mira el número de processadors
		ForkJoinPool pool = new ForkJoinPool();
		
		FibonacciTask tasca = new FibonacciTask(n);
		
		long time = System.currentTimeMillis();
		// crida la tasca i espera que es completin
		long result1 = pool.invoke(tasca);
		long result = tasca.join();
		//System.out.println("Maxim valor d'un Long:" + Long.MAX_VALUE);
		System.out.println("Temps utilitzat:"+(System.currentTimeMillis()-time));
		System.out.println("Resultat: " + result);

	}

}
