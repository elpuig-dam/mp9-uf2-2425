package s3;

import java.util.ArrayList;
import java.util.List;

public class MainBanc {

    public static void main(String[] args) throws InterruptedException {
        CompteEstalvi compteEstalvi = new CompteEstalvi();
        List<Thread> threadList = new ArrayList<>();
        for(int i= 0; i < 1000; i++) {
            Thread op1 = new Thread(() -> compteEstalvi.ingres(100));
            Thread op2 = new Thread(() -> compteEstalvi.treu(50));
            op1.start();
            op2.start();
            threadList.add(op1);
            threadList.add(op2);
        }

        System.out.printf("Hi han %d Threads\n",threadList.size());
        //Fem join de tots els Threads que hem executat
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //op1.join();
        //op2.join();

        System.out.println("Total saldo: " + compteEstalvi.getSaldo());
    }
}
