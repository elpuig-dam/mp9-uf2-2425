package s1;

public class Alumne {
	private String Nom;
		
	public Alumne(String nom) {
		Nom = nom;
	}

	public int Examinar() {

		//temps que triga a fer l'examen
		try {
			Thread.sleep((long) (Math.random()*2000)+1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//nota de l'examen
		int nota = (int) (Math.random()*10);
		return nota;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	
	
	
}
