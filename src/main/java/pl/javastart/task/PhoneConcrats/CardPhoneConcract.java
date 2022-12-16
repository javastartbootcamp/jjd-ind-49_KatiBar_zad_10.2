package pl.javastart.task.PhoneConcrats;

public class CardPhoneConcract extends PhoneConcract {

    public CardPhoneConcract(double accountBalance, double smsPrice, double mmsPrice, double minutePrice) {
        super(accountBalance, smsPrice, mmsPrice, minutePrice);
    }

    @Override
    public void sendMms2() {
        if (getAccountBalance() >= getMmsPrice()) {
            System.out.println("MMS wysłany");
            setMmsCount(getMmsCount() + ADD_ONE);
            setAccountBalance(getAccountBalance() - getMmsPrice());
        } else {
            System.out.println("Nie udało się wysłać MMSa, brak środków na koncie");
        }
    }

    @Override
    public void sendSms2() {
        if (getAccountBalance() >= getSmsPrice()) {
            System.out.println("SMS wysłany");
            setSmsCount(getSmsCount() + ADD_ONE);
            setAccountBalance(getAccountBalance() - getSmsPrice());
        } else {
            System.out.println("Nie udało się wysłać SMSa, brak środków na koncie");
        }
    }

    @Override
    public void call2(int seconds) {
        double minutes = (double) seconds / SECONDS_IN_MINUTE;
        double wholeCallPrice = minutes * getMinutePrice();
        if (getAccountBalance() >= wholeCallPrice) {
            setSecondsCount(seconds);
            setAccountBalance(getAccountBalance() - wholeCallPrice);
            System.out.println("Rozmowa trwała: " + getSecondsCount() + " sekund");
        } else if (getAccountBalance() < wholeCallPrice && getAccountBalance() != 0) {
            double availableMinutes = getAccountBalance() / getMinutePrice();
            double availableSeconds = availableMinutes * SECONDS_IN_MINUTE;
            setSecondsCount((int) availableSeconds);
            setAccountBalance(EMPTY_ACCOUNT);
            System.out.println("Rozmowa trwała: " + getSecondsCount() + " sekund");
        } else {
            setSecondsCount(ZERO);
            System.out.println("Rozmowa nie została przeprowadzona, brak środków na koncie");
        }
    }

    @Override
    public void printAccountState2() {
        System.out.println("\n=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + getSmsCount());
        System.out.println("Wysłanych MMSów: " + getMmsCount());
        System.out.println("Liczba sekund rozmowy: " + getSecondsCount());
        System.out.printf("Na koncie zostało: %.2f zł\n\n", getAccountBalance());
    }
}
