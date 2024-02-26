import ksiazka.Autor;
import ksiazka.Gatunek;
import ksiazka.Ksiazka;
import wypozyczenie.Egzemplarz;
import wypozyczenie.Wypozyczenie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
    ArrayList<Ksiazka> ksiazki = new ArrayList<>();
    ArrayList<Egzemplarz> egzemplarze = new ArrayList<>();
    ArrayList<Wypozyczenie> wypozyczenia = new ArrayList<>();

    public Ksiazka wyszukajKsiazke(String tytul){
        for (Ksiazka ksiazka: ksiazki) {
            if (ksiazka.getTytul().equals(tytul)) return ksiazka;
        }
        return null;
    }
    public ArrayList<Ksiazka> wyszukajKsiazke(Autor autor){
        ArrayList<Ksiazka> znalezioneKsiazki = new ArrayList<>();
        for (Ksiazka ksiazka: ksiazki) {
            if (ksiazka.getAutor().equals(autor)) znalezioneKsiazki.add(ksiazka);
        }

        return (znalezioneKsiazki.isEmpty()) ? null : znalezioneKsiazki;
    }
    public ArrayList<Ksiazka> wyszukajKsiazke(Gatunek gatunek){
        ArrayList<Ksiazka> znalezioneKsiazki = new ArrayList<>();
        for (Ksiazka ksiazka: ksiazki) {
            if (ksiazka.getGatunek().equals(gatunek)) znalezioneKsiazki.add(ksiazka);
        }

        return (znalezioneKsiazki.isEmpty()) ? null : znalezioneKsiazki;
    }
    public Egzemplarz wyszukajWolnyEgzeplarz(Ksiazka szukanaKsiazka){
        for (Egzemplarz egzemplarz: egzemplarze) {
            if (egzemplarz.getKsiazka().equals(szukanaKsiazka)
                    && egzemplarz.getStan() == Egzemplarz.Stan.WOLNY) return egzemplarz;
        }
        return null;
    }
    public void dodajKsiazke(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tytuł książki: ");
        String tytul = scanner.nextLine();

        System.out.println("Wpisz gatunek książki: ");
        Gatunek gatunek = switch (scanner.nextLine()){
            case "Kryminał" -> Gatunek.KRYMINAL;
            case "Popularno-naukowe" -> Gatunek.POPULARNO_NAUKOWE;
            case "Fantastyka" -> Gatunek.FANTASTYKA;
            case "Biografia" -> Gatunek.BIOGRAFIA;
            default -> Gatunek.KRYMINAL;
        };
        Autor autor = stworzAutora();

        System.out.println("Podaj rok wydania: ");
        int rokWydania = scanner.nextInt();
        Ksiazka ksiazka = new Ksiazka(tytul, gatunek, autor, rokWydania);
        if(!ksiazki.contains(ksiazka)){
            ksiazki.add(ksiazka);
        }

        egzemplarze.add(new Egzemplarz(ksiazka));
    }
    public Autor stworzAutora(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj imię autora: ");
        String imie = scanner.nextLine();

        System.out.println("Podaj nazwisko autora: ");
        String nazwisko = scanner.nextLine();

        System.out.println("Podaj rok urodzenia autora: ");
        int rokUrodzenia = scanner.nextInt();

        System.out.println("Podaj rok śmierci autora: ");
        int rokSmierci = scanner.nextInt();

        return new Autor(imie, nazwisko, rokUrodzenia, rokSmierci);
    }
    public void wypozyczKsiazke(Egzemplarz e){
        wypozyczenia.add(new Wypozyczenie(e));
    }
    public void oddajKsiazke(Ksiazka e, LocalDate data){
        ArrayList<Wypozyczenie> prawdopodobneWypozyczenie = new ArrayList<>();
        //krok 1: zmiejszenie zakresu wyszukiwania na podstawie daty
        for (Wypozyczenie w: wypozyczenia){
            if (w.getDataWypozczenia().equals(data)){
                prawdopodobneWypozyczenie.add(w);
            }
        }
        //krok 2: dalsze zmniejszenie zakresu na podstawie książki
        for (Wypozyczenie w: prawdopodobneWypozyczenie){
            if (w.getEgzemplarz().getKsiazka().equals(e)){
                w.oddaj();
                break;
            }
        }
    }

    public void wyswietlWypozyczenia(){
        for (Wypozyczenie w: wypozyczenia){
            System.out.println(w);
        }
    }
}
