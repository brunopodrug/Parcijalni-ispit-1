import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaVozila {
    private List<Vozilo> vozila;

    public EvidencijaVozila() {
        this.vozila = new ArrayList<>();
    }

    public void dodajVozilo(Vozilo v) {
        vozila.add(v);
    }

    public void ispisVozila() {
        for (Vozilo v : this.vozila) {
            v.prikaziPodatke();
        }
    }

    public void spremiPodatkeUDatoteku(String datoteka) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(datoteka))) {
            for (Vozilo vozilo : this.vozila) {
                writer.write(vozilo.prikaziPodatke());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ucitajPodatkeIzDatoteke(String datoteka) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(datoteka))) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }
}
