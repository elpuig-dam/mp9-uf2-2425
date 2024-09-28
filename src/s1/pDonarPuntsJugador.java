package s1;

/* Procés que assigna punts de 0 q 100 aleatòriament a un Jugador */
public class pDonarPuntsJugador implements Runnable {
	Jugador jug;
	
	public pDonarPuntsJugador(Jugador j) {
		jug = j;
	}

	@Override
	public void run() {
		int p = (int) ((Math.random())*100);
		jug.setPunts(p);
		System.out.println("donant punts a en " + jug.getNom() + ":" + p);
	}

}
