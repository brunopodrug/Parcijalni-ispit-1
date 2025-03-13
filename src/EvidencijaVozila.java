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
        System.out.println("Ucitani vozila iz file-a su:");
        for (Vozilo v : this.vozila) {
            System.out.print(v.prikaziPodatke());
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

    public void ucitajPodatkeIzDatoteke(String datoteka) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(datoteka))) {
            String fileLinija;
            EvidencijaVozila ucitanaVozila = new EvidencijaVozila();
            while ((fileLinija = reader.readLine()) != null) {
                String[] dijeloviLinije = fileLinija.split(",");
                if (dijeloviLinije[0].equals("Automobil")) {
                    Automobil automobil = parseAutomobil(dijeloviLinije);
                    ucitanaVozila.dodajVozilo(automobil);
                } else if (dijeloviLinije[0].equals("Motocikl")) {
                    Motocikl motocikl = parseMotocikl(dijeloviLinije);
                    ucitanaVozila.dodajVozilo(motocikl);
                }
            }
            ucitanaVozila.ispisVozila();
        } catch (IOException e) {
            throw e;
        } catch (NeispravniPodaciException e) {
            throw new RuntimeException(e);
        }
    }

    private Automobil parseAutomobil(String[] dijeloviLinije) throws NeispravniPodaciException {
        int regBroj = parseIntField(dijeloviLinije[1]);
        String marka = parseStringField(dijeloviLinije[2]);
        int godinaProizvodnje = parseIntField(dijeloviLinije[3]);
        int brVrata = parseIntField(dijeloviLinije[4]);

        return new Automobil(regBroj, marka, godinaProizvodnje, brVrata);
    }

    private Motocikl parseMotocikl(String[] dijeloviLinije) throws NeispravniPodaciException {
        int regBroj = parseIntField(dijeloviLinije[1]);
        String marka = parseStringField(dijeloviLinije[2]);
        int godinaProizvodnje = parseIntField(dijeloviLinije[3]);
        String tipMotora = parseStringField(dijeloviLinije[4]);

        return new Motocikl(regBroj, marka, godinaProizvodnje, tipMotora);
    }

    private int parseIntField(String field) {
        return Integer.parseInt(field.split(":")[1].trim());
    }

    private String parseStringField(String field) {
        return field.split(":")[1].trim();
    }
}
