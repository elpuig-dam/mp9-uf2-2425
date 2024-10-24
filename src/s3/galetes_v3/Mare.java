package s3.galetes_v3;


public class Mare implements Runnable {
	private Pot2 fam;
	private String Nom;
	
	public Mare(Pot2 f, String Nom) {
		fam=f;
		this.Nom=Nom;
	}

	@Override
	public void run() {
		//if((fam.getGaletes())<1) {
		for(;;) {
			fam.OmplePotGaletes(10);
			System.out.println("Sóc la mama " + Nom + " i he posat 10 galetes nens!\n");
			try {
				Thread.sleep((long) ((Math.random()*2000)+50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//}
		
	}
	

}
