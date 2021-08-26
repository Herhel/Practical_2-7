package com.alfa.work12;

import java.util.Arrays;

public class MyPhoneBook {
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
