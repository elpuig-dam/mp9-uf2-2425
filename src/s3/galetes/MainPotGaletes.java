package s3.galetes;

public class MainPotGaletes {
    public static void main(String[] args) {
        Pot pot = new Pot(10);
        Fill joanet = new Fill("Joanet", pot);
        Fill marieta = new Fill("Marieta", pot);
        Fill ciscu = new Fill("Ciscu", pot);

        Pare ramon = new Pare("Ramón",pot);

        joanet.start();
        marieta.start();
        ciscu.start();
        ramon.start();

    }
}
