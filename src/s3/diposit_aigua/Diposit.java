package s3.diposit_aigua;

public class Diposit {
    private int nivell;
    private boolean ple, buit;

    /**
     * Construcció del dipòsit amb un nivell de càrrega 0
     */
    public Diposit() {
        nivell = 0;
        buit = true;
    }

    /**
     * Mètode per incrementar el nivell de càrrega deñ dipòsit
     * incrementa en un 1% cada crida al mètode i actualitza l'estat de buit/ple si arriba al 100%
     */
    public void omplir() {
        if(!ple) {
            nivell += 1;
            buit = false;
        }
        if(nivell == 100) ple = true;
    }
    /**
     * Mètode per fer baixar el nivell del dipòsit
     * decrementa en un 1% cada crida al mètode i actualitza l'estat de buit/ple si arriba a 0%
     */
    public void buidar() {
        if(!buit) {
            nivell--;
            ple = false;
        }
        if(nivell == 0) buit = true;
    }

    /**
     * Mètode per comprovar el nivell actual del dipòsit
     * @return el nivell del dipòsit
     */
    public int getNivell() {
        return nivell;
    }
}