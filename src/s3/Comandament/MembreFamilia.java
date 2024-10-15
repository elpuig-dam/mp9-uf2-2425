package s3.Comandament;

import java.util.ResourceBundle;

public class MembreFamilia extends Thread {
	Comandament com;
	static int canal;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/i18n/missatges");

	public MembreFamilia(Comandament c, String nom) {
		super(nom);
		com = c;
		canal = 0;
	}

	@Override
	public void run() {
		for(;;) {
			//Agafa el comandament
			com.agafa();
			int canal2 = (int)((Math.random()*10)+1); // Tria el canal
			//System.out.println(getName() + " està mirant el canal " + canal2 + new String((canal==canal2)?" ":" (ha canviat de canal)"));
			System.out.format("%s %s %d %n", getName(),resourceBundle.getString("persona.mirar_tv"), canal2);
			canal = canal2;
			//Mira la tele
			try {
				Thread.sleep((long) (Math.random()*800)+200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Deixa el comandament
			com.deixa();
			//Descansa de tanta tele
			try {
				//System.out.println(getName() + " ja no miro la tele");
				System.out.format("%s %s %n", getName(),resourceBundle.getString("persona.deixar_tv"));
				Thread.sleep((long) (Math.random()*1000)+500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
