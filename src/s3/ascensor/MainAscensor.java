package s3.ascensor;

public class MainAscensor {
    public static void main(String[] args) {
        Ascensor a = new Ascensor(3);
        Motor motor = new Motor(a);
        Persona p = new Persona(a, "Joan");
        Persona p2 = new Persona(a, "Maria");
        Persona p3 = new Persona(a, "Xavier");
        Persona p4 = new Persona(a, "Anna");

        motor.start();
        p.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
