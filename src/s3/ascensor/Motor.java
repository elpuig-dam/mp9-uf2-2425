package s3.ascensor;

public class Motor extends Thread {
    Ascensor ascensor;
    public Motor(Ascensor a) {
        ascensor = a;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ascensor.seguent_pis();
            System.out.println(ascensor.getPis());
        }
    }
}
