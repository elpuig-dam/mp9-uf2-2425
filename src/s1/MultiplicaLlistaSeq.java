package s1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordi
 * Activitat 1 MP09-UF2
 * Exercici 1
 * Versió sequèncial de MultiplicaLlista.java
 */

public class MultiplicaLlistaSeq {
    public static final int MAX = 10000;
    static public class MultiplicaSeq {
        int op1,op2;
        public MultiplicaSeq(int op1, int op2) {
            this.op1 = op1;
            this.op2 = op2;
        }
        public int operar() {
            return op1*op2;
        }
    }

    public static void main(String[] args) {

        List<MultiplicaSeq> llistaOperacions= new ArrayList<>();
        List<Integer> llistaResultats = new ArrayList<>();

        //crear multiplicacions
        for(int i=0;i<MAX;i++) {
            MultiplicaSeq calcula = new MultiplicaSeq((int)(Math.random()*10), (int)(Math.random()*10));
            llistaOperacions.add(calcula);
        }
        //operar
        long temp1 = System.currentTimeMillis(); //agafem els milisegons de la data
        for(int i=0;i<MAX;i++) {
            llistaResultats.add(llistaOperacions.get(i).operar());
            // Si posem un println després de cada operació és més lent que la versió amb processos
            // sinó és més ràpida la versió sequüencial
            //System.out.println("Resultat " + i + " : " + llistaResultats.get(i));
        }
        long temp2 = System.currentTimeMillis();  //tornem a capturar els milisegons per calcular quan ha trigat


        for(int i=0;i<MAX;i++) {
            System.out.println("Resultat " + i + " : " + llistaResultats.get(i));
        }

        System.out.println("Ha trigat: " + (temp2-temp1) + " milisegons");


    }
}
