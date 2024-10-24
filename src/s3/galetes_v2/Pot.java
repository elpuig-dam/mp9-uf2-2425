package s3.galetes_v2;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public  class Pot {
	
	private int galetes;
	private boolean potOcupat, HiHaGaletes; 
	
	public Pot() {
		galetes = 0;
		potOcupat = false;
		HiHaGaletes = false;
	}
	public Pot(int galetes) {
		this.galetes = galetes;
		potOcupat = false;
		HiHaGaletes = true;
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
		System.out.println("vull agafar");
		try {
			while(potOcupat || !HiHaGaletes) wait();
			potOcupat = true;
			this.galetes = this.galetes - n;
			System.out.println("Agafo "+n+" galetes");
			if(this.galetes <= 0) HiHaGaletes = false;
			potOcupat = false;
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
		Pot Fam = new Pot(20);
		// Crea un pool de 2 fils 
		final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
		// Crea objecte Runnable. 
		Fill nen = new Fill(Fam,"Joan");
		Fill nen2 = new Fill(Fam, "Pere");
		Fill nen3 = new Fill(Fam, "Ramon");
		Mare mama = new Mare(Fam,"Vicky");
		
		// Programa Fil, s'inicia als 2 segons i després es va executant cada 3 segons 
		schExService.scheduleWithFixedDelay(nen, 2, 3, TimeUnit.SECONDS); 
		schExService.scheduleWithFixedDelay(nen2, 4, 1, TimeUnit.SECONDS);
		schExService.scheduleWithFixedDelay(nen3, 4, 4, TimeUnit.SECONDS);
		schExService.scheduleWithFixedDelay(mama, 10, 3, TimeUnit.SECONDS);
		
		// Espera per acabar 35 segons 
		schExService.awaitTermination(30, TimeUnit.SECONDS);
		
		// shutdown . 
		schExService.shutdownNow();
		System.out.println("Completat");

	}

}