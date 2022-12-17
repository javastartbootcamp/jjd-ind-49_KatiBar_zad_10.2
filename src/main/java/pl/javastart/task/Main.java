package pl.javastart.task;

import pl.javastart.task.phoneconcrats.AboPhoneContract;
import pl.javastart.task.phoneconcrats.CardPhoneContract;
import pl.javastart.task.phoneconcrats.MixPhoneContract;

public class Main {

    public static void main(String[] args) {
        CardPhoneContract cardPhoneContract = new CardPhoneContract(0.5, 0.1, 0.2, 0.5);
        AboPhoneContract aboPhoneContract = new AboPhoneContract(25);
        MixPhoneContract mixPhoneContract = new MixPhoneContract(0.1, 0.1, 0.2, 0.5, 2, 2, 1);
        Phone phone1 = new Phone(mixPhoneContract);

        phone1.printAccountState();
        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.call(10);
        phone1.printAccountState();
        phone1.call(10);
        phone1.printAccountState();
        phone1.call(68);
        phone1.printAccountState();
    }
}
