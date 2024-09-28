package s1;

/* Procés que monitoritza un jugador i informa de quants punts porta acumulats */
public class pLlegirPuntsJugadors implements Runnable {
	Jugador jug;

	public pLlegirPuntsJugadors(Jugador j) {
		jug = j;
	}

	@Override
	public void run() {
		System.out.println("El jugador " + jug.getNom() + " porta " + jug.getPunts());
	}

}
