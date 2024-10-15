package s3.Comandament;

import java.util.Arrays;
import java.util.Locale;

public class FightTV {
    public static void main(String[] args) {

        System.out.println(Locale.getDefault());
        Comandament comandament = new Comandament();
        MembreFamilia Joan = new MembreFamilia(comandament,"Joan");
        MembreFamilia Anna = new MembreFamilia(comandament,"Anna");
        MembreFamilia Pere = new MembreFamilia(comandament,"Pere");
        MembreFamilia Joanna = new MembreFamilia(comandament,"Joanna");

       Joan.start();
        Anna.start();
        Pere.start();
        Joanna.start();




    }
}
