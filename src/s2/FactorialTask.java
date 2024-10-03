package s2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private int n;
    public static final int LLINDAR = 10;

    public FactorialTask(int _n) {
        n = _n;
    }

    private Long factorialR() {
        // no cal comprovar per n=1 perquè ja ho fa el seqüencial
        FactorialTask f1 = new FactorialTask(n-1);
        f1.fork();
        return f1.join() * n;
    }

    private Long factorialS() {
        if(n==1) return (long)1;
        else {
            long temp = 1;
            for(int i=1; i<=n; i++) {
                temp = temp * i;
            }
            return temp;
        }
    }

    @Override
    protected Long compute() {
        if(n < LLINDAR) return factorialS();
        else return factorialR();

    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        FactorialTask factorialTask = new FactorialTask(4);
        pool.invoke(factorialTask);
        Long result2 = factorialTask.join();

        System.out.println(result2);
    }
}
