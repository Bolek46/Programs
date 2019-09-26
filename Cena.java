public class Cena {
    private String dzien_tygodnia;
    private String data_wylotu;
    private String biezaca_data;
    private int cena_bazowa;
    private int ilosc_miejsc;

    public Cena(String dzien_tygodnia, String data_wylotu, String biezaca_data, int ilosc_miejsc) {
        this.dzien_tygodnia = dzien_tygodnia;
        this.data_wylotu = data_wylotu;
        this.biezaca_data = biezaca_data;
        this.ilosc_miejsc = ilosc_miejsc;
    }
    public Cena() {
        this.dzien_tygodnia = dzien_tygodnia;
        this.data_wylotu = data_wylotu;
        this.biezaca_data = biezaca_data;
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public int cena(int cena_bazowa,int ilosc_miejsc,String data_wylotu)
    {
        int cena=cena_bazowa;
        if(dzien_tygodnia=="Niedziela") cena=cena+(int)(0.1*cena_bazowa);
/*        if(data_wylotu-biezaca_data>30) cena=cena-0.1*cena_bazowa;
        else
        if(data_wylotu-biezaca_data<7) cena=cena+0.2*cena_bazowa;*/

        if(ilosc_miejsc<20) cena=cena+(int)(0.25*cena_bazowa);
        else
        if(ilosc_miejsc<50) cena=cena+(int)(0.1*cena_bazowa);

        return cena;
    }

    public String getDzien_tygodnia() {
        return dzien_tygodnia;
    }

    public void setDzien_tygodnia(String dzien_tygodnia) {
        this.dzien_tygodnia = dzien_tygodnia;
    }

    public String getData_wylotu() {
        return data_wylotu;
    }

    public void setData_wylotu(String data_wylotu) {
        this.data_wylotu = data_wylotu;
    }

    public String getBiezaca_data() {
        return biezaca_data;
    }

    public void setBiezaca_data(String biezaca_data) {
        this.biezaca_data = biezaca_data;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    @Override
    public String toString() {
        return "Cena{" +
                "dzien_tygodnia='" + dzien_tygodnia + '\'' +
                ", data_wylotu='" + data_wylotu + '\'' +
                ", biezaca_data='" + biezaca_data + '\'' +
                ", ilosc_miejsc=" + ilosc_miejsc +
                '}';
    }
}
