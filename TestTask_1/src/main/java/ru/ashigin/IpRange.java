package ru.ashigin;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class IpRange {
    public List<String> getIpAddressesFromRange(String startOfRange, String endOfRange) {
        List<String> listOfAddresses = new ArrayList<>();

        String[] startParts = startOfRange.split("(?<=\\.)(?!.*\\.)");
        String[] endParts = endOfRange.split("(?<=\\.)(?!.*\\.)");

        int first = Integer.parseInt(startParts[1]);
        int last = Integer.parseInt(endParts[1]);

        for (int i = first + 1; i < last; i++) {
            listOfAddresses.add(startParts[0] + i);
        }
        return listOfAddresses;
    }

    public void showIpAddresses(List<String> listOfAddresses, PrintStream out) {
        for (String address : listOfAddresses) {
            out.println(address);
        }
    }
}
