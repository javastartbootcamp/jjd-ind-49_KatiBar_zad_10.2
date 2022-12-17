package pl.javastart.task.phoneconcrats;

import java.io.DataOutput;

public class MixPhoneContract extends CardPhoneContract {
    private int freeSmsAmount;
    private int freeMmsAmount;
    private double freeMinutesAmount;

    public MixPhoneContract(double accountBalance, double smsPrice, double mmsPrice, double minutePrice,
                            int freeSmsAmount, int freeMmsAmount, int freeMinutesAmount) {
        super(accountBalance, smsPrice, mmsPrice, minutePrice);
        this.freeSmsAmount = freeSmsAmount;
        this.freeMmsAmount = freeMmsAmount;
        this.freeMinutesAmount = freeMinutesAmount;
    }

    @Override
    public boolean sendMms() {
        if (freeMmsAmount > 0) {
            freeMmsAmount--;
            mmsCount++;
            return true;
        } else {
            return super.sendMms();
        }
    }

    @Override
    public boolean sendSms() {
        if (freeSmsAmount > 0) {
            freeSmsAmount--;
            smsCount++;
            return true;
        } else {
            return super.sendSms();
        }
    }

    @Override
    public int call(int seconds) {
        double minutes = (double) seconds / SECONDS_IN_MINUTE;
        double lastMinutesToPay = minutes - freeMinutesAmount;
        double lastSecondsToPay = lastMinutesToPay * SECONDS_IN_MINUTE;
        double lastCallPrice = lastMinutesToPay * minutePrice;
        boolean allFromFreeMinutes = freeMinutesAmount >= minutes;
        boolean isWholeCallPossible = allFromFreeMinutes || accountBalance >= lastCallPrice;

        if (isWholeCallPossible) {
            return makeWholeCall(seconds, minutes, lastCallPrice, allFromFreeMinutes);
        } else {
            double freeSecondsAmount = freeMinutesAmount * SECONDS_IN_MINUTE;
            int resultSeconds = super.call((int) lastSecondsToPay) + (int) freeSecondsAmount;
            freeMinutesAmount = ZERO;
            accountBalance = EMPTY_ACCOUNT;
            secondsCount += resultSeconds;
            return resultSeconds;
        }
    }

    private int makeWholeCall(int seconds, double minutes, double lastCallPrice, boolean allFromFreeMinutes) {
        if (allFromFreeMinutes) {
            freeMinutesAmount -= minutes;
        } else {
            freeMinutesAmount = ZERO;
            accountBalance -= lastCallPrice;
        }
        secondsCount += seconds;
        return seconds;
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Do dyspozycji zostało: " + freeSmsAmount + " darmowych SMSów");
        System.out.println("Do dyspozycji zostało: " + freeMmsAmount + " darmowych MMSów");
        System.out.printf("Do dyspozycji zostało: %.2f darmowych minut\n\n", freeMinutesAmount);
    }
}
