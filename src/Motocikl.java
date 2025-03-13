public class Motocikl extends Vozilo {
    private String tipMotora;

    public Motocikl(int regBroj, String marka, int godinaProizvodnje, String tipMotora) throws NeispravniPodaciException {
        super(regBroj, marka, godinaProizvodnje);
        if (tipMotora == null || tipMotora.isEmpty())
            throw new NeispravniPodaciException("Neispravan unos tipa motora.");

        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    @Override
    public String prikaziPodatke() {
        return super.prikaziPodatke() + ", tip motora: " + this.tipMotora + "\n";
    }
}
