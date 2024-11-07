package s1;

public class Regata {

	public static void main(String[] args) {
		int numParticipants = 10;
		String nom = "Winsurfista";
		int temps[] = new int[numParticipants];
		
		//instanciem els alumnes
		Winsurfista[] ws = new Winsurfista[numParticipants];
		
		//Donem nom als participants i els posem a competir
		for (int i=0;i<numParticipants;i++) {
			ws[i] = new Winsurfista(nom+"-"+i);
			temps[i] = ws[i].competir();
		}

		//traiem els resultats i el temps que han trigat
		for (int i=0;i<numParticipants;i++) {
			System.out.println("Winsurfista "+ws[i].getNom()+" : " + temps[i]);
		}
	}
	
	

}
