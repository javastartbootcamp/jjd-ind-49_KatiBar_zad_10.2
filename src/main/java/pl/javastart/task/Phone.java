package pl.javastart.task;

import pl.javastart.task.phoneConcrats.PhoneConcract;

public class Phone {
    PhoneConcract phoneConcract;

    public Phone(PhoneConcract phoneConcract) {
        this.phoneConcract = phoneConcract;
    }

    public void sendSms() {
        phoneConcract.sendSms2();
    }

    public void call(int seconds) {
        phoneConcract.call2(seconds);
    }

    public void sendMms() {
        phoneConcract.sendMms2();
    }

    public void printAccountState() {
        phoneConcract.printAccountState2();
    }
}
