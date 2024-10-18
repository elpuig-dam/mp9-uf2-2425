package s3.filosofs;

import static s3.filosofs.SoparFilosofs.lockA;

public class FilosofTh extends Thread {
	private Cobert cobert1;
	private Cobert cobert2;
	private String nom;

	public FilosofTh(String nom, Cobert cobert1, Cobert cobert2) {
		this.cobert1 = cobert1;
		this.cobert2 = cobert2;
		this.nom=nom;
	}


	/*
	 *
	 * lockA.lock() i lockA.unlock() és una alternativa al syncrhonized per evitar el deadlock
	 */
	
	private void menjar() {
		try {
			//Sincronització per evitar Deadlock
			lockA.lock(); //inici de la secció crítica

				cobert1.agafar();
				System.out.println("1cobert " + nom);
				Thread.sleep((long) ((Math.random() * 150) + 50));
				cobert2.agafar();
				System.out.println("2cobert " + nom);

			lockA.unlock(); //fi de la secció crítica
			System.out.println("Filosof: " + nom + " menja");
			Thread.sleep((long) ((Math.random()*350)+25));
						
			cobert1.deixar();
			cobert2.deixar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void pensar() {
		System.out.println("Filosof: " + nom + " pensa");
		try {
			Thread.sleep((long) ((Math.random()*100)+50));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}
	
	public void run() {
		for(;;) {
			menjar();
			pensar();
		}
	}	
}
