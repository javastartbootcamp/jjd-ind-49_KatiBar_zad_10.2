package pl.javastart.task.phoneconcrats;

public class AboPhoneContract extends PhoneContract {
    private double price;

    public AboPhoneContract(double price) {
        this.price = price;
    }

    @Override
    public boolean sendSms() {
        smsCount++;
        return true;
    }

    @Override
    public boolean sendMms() {
        mmsCount++;
        return true;
    }

    @Override
    public int call(int seconds) {
        secondsCount += seconds;
        return seconds;
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.printf("Konto z abonamentem bez limitów, o rachunku: %.2f zł\n\n", price);
    }
}
