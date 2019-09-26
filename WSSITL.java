

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import static java.util.stream.Collectors.toList;

import java.util.*;


public class WSSITL {

    public static void main(String[] args) throws IOException {

        Cena cena_lotu=new Cena();



        List<Lot> Lista_Lotow = new ArrayList<>();
        Lista_Lotow.add(new Lot("Warszawa", "WAW", "Berlin", "BER", 1, 40, 0, 300, "2019-07-03", "2019-11-11", false));
        Lista_Lotow.add(new Lot("Berlin", "WAW", "Warszawa", "BER", 2, 80, 0, 200, "2019-06-15", "2019-11-02", false));
        Lista_Lotow.add(new Lot("Londyn", "LON", "Warszawa", "WAR", 3, 11, 0, 500, "2019-08-11", "2019-12-01", false));
        Lista_Lotow.add(new Lot("Francja", "FRN", "Berlin", "BER", 2, 13, 0, 500, "2019-06-21", "2019-12-22", false));
        Lista_Lotow.add(new Lot("Amsterdam", "WAW", "Francja", "FRN", 2, 56, 0, 200, "2019-06-21", "2019-10-13", false));
        Lista_Lotow.add(new Lot("Warszawa", "BER","Berlin", "BER", 1, 110, 0, 300, "2019-07-11", "2019-09-15", false));
        Lista_Lotow.add(new Lot("Amsterdam", "WAW", "Berlin", "BER", 1, 100, 0, 100, "2019-06-11", "2019-09-21", false));
        Lista_Lotow.add(new Lot("Londyn", "LON", "Berlin", "BER", 1, 98, 0, 300, "2019-08-19", "2019-12-25", false));
        Lista_Lotow.add(new Lot("Warszawa", "BER", "Francja", "FRN",2, 50, 0, 200, "2019-10-01", "2019-12-05", false));
        Lista_Lotow.add(new Lot("Warszawa", "BER", "Amsterdam", "AMS", 1, 49, 0, 100, "2019-09-22", "2019-09-07", false));

        Lot wybrany_lot = new Lot();
        int opcja;
        Scanner odczyt = new Scanner(System.in);

        for(int i=0;i<Lista_Lotow.size();i++)
        {
            System.out.println(i+" "+Lista_Lotow.get(i).cena);
            Lista_Lotow.get(i).cena=cena_lotu.cena(Lista_Lotow.get(i).cena_bazowa,Lista_Lotow.get(i).liczba_miejsc,Lista_Lotow.get(i).data_wylotu);
            System.out.println(i+" "+Lista_Lotow.get(i).cena);
        }



        System.out.println("Witaj w liniach lotniczych Who says sky is the limit? \n" +
                "Wybór zatwierdza sie poprzez wpisanie cyfry odpowiadającej danej opcji \n" +
                "Wybierz opcje według której mają być posortowane loty:  \n" +
                "1-Miejsce wylotu \n" + "" +
                "2-Data wylotu \n" +
                "3-Cena");


        opcja = odczyt.nextInt();


        switch (opcja) {
            case 1:
                Lista_Lotow = Lista_Lotow.stream()
                        .sorted(Lot::compareTo1)
                        .collect(toList());
                Lista_Lotow.stream()
                        .forEach(System.out::println);


                break;
            case 2:
                Lista_Lotow = Lista_Lotow.stream()
                        .sorted(Lot::compareTo2)
                        .collect(toList());
                Lista_Lotow.stream()
                        .forEach(System.out::println);
                break;
            case 3:
                Lista_Lotow = Lista_Lotow.stream()
                        .sorted(Lot::compareTo3)
                        .collect(toList());
                Lista_Lotow.stream()
                        .forEach(System.out::println);
                break;
        }

        System.out.println("Wybierz który chcesz lot:");
        opcja = odczyt.nextInt();
        wybrany_lot = Lista_Lotow.get(opcja - 1);


//Rezerwacja lotów
        System.out.println("Wybrałes lot:   " + Lista_Lotow.get(opcja - 1) + "\n" +
                "Czy lot ma być klasą biznesową? \n" +
                "1-Tak\n" +
                "2-Nie");
        opcja = odczyt.nextInt();
        if (opcja == 1) {
            System.out.println("Wybrano klase biznesową, Doliczono opłatę");
            wybrany_lot.klasa=true;
            wybrany_lot.cena = (int) ((wybrany_lot.cena) * 1.65);
            System.out.println(wybrany_lot);
        } else
            System.out.println("Wybrano klasę ekonomiczną.");

        System.out.println("ile biletów chcesz zarezerwować?");
        opcja = odczyt.nextInt();


        try {
            if (wybrany_lot.liczba_miejsc >= 110) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Wszystkie miejsca zarezerwowane. Wybierz inny lot.");
            System.exit(0);
        }


        if (wybrany_lot.liczba_miejsc + opcja > 100) {
            System.out.println("Niestety liczba rezerwacji i zakupionych przez ciebie biletów przekracza ilośc miejsc. \n" +
                    "Mozemy zaproponować lot jako steward/stewardesa ze zniżką 20% \n" +
                    "Jeteś zainteresowany? \n" +
                    "1-Tak\n" +
                    "2-Nie");
            opcja = odczyt.nextInt();
            if (opcja == 1) {
                System.out.println("wybrano lot jako steward/stewardesa.");
                wybrany_lot.cena = (int) (wybrany_lot.cena * 0.80);
            } else {
                System.out.println("MOżemy również zaproponować lot na skrzydle z rabeatem 50%." +
                        "Jeteś zainteresowany? \n" +
                        "1-Tak\n" +
                        "2-Nie");
                opcja = odczyt.nextInt();
                if (opcja == 1) {
                    System.out.println("Wybrano lot na skrzydle.");
                    wybrany_lot.cena = (int) (wybrany_lot.cena * 0.50);
                }

            }
        }



        //Informacje o opłatach
        int oplaty = 50;
        System.out.println("Informacje o Opłatach \n" +
                "Opłata serwisowa wynosi 50zł \n" +
                "Opłata z bagaż wynosi 120zł za kolejne 10kg\n" +
                "Ile kilogramów bagażu zamierzasz zabrać?");
        opcja = odczyt.nextInt();
        if (opcja > 10) {
            oplaty = oplaty + 120 * ((int) Math.ceil(((double) opcja / 10)) - 1);
        }
        System.out.println("Chcesz zarezerować posiłek na pokładzie? 40 zł za posiłek \n" +
                "Jeteś zainteresowany? \n" +
                "1-Tak\n" +
                "2-Nie");
        opcja = odczyt.nextInt();
        if (opcja == 1) {
            System.out.println("ile chcesz zarezerowować posiłków?");
            opcja = odczyt.nextInt();
            oplaty = oplaty + 40 * opcja;
        }
        System.out.println("Czy chcesz mieć pierwszeństwo przy wsiadaniu? \n" +
                "25 zł dla klasy biznesowej i 15 dla ekonomicznej\n" +
                "Jeteś zainteresowany? \n" +
                "1-Tak\n" +
                "2-Nie");
        opcja = odczyt.nextInt();
        if (opcja == 1) {
            if (wybrany_lot.klasa == true) {
                oplaty = oplaty + 25;
            } else {
                oplaty = oplaty + 15;
            }
        }

        //Potwierdzenie reze

        FileWriter fileWriter=null;
        String filepath="C:\\Users\\Dominik\\Desktop\\Lot.txt.txt";
        System.out.println("TEST");

        Random random=new Random();

        int losowa=random.nextInt(900000)+100000;


        wybrany_lot.cena=wybrany_lot.cena+oplaty;
try {
    fileWriter = new FileWriter(filepath);
    fileWriter.write("********************************************** \n"+
            "Indentyfikator Rezerwacji: "+wybrany_lot.symbol_wylotu+wybrany_lot.symbol_przylotu+losowa+"\n"+
            "Miejsce wylotu: "+wybrany_lot.miejsce_wylotu+" "+wybrany_lot.symbol_wylotu+"\n" +
            "Miejsce przylotu: "+wybrany_lot.miejsce_przylotu+" "+wybrany_lot.symbol_przylotu+"\n" +
            "Data wylotu: "+wybrany_lot.data_wylotu+"\n" +
            "Data powrotu: "+wybrany_lot.data_powrotu+"\n" +
            "Cena: "+wybrany_lot.cena+" PLN\n"+
            "**********************************************");

    System.out.println("tu dochodzi");
}
finally {
    if(fileWriter!=null)  fileWriter.close();
    System.out.println("KONIEC");
}


    }




}


