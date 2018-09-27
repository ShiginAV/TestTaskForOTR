package ru.ashigin;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    private Map<String, List> phoneBook = new HashMap<>();

    public PhoneBook() {
        setDataToPhoneBook();
    }

    public void showPhoneNumbers(List<String> listOfPhone, PrintStream out) {
        if (listOfPhone == null || listOfPhone.isEmpty()) {
            out.print("There is no such user in the database!");
        } else {
            int index = 1;
            for (String phone : listOfPhone) {
                out.printf("%s. %s\n", index++, phone);
            }
        }
    }

    private void setDataToPhoneBook() {
        phoneBook.put("Иванов И.И.", new ArrayList<>(Arrays.asList("+8 800 2000 500", "+8 800 2000 600")));
        phoneBook.put("Петров П.П.", new ArrayList<>(Arrays.asList("+8 800 2000 700")));
        phoneBook.put("Сидоров С.С.", new ArrayList<>(Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000")));
        phoneBook.put("Михайлов М.М.", new ArrayList<>());
    }

    public List<String> getListOfPhone(String user) {
        for (String key : phoneBook.keySet()) {
            if (key.replace(" ", "").toLowerCase().equals(user)) {
                return phoneBook.get(key);
            }
        }
        return null;
    }

    public String enterUser(InputStream in) {
        Scanner keyboard = new Scanner(in);
        System.out.println("Enter user: ");
        return keyboard.nextLine().replace(" ", "").toLowerCase();
    }
}
