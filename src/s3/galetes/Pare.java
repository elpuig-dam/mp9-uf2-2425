package s3.galetes;

public class Pare extends Thread {
    Pot pot;

    public Pare(String name,Pot pot) {
        super(name);
        this.pot = pot;
    }

    @Override
    public void run() {
        for(;;) {
            pot.posarGaletes();
            System.out.println(getName() + " ha posat més galetes");
            try {
                Thread.sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pot.deixarPot();
            try {
                Thread.sleep((long) Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
