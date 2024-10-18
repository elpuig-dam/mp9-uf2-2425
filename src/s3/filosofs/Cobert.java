package s3.filosofs;

public class Cobert {

	public enum EstatCobert {
		LLIURE, OCUPAT
	}
	
	private  EstatCobert estat;
	
	public Cobert () {
		estat = EstatCobert.LLIURE;
	}

	public synchronized Enum<EstatCobert> getEstat() {
		return estat;
	}

	public synchronized void agafar() {
		try {
			
			while (estat == EstatCobert.OCUPAT) wait();
			estat = EstatCobert.OCUPAT;
			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void deixar() {
		estat = EstatCobert.LLIURE;
		notifyAll();
	}

}
