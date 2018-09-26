package ru.ashigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private Map<String, List> phoneBook;

    public PhoneBook() {
        if (phoneBook == null) {
            phoneBook = new HashMap<>();
            setDataToPhoneBook();
        }
    }

    public void showPhoneNumbers() {
        List<String> listOfPhone = getListOfPhone();

        if (listOfPhone == null || listOfPhone.isEmpty()) {
            System.out.println("There is no such user in the database!");
        } else {
            int index = 1;
            for (String phone : listOfPhone) {
                System.out.printf("%s. %s\n", index++, phone);
            }
        }
    }

    private void setDataToPhoneBook() {
        phoneBook.put("Иванов И.И.", new ArrayList<>(Arrays.asList("+8 800 2000 500", "+8 800 2000 600")));
        phoneBook.put("Петров П.П.", new ArrayList<>(Arrays.asList("+8 800 2000 700")));
        phoneBook.put("Сидоров С.С.", new ArrayList<>(Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000")));
        phoneBook.put("Михайлов М.М.", new ArrayList<>());
    }

    private List<String> getListOfPhone() {
        String user = enterUser();

        for (String key : phoneBook.keySet()) {
            if (key.replace(" ", "").toLowerCase().equals(user)) {
                return phoneBook.get(key);
            }
        }
        return null;
    }

    private String enterUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter user: ");
        return in.nextLine().replace(" ", "").toLowerCase();
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.showPhoneNumbers();
    }
}
