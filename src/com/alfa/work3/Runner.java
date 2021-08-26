package com.alfa.work3;

public class Runner {
    public void run() {
        MyPhone phone = new MyPhone();
        loadRecords(phone);
        phone.switchOn();
        phone.call(2);
    }

    public void loadRecords(MyPhone phone) {
        phone.loadToPhoneBook("Света", "0965474552");
        phone.loadToPhoneBook("Олег", "0507458263");
        phone.loadToPhoneBook("Игорь", "0509524585");
        phone.loadToPhoneBook("Оля", "0992584565");
        phone.loadToPhoneBook("Иван", "0693571598");
        phone.loadToPhoneBook("Володя", "0660124758");
        phone.loadToPhoneBook("Аня", "0673215874");
        phone.loadToPhoneBook("Матвей", "0957452141");
        phone.loadToPhoneBook("Алеша", "0975239657");
        phone.loadToPhoneBook("Маша", "0991234578");
    }
}
