package wypozyczenie;

import java.time.Duration;
import java.time.LocalDate;

public class Wypozyczenie {

    private static final int DLUGOSC_WYPOZYCZENIA = 30;
    private static final double KARA = 0.1;
    private Egzemplarz egzemplarz;
    private LocalDate dataWypozczenia;
    private LocalDate dataOddania;
    private LocalDate przewidywanaDataOddania;

    public Wypozyczenie(Egzemplarz egzemplarz) {
        this.egzemplarz = egzemplarz;
        egzemplarz.setStan(Egzemplarz.Stan.WYPOZYCZONY);
        dataWypozczenia = LocalDate.now();
        przewidywanaDataOddania = dataWypozczenia.plusDays(DLUGOSC_WYPOZYCZENIA);
        dataOddania = null;
    }
    public double oddaj(){
        egzemplarz.setStan(Egzemplarz.Stan.WOLNY);
        dataOddania = LocalDate.now();
        if (przewidywanaDataOddania.isBefore(dataOddania)){
            long liczbaDni = Duration.between(dataOddania, przewidywanaDataOddania).toDays();
            return liczbaDni * KARA;
        }
        return 0;
    }
    public LocalDate prelonguj(){
        przewidywanaDataOddania = przewidywanaDataOddania.plusDays(DLUGOSC_WYPOZYCZENIA);
        return przewidywanaDataOddania;
    }
}
