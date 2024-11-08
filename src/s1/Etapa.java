package s1;

public class Etapa {

	public static void main(String[] args) {
		int numParticipants = 10;
		String nom = "Ciclista";
		int temps[] = new int[numParticipants];
		
		//instanciem els alumnes
		Ciclista[] ciclistes = new Ciclista[numParticipants];
		
		//Donem nom als participants i els posem a competir
		for (int i=0;i<numParticipants;i++) {
			ciclistes[i] = new Ciclista(nom+"-"+i);
			temps[i] = ciclistes[i].start();
		}

		//traiem els resultats i el temps que han trigat
		for (int i=0;i<numParticipants;i++) {
			System.out.println("Ciclista "+ciclistes[i].getNom()+" : " + temps[i]);
		}
	}
	
	

}
