package s3.cursarelleus;

public class Atleta extends Thread {
	Testimoni t;
	int tmp;
	
	public Atleta(Testimoni t) {
		this.t = t;
		tmp = 0;
	}

	public int getTmp () {
		return tmp;
	}
	
	@Override
	public void run() {
		if(t!=null)	t.agafar();
		tmp = (int) ((Math.random()*4000)+4000);
		System.out.println(getName() + " corrent...");
		try {
			Thread.sleep(tmp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//passar testimoni
		if(t!=null) t.deixar();

	}

	
}
