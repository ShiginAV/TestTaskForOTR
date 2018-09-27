package ru.ashigin;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class IpRangeTest {
    @Test
    public void whenInputRangeOfAddressesThenReturnTheirList() {
        IpRange ipRange = new IpRange();
        List<String> result = ipRange.getIpAddressesFromRange("192.168.0.1", "192.168.0.5");
        List<String> expect = new ArrayList<>(Arrays.asList("192.168.0.2", "192.168.0.3", "192.168.0.4"));
        assertThat(result, is(expect));
    }

    @Test
    public void whenInputListOfAddressesThenShowIt() {
        IpRange ipRange = new IpRange();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        List<String> listOfAddresses = ipRange.getIpAddressesFromRange("192.168.0.1", "192.168.0.5");
        ipRange.showIpAddresses(listOfAddresses, new PrintStream(out));
        String result = out.toString();
        String lineSeparator = System.getProperty("line.separator");
        String expect = "192.168.0.2" + lineSeparator + "192.168.0.3" + lineSeparator + "192.168.0.4" + lineSeparator;
        assertThat(result, is(expect));
    }
}