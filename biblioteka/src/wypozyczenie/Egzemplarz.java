package wypozyczenie;

import ksiazka.Ksiazka;

public class Egzemplarz {
    private Ksiazka ksiazka;

    public enum Stan{
        WYPOZYCZONY,
        WOLNY
    }
    private Stan stan;

    public Egzemplarz(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
        stan = Stan.WOLNY;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    @Override
    public String toString() {
        return "Egzemplarz{" +
                "ksiazka=" + ksiazka +
                ", stan=" + stan +
                '}';
    }
}
