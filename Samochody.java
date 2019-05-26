import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    { ArrayList<String> lista_nazwisko=new ArrayList<String>();
      ArrayList<String> lista_numer=new ArrayList<String>();
      Pojazd pojazd = new Pojazd("Wisniewski","BR648377");
      Pojazd pojazd2 = new Pojazd("Kaminski","GA454454");
      Pojazd pojazd3 = new Pojazd("Lechowicz","WA776532");
        lista_nazwisko.add(0,pojazd.nazwisko);
        lista_numer.add(0,pojazd.numer_rejestracyjny);
        lista_nazwisko.add(1,pojazd2.nazwisko);
        lista_numer.add(1,pojazd2.numer_rejestracyjny);
        lista_nazwisko.add(2,pojazd3.nazwisko);
        lista_numer.add(2,pojazd3.numer_rejestracyjny);
        Scanner ObiektPrzycisk = new Scanner(System.in);
        int opcja;
        //menu
        do
        {
            int licznik=0;
            System.out.println("\n-------- MENU --------------------------");
            System.out.println("1 - Pokaż wszystkie pojazdy");
            System.out.println("2 - Dodaj nowy pojazd");
            System.out.println("3 - Usuń pojazd");
            System.out.println("4 - Zmień dane wybranego pojazdu");
            System.out.println("5 - Wyjście z programu");
            System.out.println("----------------------------------------");
            System.out.print("Wybierz jedną z opcji: ");
            opcja= ObiektPrzycisk.nextInt();
            switch (opcja)
            {
                case 1:
                { System.out.println("\nWSZYSTKIE WPISY:");
                    for (int i=0;i<lista_nazwisko.size();i++)
                    {
                        System.out.print(i+1);
                        System.out.println(" | "+lista_numer.get(i)+" | "+lista_nazwisko.get(i));
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("\nWPROWADŹ WPIS:");

                    Pojazd rekord=new Pojazd();
                    rekord.PodajNazwisko();
                    rekord.PodajNumer();
                    lista_nazwisko.add(licznik,rekord.nazwisko);
                    lista_numer.add(licznik,rekord.numer_rejestracyjny);
                    licznik++;
                    break;
                }
                case 3:
                {
                    System.out.println("\nUSUŃ WPIS:");
                    for (int i=0;i<lista_nazwisko.size();i++)
                    {
                        System.out.print(i+1);
                        System.out.println(" | "+lista_numer.get(i)+" | " +lista_nazwisko.get(i));
                    }
                    System.out.print("Podaj nr wpisu do usunięcia: ");
                    int nr = ObiektPrzycisk.nextInt();
                    if(nr>lista_nazwisko.size() || nr <1) {
                        System.out.println("Nieprawidlowy numer wpisu");
                        break;
                    }
                    else {
                        lista_nazwisko.remove(nr - 1);
                        lista_numer.remove(nr - 1);
                        System.out.println(nr);
                        for (int i = 0; i < lista_nazwisko.size(); i++) {
                            System.out.print(i + 1);
                            System.out.println(" | " + lista_numer.get(i) + " | " + lista_nazwisko.get(i));
                        }
                        break;
                    }


                }
                case 4:
                {
                    System.out.println("\nEDYTUJ WPIS:");
                    for (int i=0;i<lista_nazwisko.size();i++)
                    {
                        System.out.print(i+1);
                        System.out.println(" | "+lista_numer.get(i)+" | " +lista_nazwisko.get(i));
                    }
                    System.out.print("Podaj nr wpisu do edycji: ");
                    int nr = ObiektPrzycisk.nextInt();
                    if(nr>lista_nazwisko.size() || nr <1) {
                        System.out.println("Nieprawidlowy numer wpisu");
                        break;
                    }
                    else {
                        Pojazd rekord=new Pojazd();
                        rekord.PodajNazwisko();
                        rekord.PodajNumer();
                        lista_nazwisko.set(nr,rekord.nazwisko);
                        lista_numer.set(nr,rekord.numer_rejestracyjny);
                        System.out.println(nr);
                        for (int i = 0; i < lista_nazwisko.size(); i++) {
                            System.out.print(i + 1);
                            System.out.println(" | " + lista_numer.get(i) + " | " + lista_nazwisko.get(i));
                        }
                        break;
                    }
                }
                case 5:break;
                default:System.out.println("Nie wybrano właściwej opcji");
            }
        }
        while (opcja!=5);



    }

}
//-------------------------------------------------------------
class Pojazd
{
    public String nazwisko;
    public String numer_rejestracyjny;
    //metody klasy Pojazd
    Pojazd()
    {

    }
    Pojazd(String nazwisko,String numer_rejestracyjny)
    {
        this.nazwisko=nazwisko;
        this.numer_rejestracyjny=numer_rejestracyjny;
    }
    public String PodajNazwisko()
    {
        Scanner ObiektString = new Scanner(System.in);
        System.out.print("Podaj nazwisko właścicieja:");
        String new_naz = ObiektString.next();
        nazwisko=new_naz;
        return nazwisko;
    }
    public String PodajNumer()
    {
        Scanner ObiektString = new Scanner(System.in);
        System.out.print("Podaj numer rejestracyjny:");
        String new_numer = ObiektString.next();
        numer_rejestracyjny=new_numer;
        return numer_rejestracyjny;
    }
}