package s3.galetes;

public class Pot {

    private int num;
    private boolean lliure;


    public Pot(int num) {
        this.num = num;
        lliure = true;
        System.out.println("Pot nou amb " + num + " galetes");
    }

    public synchronized void agafaGaleta()  {
        try {
            while(!lliure || num==0) wait();
            lliure = false;
            num--;
            System.out.println("Queden " + num + " galetes");
            notifyAll();
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    public synchronized void posarGaletes() {
        try {
            while(!lliure || num > 0) wait();
            lliure = false;
            num += 10;
            notifyAll();
            System.out.println("Queden " + num + " galetes");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deixarPot() {
        lliure = true;
        notifyAll();

    }


}
