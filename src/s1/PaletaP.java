package s1;

public class PaletaP implements Runnable {
	private String Nom;
	int Maons;
	
	public PaletaP(String nom, int maons) {
		Nom = nom;
		Maons = maons;
	}

	@Override
	public void run() {
		posaMaons(Maons);
		
	}

	private void posaMaons(int maons) {
		//Temps que triga a col·locar els maons entre 1 i 4 segons per cada maó
		System.out.println(Nom + " posant maons...");
		try {
			Thread.sleep((long) ((Math.random()*300)+100)*maons );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Nom + " ha acabat.");
		
	}
	
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
}
