package ru.ashigin;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @Test
    public void whenInputStringWhenReturnLowerCaseStringWithNoSpaces() {
        ByteArrayInputStream in = new ByteArrayInputStream("Иванов И.И.".getBytes());
        String result = phoneBook.enterUser(in);
        String expect = "иванови.и.";
        assertThat(result, is(expect));
    }

    @Test
    public void whenInputCorrectUserThenReturnListOfPhone() {
        ByteArrayInputStream in = new ByteArrayInputStream("Иванов И.И.".getBytes());
        String inputUser = phoneBook.enterUser(in);
        List<String> expect = new ArrayList<>(Arrays.asList("+8 800 2000 500", "+8 800 2000 600"));
        List<String> result = phoneBook.getListOfPhone(inputUser);
        assertThat(result, is(expect));
    }

    @Test(expected = NullPointerException.class)
    public void whenInputIncorrectUserThenReturnNull() {
        ByteArrayInputStream in = new ByteArrayInputStream("И".getBytes());
        String inputUser = phoneBook.enterUser(in);
        List<String> result = phoneBook.getListOfPhone(inputUser);
        assertThat(result, null);
    }

    @Test
    public void whenInputCorrectUserThenShowNumberedListOfPhone() {
        ByteArrayInputStream in = new ByteArrayInputStream("Иванов И.И.".getBytes());
        String inputUser = phoneBook.enterUser(in);
        List<String> listOfPhone = phoneBook.getListOfPhone(inputUser);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        phoneBook.showPhoneNumbers(listOfPhone, new PrintStream(out));

        String result = out.toString();
        String expect = "1. +8 800 2000 500\n2. +8 800 2000 600\n";
        assertThat(result, is(expect));
    }

    @Test
    public void whenInputIncorrectUserThenShowAlert() {
        ByteArrayInputStream in = new ByteArrayInputStream("тест".getBytes());
        String inputUser = phoneBook.enterUser(in);
        List<String> listOfPhone = phoneBook.getListOfPhone(inputUser);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        phoneBook.showPhoneNumbers(listOfPhone, new PrintStream(out));

        String result = out.toString();
        String expect = "There is no such user in the database!";
        assertThat(result, is(expect));
    }
}