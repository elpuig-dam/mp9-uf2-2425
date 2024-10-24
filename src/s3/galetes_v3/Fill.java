package s3.galetes_v3;


public class Fill implements Runnable  {
	private String Nom;
	private Pot2 fa;

	public Fill(Pot2 f, String nom) {
		fa=f;
		Nom = nom;
	} 
	

	@Override
	public void run() {
		for(;;) {
			fa.agafaGaletes(1);
			System.out.println("Sóc " + Nom + " galetes que queden = " + fa.getGaletes());
			/*try {
				Thread.sleep((long) ((Math.random()*50)+10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
	}
	
		

}