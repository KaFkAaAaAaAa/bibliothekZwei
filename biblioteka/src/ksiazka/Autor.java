package ksiazka;

import java.util.Objects;

public class Autor {
    private final String imie;
    private final String nazwisko;
    private int rokUrodzenia;
    private int rokSmierci = 0;

    public Autor(String imie, String nazwisko, int rokUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
    }

    public Autor(String imie, String nazwisko, int rokUrodzenia, int rokSmierci) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.rokSmierci = rokSmierci;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    public int getRokSmierci() {
        return rokSmierci;
    }

    public void setRokSmierci(int rokSmierci) {
        this.rokSmierci = rokSmierci;
    }
    @Override
    public String toString(){
        String rokSmierci = this.rokSmierci == 0 ? "":String.valueOf(this.rokSmierci);
        return String.format("%s, %s (%d-%s)", nazwisko, imie, rokUrodzenia, rokSmierci);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return rokUrodzenia == autor.rokUrodzenia && rokSmierci == autor.rokSmierci && Objects.equals(imie, autor.imie) && Objects.equals(nazwisko, autor.nazwisko);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, rokUrodzenia, rokSmierci);
    }
}