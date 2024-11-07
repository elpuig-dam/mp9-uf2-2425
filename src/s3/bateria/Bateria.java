package s3.bateria;

public class Bateria {
    private int nivell;
    boolean plena, buida;

    /**
     * Construcció de la bateria amb un nivell de càrrega determinat
     * @param nivell
     */
    public Bateria(int nivell) {
        this.nivell = nivell;
        if(nivell < 100) plena = false;
        else plena = true;
        if(nivell == 0) buida = true;
        else buida = false;
    }

    /**
     * Mètode per comprovar el nivell de la bateria
     * @return el nivell de la bateria
     */
    public int getNivell() {
        return nivell;
    }

    /**
     * Mètode per incrementar el nivell de càrrega de la bateria
     * incrementa en un 1% cada crida al mètode i actualitza l'estat de plena si arriba al 100%
     */
    public void carregar() {
        if(!plena) {
            nivell++;
            buida = false;
        }
        if(nivell == 100) plena = true;
    }

    /**
     * Mètode per decrementar el nivell de càrrega de la bateria
     * decrementa en un 1% cada crida al mètode i actualitza l'estat de buida si arriba a 0%
     */
    public void descarregar() {
        if(!buida) {
            nivell--;
            plena = false;
        }
        if(nivell == 0) buida = true;
    }

    /**
     * Mètode per comprovar si la bateria està plena
     * @return true si està plena, false si no
     */
    public boolean carregada() {
        return plena;
    }
}
