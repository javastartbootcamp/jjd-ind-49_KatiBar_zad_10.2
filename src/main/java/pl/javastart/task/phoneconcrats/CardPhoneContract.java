package pl.javastart.task.phoneconcrats;

import java.util.stream.StreamSupport;

public class CardPhoneContract extends PhoneContract {

    public CardPhoneContract(double accountBalance, double smsPrice, double mmsPrice, double minutePrice) {
        super(accountBalance, smsPrice, mmsPrice, minutePrice);
    }

    @Override
    public boolean sendMms() {
        if (accountBalance >= mmsPrice) {
            mmsCount++;
            accountBalance -= mmsPrice;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sendSms() {
        if (accountBalance >= smsPrice) {
            smsCount++;
            accountBalance -= smsPrice;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int call(int seconds) {
        double minutes = (double) seconds / SECONDS_IN_MINUTE;
        double wholeCallPrice = minutes * minutePrice;
        if (accountBalance == 0) {
            return 0;
        } else if (accountBalance >= wholeCallPrice) {
            secondsCount += seconds;
            accountBalance -= wholeCallPrice;
            return seconds;
        } else {
            double availableMinutes = accountBalance / minutePrice;
            double availableSeconds = availableMinutes * SECONDS_IN_MINUTE;
            secondsCount += availableSeconds;
            accountBalance = EMPTY_ACCOUNT;
            return (int) availableSeconds;
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.printf("Na koncie zostało: %.2f zł\n\n", accountBalance);
    }
}
