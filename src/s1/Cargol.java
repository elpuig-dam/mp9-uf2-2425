package s1;

/**
 * Created by jordi.
 * Procés Cargol: Simula un sprint en metres d'un cargol
 * Mòdul M9. Activitat 2. Exercici 1
 * Necessita de monitorCargols.java i CursaCargols.java
 */

public class Cargol implements Runnable {
    private String Nom;
    private int metres;

    public Cargol(String nom) {
        Nom = nom;
    }

    public void addMetres(int m) {
        metres += m;
    }

    public String getNom() {
        return Nom;
    }

    public int getMetres() {
        return metres;
    }

    @Override
    public void run() {
        int sprint = (int) Math.floor(Math.random()*50);
        addMetres(sprint);
        System.out.println(Nom + ": he fet " + sprint +" metres");


    }
}
