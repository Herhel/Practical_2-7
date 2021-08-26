package com.alfa.work3;

import java.util.Arrays;
import java.util.Comparator;

public class MyPhone {
    private MyPhoneBook phoneBook;
    private Camera camera;
    private Bluetooth bluetooth;
    private MemoryCard memoryCard;
    private SimCard simCard;
    private PowerOnButton powerOnButton;
    private HeadPhones headPhones;
    private PhoneBattery phoneBattery;
    private PhoneCharger phoneCharger;
    private PhoneDisplay phoneDisplay;
    private PhoneSpeaker phoneSpeaker;

    public MyPhone() {
        phoneBook = new MyPhoneBook();
        camera = new Camera();
        bluetooth = new Bluetooth();
        powerOnButton = new PowerOnButton();
        phoneBattery = new PhoneBattery();
        phoneDisplay = new PhoneDisplay();
        phoneSpeaker = new PhoneSpeaker();
    }

    public void switchOn() {
        System.out.println("Loading PhoneBook records…");
        System.out.println(phoneBook.printPhoneBook());
        System.out.println("Loading is complete");
    }

    public void call(int quickLink) {
        if (quickLink < 0 || quickLink > phoneBook.counter) {
            System.out.println("Неверный код быстрого вызова");
            return;
        }
        System.out.println("Calling to " + phoneBook.getRecordToString(quickLink));
    }

    public void loadToPhoneBook(String name, String phone) {
        boolean result = phoneBook.addPhoneNumber(name, phone);
        if (!result) {
            System.out.println("Книжка переполнена! Контакт не добавлен.");
        }
    }

    class MyPhoneBook {
        private PhoneRecord[] phoneNumbers;
        private int counter = 0;

        public MyPhoneBook() {
            phoneNumbers = new PhoneRecord[10];
        }

        public boolean addPhoneNumber(String name, String phone) {
            if (counter == phoneNumbers.length) return false;
            phoneNumbers[counter] = new PhoneRecord(name, phone);
            counter++;
            return true;
        }

        public String printPhoneBook() {
            if (counter == 0) {
                return "No records!";
            }
            return convertRecordsToString(Arrays.copyOf(phoneNumbers, counter));
        }

        private String convertRecordsToString(PhoneRecord[] records) {
            StringBuilder temp = new StringBuilder();
            for (PhoneRecord element : records) {
                temp.append(element + "\n");
            }
            return temp.toString();
        }

        private String getRecordToString(int quickLink) {
            return phoneNumbers[quickLink].toString();
        }

        public String sortByName() {
            PhoneRecord[] temp = Arrays.copyOf(phoneNumbers, counter);
            Arrays.sort(temp, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    String name1 = ((PhoneRecord) o1).name;
                    String name2 = ((PhoneRecord) o2).name;
                    return name1.compareTo(name2);
                }
            });
            return convertRecordsToString(temp);
        }

        public String sortByPhoneNumber() {
            PhoneRecord[] temp = Arrays.copyOf(phoneNumbers, counter);
            Arrays.sort(temp, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    String phone1 = ((PhoneRecord) o1).phone;
                    String phone2 = ((PhoneRecord) o2).phone;
                    return phone1.compareTo(phone2);
                }
            });
            return convertRecordsToString(temp);


        }

        class PhoneRecord {
            private String name;
            private String phone;

            public PhoneRecord(String name, String phone) {
                this.name = name;
                this.phone = phone;
            }

            public String getName() {
                return name;
            }

            public String getPhone() {
                return phone;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            @Override
            public String toString() {
                return "name=" + name + ", phone=" + phone;
            }
        }

    }

    private class Camera {
    }

    private class Bluetooth {
    }

    private class PowerOnButton {

    }

    private class PhoneBattery {

    }

    private class PhoneDisplay {

    }

    private class PhoneSpeaker {

    }
}
