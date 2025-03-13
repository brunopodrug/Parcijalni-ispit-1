public class Vozilo {
    private int regBroj;
    private String marka;
    private int godinaProizvodnje;

    public Vozilo(int regBroj, String marka, int godinaProizvodnje) throws NeispravniPodaciException {
        if (godinaProizvodnje < 0)
            throw new NeispravniPodaciException("Godina proizvodnje ne moze biti negativna.");

        this.regBroj = regBroj;
        this.marka = marka;
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String prikaziPodatke() {
        return ",Registracijski broj:" + this.regBroj + ",marka vozila:" + this.marka +
                ",godina proizvodnje:" + this.godinaProizvodnje;
    }
}
