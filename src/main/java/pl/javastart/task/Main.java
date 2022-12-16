package pl.javastart.task;

import pl.javastart.task.phoneconcrats.AboPhoneConcract;
import pl.javastart.task.phoneconcrats.CardPhoneConcract;
import pl.javastart.task.phoneconcrats.MixPhoneConcract;

public class Main {

    public static void main(String[] args) {
        CardPhoneConcract cardPhoneConcract = new CardPhoneConcract(0.2, 0.1, 0.2, 0.5);
        AboPhoneConcract aboPhoneConcract = new AboPhoneConcract(25);
        MixPhoneConcract mixPhoneConcract = new MixPhoneConcract(0.2, 0.1, 0.2, 0.5, 2, 2, 1);
        Phone phone1 = new Phone(mixPhoneConcract);

        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.sendSms();
        phone1.printAccountState();
        phone1.call(10);
        phone1.printAccountState();
        phone1.call(80);
        phone1.printAccountState();
        phone1.call(50);
        phone1.printAccountState();
    }
}
