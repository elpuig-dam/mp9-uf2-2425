package s2;

import java.util.concurrent.ForkJoinPool;

public class Dividir {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        DivTask div = new DivTask(100,12);

        pool.invoke(div);
        int res = div.join();

        System.out.println("Resultat:" + res);
    }
}
