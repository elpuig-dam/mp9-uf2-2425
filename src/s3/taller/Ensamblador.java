package s3.taller;

public class Ensamblador extends Thread {
    Cistell cistellA, cistellB;
    public Ensamblador(Cistell cistellA, Cistell cistellB, String name) {
        super(name);
        this.cistellA = cistellA;
        this.cistellB = cistellB;
    }

    @Override
    public void run() {
        for (;;) {
            //agafar 2 màniques dels cistell A
            cistellA.treure(2);
            //agafar cos del cistell B
            cistellB.treure(1);

            //Encadellar
            try {
                Thread.sleep((long) Math.random() * 1500 + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("He encadellat un jersey");

        }
    }
}
