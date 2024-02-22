package ksiazka;

import java.util.Objects;

public class Ksiazka {
    private final String tytul;
    private final Gatunek gatunek;
    private final Autor autor;
    private final int rokWydania;

    public Ksiazka(String tytul, Gatunek gatunek, Autor autor, int rokWydania) {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    public String getTytul() {
        return tytul;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }
    @Override
    public String toString(){
        return String.format("%s; %s", tytul, autor.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return Objects.equals(tytul, ksiazka.tytul) && Objects.equals(autor, ksiazka.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, autor);
    }
}
