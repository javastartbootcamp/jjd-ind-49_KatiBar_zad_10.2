package pl.javastart.task.phoneconcrats;

public abstract class PhoneContract {
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int EMPTY_ACCOUNT = 0;
    public static final int ZERO = 0;
    protected double accountBalance;
    protected double smsPrice;
    protected double mmsPrice;
    protected double minutePrice;
    protected int smsCount = 0;
    protected int mmsCount = 0;
    protected int secondsCount = 0;

    public PhoneContract() {
    }

    public PhoneContract(double accountBalance, double smsPrice, double mmsPrice, double minutePrice) {
        this.accountBalance = accountBalance;
        this.smsPrice = smsPrice;
        this.mmsPrice = mmsPrice;
        this.minutePrice = minutePrice;
    }

    public abstract boolean sendSms();

    public abstract boolean sendMms();

    public abstract int call(int seconds);

    public void printAccountState() {
        System.out.println("\n=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + smsCount);
        System.out.println("Wysłanych MMSów: " + mmsCount);
        System.out.println("Liczba sekund rozmowy: " + secondsCount);
    }
}
