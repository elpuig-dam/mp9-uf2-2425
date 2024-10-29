package s3.cursarelleus;

public class Testimoni {
	boolean lliure;
	long time_start, time_end, temps;
	private String nom;

	public Testimoni(String nom) {
		lliure=true;
		temps = 0;
		this.nom = nom;
	}

	public synchronized String getNom() {
		return nom;
	}
	
	public synchronized void agafar() {
		//intenta agafar el testimoni
		try {
			while(!lliure) wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//agafa el testimoni
		time_start = System.currentTimeMillis();
		lliure = false;
		notifyAll();
				
	}
	public synchronized void deixar() {
		time_end = System.currentTimeMillis();
		temps += time_end - time_start;
		lliure = true;
		notifyAll();
	}
	
	public synchronized long getTemps () {
		return temps;
	}

}
