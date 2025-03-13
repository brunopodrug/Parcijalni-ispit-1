import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Motocikl motor1 = new Motocikl(1, "Kawasaki", 2008, "600cc");
            Motocikl motor2 = new Motocikl(22, "Yamaha", 2018, "1000cc");

            Automobil auto1 = new Automobil(333, "BMW", 2002, 4);
            Automobil auto2 = new Automobil(4444, "Audi", 2020, 2);
            EvidencijaVozila skupVozila = new EvidencijaVozila();
            skupVozila.dodajVozilo(motor1);
            skupVozila.dodajVozilo(motor2);
            skupVozila.dodajVozilo(auto1);
            skupVozila.dodajVozilo(auto2);

            //motor1.prikaziPodatke();
            //motor2.prikaziPodatke();
            //auto1.prikaziPodatke();
            //auto2.prikaziPodatke();

            String fileName = "automobili.txt";
            skupVozila.spremiPodatkeUDatoteku(fileName);

            try {
                skupVozila.ucitajPodatkeIzDatoteke(fileName);
            }  catch (FileNotFoundException e) {
                System.err.println("File nije pronaden " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Greska pri citanj datoteke " + e.getMessage());
            }

        } catch (NeispravniPodaciException e) {
            System.err.print(e);
        }
    }
}