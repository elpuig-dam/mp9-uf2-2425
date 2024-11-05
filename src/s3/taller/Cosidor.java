package s3.taller;

public class Cosidor extends Thread {
    Cistell cistell;
    public Cosidor(Cistell cistell, String name) {
        super(name);
        this.cistell = cistell;
    }

    @Override
    public void run() {
        for(;;) {
            //cosir un temps
            try {
                Thread.sleep((long) Math.random() * 1000 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //posar peça al cistell una màniga cosida
            int c = cistell.posar(1);
            System.out.println(getName() + " he afegit una peça. Total = " + c);

        }

    }
}
