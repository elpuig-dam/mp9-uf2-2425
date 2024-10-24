package s3.galetes_v2;


public class Fill implements Runnable  {
	private String Nom;
	private Pot fa;

	public Fill(Pot f, String nom) {
		fa=f;
		Nom = nom;
	} 
	
	public Fill() {
		super();
	}

	public Fill(String nom) {
		super();
		Nom = nom;
	}
	

	@Override
	public void run() {
		fa.agafaGaletes(1);
		System.out.println("Sóc " + Nom + " galetes que queden = " + fa.getGaletes());
	}
	
		

}