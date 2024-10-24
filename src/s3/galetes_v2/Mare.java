package s3.galetes_v2;


public class Mare implements Runnable {
	private Pot fam;
	private String Nom;
	
	public Mare(Pot f, String Nom) {
		fam=f;
		this.Nom=Nom;
	}

	@Override
	public void run() {
		//if((fam.getGaletes())<1) {
			fam.OmplePotGaletes(10);
			System.out.println("Sóc la mama "+ Nom +" i he posat 10 galetes nens!\n");
		//}
		
	}
	

}
