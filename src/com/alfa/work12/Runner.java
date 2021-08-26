package com.alfa.work12;

public class Runner {
    public void run(){
        MyPhoneBook phoneBook = new MyPhoneBook();
        fillPhoneBook(phoneBook);
        printDivider();
        System.out.println("Телефонная книга:");
        System.out.println(phoneBook.printPhoneBook());
        printDivider();
        System.out.println("Сортировка по имени:");
        System.out.println(phoneBook.sortByName());
        printDivider();
        System.out.println("Сортировка по номеру телефона:");
        System.out.println(phoneBook.sortByPhoneNumber());

    }

    public void fillPhoneBook (MyPhoneBook phoneBook) {
        tryToAddPhone(phoneBook, "Света", "0965474552");
        tryToAddPhone(phoneBook, "Олег", "0507458263");
        tryToAddPhone(phoneBook, "Игорь", "0509524585");
        tryToAddPhone(phoneBook, "Оля", "0992584565");
        tryToAddPhone(phoneBook, "Иван", "0693571598");
    }

    public void tryToAddPhone (MyPhoneBook phoneBook, String name, String phone) {
        boolean result = phoneBook.addPhoneNumber(name, phone);
        if (result) {
            System.out.println("Контакт успешно добавлен.");
        } else  {
            System.out.println("Книжка переполнена! Контакт не добавлен.");
        }
    }

    public void printDivider () {
        System.out.println("----------------------");
    }
}
