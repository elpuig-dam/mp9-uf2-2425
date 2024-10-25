package s3.ascensor;

public class Ascensor {
    private int pis, qtat;
    private boolean puja, ple;
    private int cap;

    public Ascensor(int capacitat) {
        puja = true;
        ple = false;
        pis = 0;
        cap = capacitat;
    }

    // pujar vol dir entrar a l'ascensor
    public synchronized void pujar(int npis) {
        try {
            while(npis != pis || ple) wait();
            //una persona més
            qtat++;
            System.out.println("Hi ha " + qtat + " persones");
            if(qtat == cap) ple=true;
            notifyAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int seguent_pis() {

        if(pis < 10 && puja) pis++;
        if(pis > 0 && !puja) pis--;
        if(pis == 10 && puja) puja = false;
        if(pis == 0 && !puja) puja = true;
        notifyAll();
        return pis;
    }

    // baixar vol dir baixar de l'ascensor
    public synchronized void baixar() {
        if(qtat > 0) qtat--;
        if(ple) ple = false;
        notifyAll();
    }

    // baixar vol dir baixar de l'ascensor al npis
    public synchronized void baixar(int npis) {
        try {
            while(npis != pis) wait();
            //una persona menys
            qtat--;
            System.out.print(" Hi ha " + qtat + " persones ");
            if(ple) ple = false;
            notifyAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getPis() {
        return pis;
    }

    public synchronized boolean isPle() {
        return ple;
    }


}