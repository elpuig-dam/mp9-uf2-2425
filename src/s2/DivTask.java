package s2;

import java.util.concurrent.RecursiveTask;

public class DivTask extends RecursiveTask<Integer> {
    //ds: divisor i dd: divident
    private int ds, dd;
    private static int LLINDAR = 30;

    public DivTask(int _dd, int _ds) {
        ds = _ds;
        dd = _dd;
    }

    //restes recursives
    public Integer divR() {
        if(ds > dd) return 0;
        else {
            DivTask f = new DivTask(dd-ds,ds);
            f.fork();
            return f.join() + 1;
        }
    }

    //restes iteratives
    public Integer divS() {
        int c = 0;
        while( dd >= ds){
            dd = dd - ds;
            c++;
        }
        return c;
    }

    @Override
    protected Integer compute() {
        System.out.println(dd + "/" + ds);
        if(dd-ds > LLINDAR) return divR();
        else return divS();
    }
}
