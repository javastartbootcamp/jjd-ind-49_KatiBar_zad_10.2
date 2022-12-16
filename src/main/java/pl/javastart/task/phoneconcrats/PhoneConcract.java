package pl.javastart.task.phoneconcrats;

public abstract class PhoneConcract {
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int EMPTY_ACCOUNT = 0;
    public static final int ZERO = 0;
    public static final int ADD_ONE = 1;
    private double accountBalance;
    private double smsPrice;
    private double mmsPrice;
    private double minutePrice;
    private int smsCount = 0;
    private int mmsCount = 0;
    private int secondsCount = 0;

    public PhoneConcract() {
    }

    public PhoneConcract(double accountBalance, double smsPrice, double mmsPrice, double minutePrice) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.minutePrice = minutePrice;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public double getMmsPrice() {
        return mmsPrice;
    }

    public double getMinutePrice() {
        return minutePrice;
    }

    public int getSmsCount() {
        return smsCount;
    }

    void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public int getMmsCount() {
        return mmsCount;
    }

    void setMmsCount(int mmsCount) {
        this.mmsCount = mmsCount;
    }

    public int getSecondsCount() {
        return secondsCount;
    }

    void setSecondsCount(int secondsCount) {
        this.secondsCount = secondsCount;
    }

    public abstract void sendSms2();

    public abstract void sendMms2();

    public abstract void call2(int seconds);

    public abstract void printAccountState2();
}
