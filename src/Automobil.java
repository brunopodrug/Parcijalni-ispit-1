public class Automobil extends Vozilo {
    private int brojVrata;

    public Automobil(int regBroj, String marka, int godinaProizvodnje, int brojVrata) throws NeispravniPodaciException{
        super(regBroj, marka, godinaProizvodnje);
        if (brojVrata <= 0 )
            throw new NeispravniPodaciException("Broj vrata ne moze biti negativan.");

        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    @Override
    public String prikaziPodatke() {
       return "Automobil" + super.prikaziPodatke() + ",broj vrata:" + this.brojVrata + "\n";
    }
}
