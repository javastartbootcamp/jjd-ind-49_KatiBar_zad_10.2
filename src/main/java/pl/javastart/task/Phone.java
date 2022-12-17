package pl.javastart.task;

import pl.javastart.task.phoneconcrats.PhoneContract;

public class Phone {
    private final PhoneContract phoneContract;

    public Phone(PhoneContract phoneContract) {
        this.phoneContract = phoneContract;
    }

    public void sendSms() {
        boolean success = phoneContract.sendSms();
        if (success) {
            System.out.println("SMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać SMSa, brak środków na koncie");
        }
    }

    public void call(int seconds) {
        int result = phoneContract.call(seconds);

        if (result == 0) {
            System.out.println("Rozmowa nie została przeprowadzona, brak środków na koncie");
        } else {
            System.out.println("Rozmowa trwała: " + result + " sekund");
        }
    }

    public void sendMms() {
        boolean success = phoneContract.sendMms();
        if (success) {
            System.out.println("MMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać MMSa, brak środków na koncie");
        }
    }

    public void printAccountState() {
        phoneContract.printAccountState();
    }
}
