package s3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompteEstalvi {
	private int saldo;

	public CompteEstalvi() {
		saldo = 0;
	}
	
	public synchronized int getSaldo() {
		return saldo;
	}

	private synchronized void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public synchronized void ingres(int diners) {
		   int aux;
	       aux=getSaldo();
	       aux=aux+diners;
	       setSaldo(aux);
	       System.out.print("Ingresso "+ diners + '\n');
	}
	
	public synchronized void treu(int diners) {
		 	int aux;
			aux=getSaldo();
	        aux=aux-diners;
	        setSaldo(aux);
	        System.out.print("trec "+diners+ '\n');
	}

	public static void main(String[] args) throws InterruptedException {
		final CompteEstalvi b = new CompteEstalvi();
		List<Thread> llitaTh = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			Thread threadIngres = new Thread(() -> b.ingres(100));
			Thread threadTreure = new Thread(() -> b.treu(50));

			llitaTh.add(threadTreure);
			llitaTh.add(threadIngres);

			threadIngres.start();
			threadTreure.start();

		}

		for(Thread th : llitaTh) {
			th.join();
		}

		System.out.println("Saldo final: "+ b.getSaldo());
		
	}



	
}
