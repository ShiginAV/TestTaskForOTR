package ru.ashigin;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TaskTest {
    @Test
    public void test() {
        Task task = new Task();
        String expect = "Hello";
        String result = task.returnHello();
        assertThat(result, is(expect));
    }
}
