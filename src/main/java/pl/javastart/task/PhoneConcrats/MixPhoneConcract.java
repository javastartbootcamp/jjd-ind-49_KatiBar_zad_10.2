package pl.javastart.task.PhoneConcrats;

public class MixPhoneConcract extends PhoneConcract {
    private int freeSmsAmount;
    private int freeMmsAmount;
    private double freeMinutesAmount;

    public MixPhoneConcract(double accountBalance, double smsPrice, double mmsPrice, double minutePrice, int freeSmsAmount, int freeMmsAmount, int freeMinutesAmount) {
        super(accountBalance, smsPrice, mmsPrice, minutePrice);
        this.freeSmsAmount = freeSmsAmount;
        this.freeMmsAmount = freeMmsAmount;
        this.freeMinutesAmount = freeMinutesAmount;
    }

    @Override
    public void sendMms2() {
        if (freeMmsAmount > 0) {
            System.out.println("MMS wysłany");
            freeMmsAmount--;
            setMmsCount(getMmsCount() + ADD_ONE);
        } else if (getAccountBalance() >= getMmsPrice()) {
            System.out.println("MMS wysłany");
            setMmsCount(getMmsCount() + ADD_ONE);
            setAccountBalance(getAccountBalance() - getMmsPrice());
        } else {
            System.out.println("Nie udało się wysłać MMSa, brak środków na koncie");
        }
    }

    @Override
    public void sendSms2() {
        if (freeSmsAmount > 0) {
            System.out.println("SMS wysłany");
            freeSmsAmount--;
            setSmsCount(getSmsCount() + ADD_ONE);
        } else if (getAccountBalance() >= getSmsPrice()) {
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
        double lastMinutesToPay = minutes - freeMinutesAmount;
        double lastCallPrice = lastMinutesToPay * getMinutePrice();
        boolean allFromFreeMinutes = freeMinutesAmount >= minutes;
        boolean isWholeCallPossible = allFromFreeMinutes || getAccountBalance() >= lastCallPrice;

        if (isWholeCallPossible) {
            makeWholeCall(seconds, minutes, lastCallPrice, allFromFreeMinutes);
        } else if (getAccountBalance() < lastCallPrice && getAccountBalance() != 0) {
            double availableMinutes = getAccountBalance() / getMinutePrice();
            double availableSeconds = availableMinutes * SECONDS_IN_MINUTE;
            double freeSecondsAmount = freeMinutesAmount * SECONDS_IN_MINUTE;
            freeMinutesAmount = ZERO;
            setSecondsCount((int) availableSeconds + (int) freeSecondsAmount);
            setAccountBalance(EMPTY_ACCOUNT);
            System.out.println("Rozmowa trwała: " + getSecondsCount() + " sekund");
        } else {
            setSecondsCount(ZERO);
            freeMinutesAmount = ZERO;
            System.out.println("Rozmowa nie została przeprowadzona, brak środków na koncie");
        }
    }

    private void makeWholeCall(int seconds, double minutes, double lastCallPrice, boolean allFromFreeMinutes) {
        if (allFromFreeMinutes) {
            freeMinutesAmount -= minutes;
        } else {
            freeMinutesAmount = ZERO;
            setAccountBalance(getAccountBalance() - lastCallPrice);
        }
        System.out.println("Rozmowa trwała: " + seconds + " sekund");
        setSecondsCount(seconds);
    }

    @Override
    public void printAccountState2() {
        System.out.println("\n=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + getSmsCount());
        System.out.println("Wysłanych MMSów: " + getMmsCount());
        System.out.println("Liczba sekund rozmowy: " + getSecondsCount());
        System.out.printf("Na koncie zostało: %.2f zł\n", getAccountBalance());
        System.out.println("Do dyspozycji zostało: " + freeSmsAmount + " darmowych SMSów");
        System.out.println("Do dyspozycji zostało: " + freeMmsAmount + " darmowych MMSów");
        System.out.printf("Do dyspozycji zostało: %.2f darmowych minut\n\n", freeMinutesAmount);
    }
}
