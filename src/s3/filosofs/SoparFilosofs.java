package s3.filosofs;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SoparFilosofs {
	public static Lock lockA = new ReentrantLock();

	public static void main(String[] args) {

		int numFilosofs=4;
		Cobert[] coberts;
		coberts = new Cobert[numFilosofs];
		
		for (int i=0;i<coberts.length;i++) {
			coberts[i] = new Cobert();
		}
		
		FilosofTh f1 = new FilosofTh("Abel", coberts[0], coberts[1]);
		FilosofTh f2 = new FilosofTh("Belen", coberts[1], coberts[2]);
		FilosofTh f3 = new FilosofTh("Carles", coberts[2], coberts[3]);
		FilosofTh f4 = new FilosofTh("Dani", coberts[3], coberts[0]);
		//Filosof f5 = new Filosof("Gina", (char)4, coberts[4], coberts[0]);

		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		//f5.start();
		
		
		
	}

}
