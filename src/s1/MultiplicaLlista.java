package s1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jordi on 23/11/16.
 * Activitat 1 MP09-UF2
 * Exercici 1
 * Utilitza: Multiplicacio.java
 */

public class MultiplicaLlista {
    public static final int MAX = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Multiplicacio> llistaTasques= new ArrayList<Multiplicacio>();

        for (int i = 0; i < MAX; i++) {
            Multiplicacio calcula = new Multiplicacio((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);

        }
        List<Future<Integer>> llistaResultats;

        long temp1 = System.currentTimeMillis(); //agafem els milisegons de la data
        llistaResultats = executor.invokeAll(llistaTasques);
        executor.shutdown();
        long temp2 = System.currentTimeMillis();  //tornem a capturar els milisegons per calcular quan ha trigat


        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println("Resultat tasca "+i+ " és:" + resultat.get());
            } catch (InterruptedException | ExecutionException e) { }
        }

        System.out.println("Ha trigat: " + (temp2-temp1) + " milisegons");


    }
}
