package s2;

import java.util.concurrent.RecursiveTask;

public class MaximTask extends RecursiveTask<Short> {

    private static final int LLINDAR=10000;
    private short[] arr ;
    private int inici, fi;

    public MaximTask(short[] arr, int inici, int fi) {
        this.arr = arr;
        this.inici = inici;
        this.fi = fi;
    }

    private short getMaxSeq(){
        short max = arr[inici];
        for (int i = inici+1; i < fi; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private short getMaxReq(){
        MaximTask task1;
        MaximTask task2;
        int mig = (inici+fi)/2+1;
        task1 = new MaximTask(arr, inici, mig);
        //task1.fork();
        task2 = new MaximTask(arr, mig, fi);
        //task2.fork();
        invokeAll(task1,task2);
        return (short) Math.max(task1.join(), task2.join());
    }


    @Override
    protected Short compute() {
        if(fi - inici <= LLINDAR){
            return getMaxSeq();
        }else{
            return getMaxReq();
        }
    }
}
