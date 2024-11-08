package s1;

public class Ciclista {
	private String nom;

	public Ciclista(String nom) {
		this.nom = nom;
	}

	public int start() {

		//temps que triga a fer la regata
		int temps = (int) (Math.random()*2000)+1000;
		System.out.println("El ciclista "+nom+" inicia l'etapa");
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return temps;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	
	
}
