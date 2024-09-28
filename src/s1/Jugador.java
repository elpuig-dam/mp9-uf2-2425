package s1;

public class Jugador implements Comparable<Jugador> {
	private String nom;
	private int punts;
	
	public Jugador (String Nom) {
		this.nom = Nom;
	}

	public Jugador (String nom, int p) {
		this.nom = nom;
		punts = p;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPunts() {
		return punts;
	}

	public void setPunts(int punts) {
		this.punts += punts;
	}

	@Override
	public int compareTo(Jugador o) {
		 int byPunts = Integer.compare(this.punts, o.getPunts());
	     return byPunts;
	}
	

}
