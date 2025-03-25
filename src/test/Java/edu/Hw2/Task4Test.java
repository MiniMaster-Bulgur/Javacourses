package edu.Hw2;

import edu.hw2.Task4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

        @Test
        public void testCallingInfo() {
            Task4.CallingInfo info = Task4.callingInfo();
            assertEquals("Task4Test", info.className());
            assertEquals("testCallingInfo", info.methodName());
        }

        @Test
        public void testCallingInfoFromAnotherMethod() {
            Task4.CallingInfo info = callCallingInfo();
            assertEquals("Task4Test", info.className());
            assertEquals("callCallingInfo", info.methodName());
        }

        private Task4.CallingInfo callCallingInfo() {
            return Task4.callingInfo();
        }
}

