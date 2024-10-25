package s3.ascensor;

public class Persona extends Thread {
    private Ascensor ascensor;
    private int pis, pis_inicial;

    public Persona(Ascensor asc, String nom) {
        super(nom);
        ascensor = asc;
    }

    @Override
    public void run() {

        pis_inicial = triar_pis();
        int pis_final = triar_pis();
        System.out.println(getName() + " sóc al pis " + pis_inicial + " i vull anar al " + pis_final);
        ascensor.pujar(pis_inicial);  //intenta entrar al ascensor des del pis on està
        System.out.println(getName() + " he pujat" );

        //SOLUCIÓ SENSE MONITORITZAR LA SORTIDA DE L'ASCENSOR
        //while(ascensor.getPis() != pis);
        //if(ascensor.getPis() == pis) {
        //    ascensor.baixar();
        //    System.out.println(getName() + " he baixat" );
        //}

        /****************************************************/
        /** SOLUCIÓ MONITORITZANT LA SORTIDA DE L'ASCENSOR
        /** I MES EFICIENT.
        /****************************************************/
        ascensor.baixar(pis_final);
        System.out.println(getName() + " he baixat" );


    }

    private int triar_pis() {
        do {
            pis = (int) (Math.random() * 10) + 1;
        }while(pis == pis_inicial);
        return pis;
    }
}
