package s3.taller;

public class Taller {

    public static void main(String[] args) {
        Cistell cistell_manigues = new Cistell(8); //8 és la capacitat màxima del cistell
        Cistell cistell_cossos = new Cistell(5); //5 és la capacitat màxima del cistell
        Cosidor cosidor_manigues = new Cosidor(cistell_manigues, "Maniga");
        Cosidor cosidor_cossos = new Cosidor(cistell_cossos, "Cos");
        Ensamblador ensamblador = new Ensamblador(cistell_manigues,cistell_cossos,"Peça");

        cosidor_manigues.start();
        cosidor_cossos.start();
        ensamblador.start();
    }


}
