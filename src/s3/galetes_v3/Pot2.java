package s3.galetes_v3;

public  class Pot2 {

	private int galetes;
	private volatile int maxNensPot, numProcesosPot;
	private boolean potOcupat, HiHaGaletes;

	public Pot2() {
		galetes = 0;
		potOcupat = false;
		HiHaGaletes = false;
		maxNensPot = 1;
		numProcesosPot = 0;
		System.out.println("Max de nens al pot:" + maxNensPot);
	}
	public Pot2(int galetes, int max) {
		this.galetes = galetes;
		potOcupat = false;
		HiHaGaletes = true;
		maxNensPot = max;
		numProcesosPot = 0;
		System.out.println("Max de nens al pot:" + max);
	}

	public synchronized void OmplePotGaletes(int n) {
		System.out.println("vull omplir...");
		try {
			while(potOcupat || HiHaGaletes) wait();
			potOcupat = true;
			this.galetes = n;
			System.out.println("Pot omplert amb "+n+" galetes");
			HiHaGaletes = true;
			potOcupat = false;
			notifyAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}

	public synchronized int agafaGaletes(int n) {
		System.out.println("vull agafar, hi han " + numProcesosPot + " processos");
		try {
			while(potOcupat || !HiHaGaletes){
				System.out.println("nunP: " + numProcesosPot + " maxP:" + maxNensPot + " HiHAGal:" + HiHaGaletes);
				wait();
			}
			numProcesosPot += 1;
			if(numProcesosPot == maxNensPot){
				potOcupat = true;
				System.out.println("MAX->OCUPAT");
			}else System.out.println("----------->ocupat?" + potOcupat);
			this.galetes = this.galetes - n;
			System.out.println("Agafo "+n+" galetes " + "Hi han " + numProcesosPot + " al pot");

			if(this.galetes <= 0) HiHaGaletes = false;
			notifyAll();
			try {
				Thread.sleep((long) ((Math.random()*10000)+2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			numProcesosPot -= 1;
			if(numProcesosPot < maxNensPot) potOcupat = false;
			notifyAll();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return galetes;
	}
	

	
	public synchronized int getGaletes() {
		return galetes;
	}

	public static void main(String[] args) throws InterruptedException {
		Pot2 Fam = new Pot2(2,4);
		// Crea un pool de 2 fils 
		// Crea objecte Runnable.
		Thread nen = new Thread(new Fill(Fam,"Joan"));
		Thread nen2 = new Thread(new Fill(Fam, "Pere"));
		Thread nen3 = new Thread(new Fill(Fam, "Ramon"));
		Thread nen4 = new Thread(new Fill(Fam,"Víctor"));
		Thread nen5 = new Thread(new Fill(Fam, "Javier"));
		Thread nen6 = new Thread(new Fill(Fam, "Pedro"));
		Thread mama = new Thread(new Mare(Fam,"Vicky"));

		nen.start();
		nen2.start();
		nen3.start();
		nen4.start();
		nen5.start();
		nen6.start();
		mama.start();


	}

}