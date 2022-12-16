package pl.javastart.task.phoneConcrats;

public class AboPhoneConcract extends PhoneConcract {
    private double price;

    public AboPhoneConcract(double price) {
        this.price = price;
    }

    @Override
    public void sendSms2() {
        System.out.println("SMS wysłany");
        setSmsCount(getSmsCount() + ADD_ONE);
    }

    @Override
    public void sendMms2() {
        System.out.println("MMS wysłany");
        setMmsCount(getMmsCount() + ADD_ONE);
    }

    @Override
    public void call2(int seconds) {
        setSecondsCount(seconds);
        System.out.println("Rozmowa trwała: " + getSecondsCount() + " sekund");
    }

    @Override
    public void printAccountState2() {
        System.out.println("\n=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + getSmsCount());
        System.out.println("Wysłanych MMSów: " + getMmsCount());
        System.out.println("Liczba sekund rozmowy: " + getSecondsCount());
        System.out.printf("Konto z abonamentem bez limitów, o rachunku: %.2f zł\n\n", price);
    }
}
