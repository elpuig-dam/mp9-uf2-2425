package s3.taller;

public class Cistell {
    private int capacitat;
    private int qtat;

    public Cistell(int capacitat) {
        this.capacitat = capacitat;
        qtat = 0;
    }

    public synchronized int posar(int n) {
        try {
            while((qtat+n) > capacitat) wait();
            qtat += n;
            notifyAll();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        return qtat;
    }

    public synchronized int treure(int n) {
        try {
            while((qtat-n) < 0) wait();
            qtat -= n;
            notifyAll();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        return qtat;
    }
}
