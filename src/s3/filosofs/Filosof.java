package s3.filosofs;

import java.awt.Color;

import javax.swing.JLabel;

import static s3.filosofs.Taula.*;

public class Filosof implements Runnable {
	private Cobert cobert1;
	private Cobert cobert2;
	private String nom;
	private JLabel lblFilosof;

	public Filosof (String nom, Cobert cobert1, Cobert cobert2, JLabel lblFilosof) {
		this.cobert1 = cobert1;
		this.cobert2 = cobert2;
		this.nom=nom;
		this.lblFilosof = lblFilosof;
	}
	public Filosof (String nom, Cobert cobert1, Cobert cobert2) {
		this.cobert1 = cobert1;
		this.cobert2 = cobert2;
		this.nom=nom;
	}

	/* Codi de colors
	 * BLUE: El filòsof menja
	 * CYAN: Agafa un cobert
	 * ORANGE: El filòsof pensa
	 *
	 * lockA.lock() i lockA.unlock() és una alternativa al syncrhonized per evitar el deadlock
	 */
	
	private void menjar() {
		try {
			//Sincronització per evitar Deadlock
			//lockA.lock();
			synchronized (lock1) {
				cobert1.agafar();
				lblFilosof.setText("un cobert");
				lblFilosof.setBackground(Color.CYAN);
				System.out.println("1cobert " + nom);
				Thread.sleep((long) ((Math.random() * 150) + 50));
				cobert2.agafar();
				System.out.println("2cobert " + nom);

			}
			//lockA.unlock();

			
			System.out.println("Filosof: " + nom + " menja");
			lblFilosof.setText("menjo");
			lblFilosof.setBackground(Color.BLUE);
			Thread.sleep((long) ((Math.random()*350)+25));
						
			cobert1.deixar();
			cobert2.deixar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void pensar() {
		System.out.println("Filosof: " + nom + " pensa");
		lblFilosof.setText("penso");
		lblFilosof.setBackground(Color.ORANGE);
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
