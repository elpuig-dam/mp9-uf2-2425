package s3.galetes;

public class Fill extends Thread {
    Pot potGaletes;

    public Fill(String name,Pot potGaletes) {
        super(name);
        this.potGaletes = potGaletes;
    }

    @Override
    public void run() {
        for(;;) {
            //agafr la galeta
            potGaletes.agafaGaleta();
            System.out.println(getName() + " agafo una galeta");
            //triar la galeta del pot
            try {
                Thread.sleep((long) Math.random()*3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //deixar el pot
            potGaletes.deixarPot();

            //descansar o menjar
            try {
                Thread.sleep((long) Math.random()*3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
