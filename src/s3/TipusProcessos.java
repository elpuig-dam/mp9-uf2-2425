package s3;

public class TipusProcessos {

    public static void main(String[] args) {
        Runnable p1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("són p1");
            }
        };

        Thread p2 = new Thread(p1);
    }
}
