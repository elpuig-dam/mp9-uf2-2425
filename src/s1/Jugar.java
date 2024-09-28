package s1;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Jugar {

	public Jugar() {}

	public static void main(String[] args) throws InterruptedException {

		// Es creen dos jugadors
		Jugador jug = new Jugador("Joan");
		Jugador jug2 = new Jugador("Pere");

		// Instanciem els processos de donar i llegir punts amb els jugadors
		// Un procés controla només un jugador
		pDonarPuntsJugador donar = new pDonarPuntsJugador(jug);
		pLlegirPuntsJugadors llegir = new pLlegirPuntsJugadors(jug);
		pDonarPuntsJugador donar2 = new pDonarPuntsJugador(jug2);
		pLlegirPuntsJugadors llegir2 = new pLlegirPuntsJugadors(jug2);

		// Executem els 4 processos (2 de donar punts i 2 de llegir punts)
		ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
		schExService.scheduleWithFixedDelay(donar, 2, 2, TimeUnit.SECONDS);
		schExService.scheduleWithFixedDelay(llegir, 4, 4, TimeUnit.SECONDS);
		schExService.scheduleWithFixedDelay(donar2, 5, 1, TimeUnit.SECONDS);
		schExService.scheduleWithFixedDelay(llegir2, 3, 5, TimeUnit.SECONDS);


		// Esperem a que passin els 25s o bé a que acabin tots
		schExService.awaitTermination(25, TimeUnit.SECONDS);
		schExService.shutdownNow();

		System.out.println("En " + jug.getNom() + " ha acabat amb " + jug.getPunts() + " punts");
		System.out.println("En " + jug2.getNom() + " ha acabat amb " + jug2.getPunts() + " punts");
	}

}
