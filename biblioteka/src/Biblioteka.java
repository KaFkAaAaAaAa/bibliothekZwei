import ksiazka.Autor;
import ksiazka.Gatunek;
import ksiazka.Ksiazka;
import wypozyczenie.Egzemplarz;
import wypozyczenie.Wypozyczenie;

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

        System.out.println("Podaj autora: ");
        String autor = scanner.nextLine();

        System.out.println("Podaj rok wydania: ");
        int rokWydania = scanner.nextInt();
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
        return null;
    }

}
