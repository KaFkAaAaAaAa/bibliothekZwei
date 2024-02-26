import ksiazka.Autor;
import ksiazka.Ksiazka;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteka biblioteka = new Biblioteka();
        String menu = "1. Wyszukaj książki autora \n" +
                "2. Dodaj egzemplarz książki \n" +
                "3. Wypożycz książkę \n" +
                "4. Zwróć książkę \n" +
                "5. Wyświetl wypożyczenia \n" +
                "6. Wyjdź" ;
        while (true){
            System.out.println(menu);
            int wybor = scanner.nextInt();
            scanner.nextLine();
            switch (wybor){
                case 1:
                    //wyświetlenie książek na podstawie autora
                    System.out.println(biblioteka.wyszukajKsiazke(biblioteka.stworzAutora()));
                    break;
                case 2:
                    biblioteka.dodajKsiazke();
                    break;
                case 3:
                    System.out.println("Podaj tytuł książki do wypożyczenia: ");
                    String tytul = scanner.nextLine();
                    //wyszukuje książkę na podstawie tytułu której szukamy egzemplarza który wypożyczamy
                    biblioteka.wypozyczKsiazke(biblioteka.wyszukajWolnyEgzeplarz(biblioteka.wyszukajKsiazke(tytul)));
                    break;
                case 4:
                    System.out.println("Podaj tytuł książki do zwrotu: ");
                    String tytul2 = scanner.nextLine();
                    System.out.println("Podaj datę wypożyczenia (RRRR-MM-DD): ");
                    //szuka daty wypożyczenia egzemplarza
                    LocalDate data = LocalDate.parse(scanner.nextLine());
                    Ksiazka ksiazka = biblioteka.wyszukajKsiazke(tytul2);
                    //używa jakby to był klucz główny na podstawie tytułu i daty wypożyczenia
                    biblioteka.oddajKsiazke(ksiazka, data);
                    break;
                case 5:
                    biblioteka.wyswietlWypozyczenia();
                    break;
                case 6:
                    return;
            }
        }

    }
}