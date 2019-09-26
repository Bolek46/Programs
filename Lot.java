
public class Lot {

    public String miejsce_wylotu;
    public String symbol_wylotu;
    public String miejsce_przylotu;
    public String symbol_przylotu;
    public int długosc_lotu;
    public int liczba_miejsc;
    public int cena;
    public int cena_bazowa;
    public String data_wylotu;
    public String data_powrotu;
    public boolean klasa; // opisuje typ biletu. true - klasa biznesowa, false - klasa ekonomiczna

    public Lot() {
    }

    public Lot(String miejsce_wylotu, String symbol_wylotu, String miejsce_przylotu, String symbol_przylotu, int długosc_lotu, int liczba_miejsc, int cena, int cena_bazowa, String data_wylotu, String data_powrotu, boolean klasa) {
        this.miejsce_wylotu = miejsce_wylotu;
        this.symbol_wylotu = symbol_wylotu;
        this.miejsce_przylotu = miejsce_przylotu;
        this.symbol_przylotu = symbol_przylotu;
        this.długosc_lotu = długosc_lotu;
        this.liczba_miejsc = liczba_miejsc;
        this.cena = cena;
        this.cena_bazowa = cena_bazowa;
        this.data_wylotu = data_wylotu;
        this.data_powrotu = data_powrotu;
        this.klasa=klasa;
    }

    public String getMiejsce_wylotu() {
        return miejsce_wylotu;
    }

    public void setMiejsce_wylotu(String miejsce_wylotu) {
        this.miejsce_wylotu = miejsce_wylotu;
    }

    public String getSymbol_wylotu() {
        return symbol_wylotu;
    }

    public void setSymbol_wylotu(String symbol_wylotu) {
        this.symbol_wylotu = symbol_wylotu;
    }

    public String getMiejsce_przylotu() {
        return miejsce_przylotu;
    }

    public void setMiejsce_przylotu(String miejsce_przylotu) {
        this.miejsce_przylotu = miejsce_przylotu;
    }

    public String getSymbol_przylotu() {
        return symbol_przylotu;
    }

    public void setSymbol_przylotu(String symbol_przylotu) {
        this.symbol_przylotu = symbol_przylotu;
    }

    public int getDługosc_lotu() {
        return długosc_lotu;
    }

    public void setDługosc_lotu(int długosc_lotu) {
        this.długosc_lotu = długosc_lotu;
    }

    public int getLiczba_miejsc() {
        return liczba_miejsc;
    }

    public void setLiczba_miejsc(int liczba_miejsc) {
        this.liczba_miejsc = liczba_miejsc;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getData_wylotu() {
        return data_wylotu;
    }

    public void setData_wylotu(String data_wylotu) {
        this.data_wylotu = data_wylotu;
    }

    public String getData_powrotu() {
        return data_powrotu;
    }

    public void setData_powrotu(String data_powrotu) {
        this.data_powrotu = data_powrotu;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "miejsce_wylotu='" + miejsce_wylotu + '\'' +
                ", symbol_wylotu='" + symbol_wylotu + '\'' +
                ", miejsce_przylotu='" + miejsce_przylotu + '\'' +
                ", symbol_przylotu='" + symbol_przylotu + '\'' +
                ", długosc_lotu=" + długosc_lotu +
                ", cena=" + cena +
                ", data_wylotu='" + data_wylotu + '\'' +
                ", data_powrotu='" + data_powrotu + '\'' +
                '}';
    }



    public int compareTo3(Lot L){
        float compareCena=((Lot) L).getCena();
        return (int)(compareCena-this.cena);
    }


    public int compareTo1(Lot L){
        return this.miejsce_wylotu.compareTo(L.miejsce_wylotu);
    }

    public int compareTo2(Lot L){
        return this.data_wylotu.compareTo(L.data_wylotu);
    }


}
