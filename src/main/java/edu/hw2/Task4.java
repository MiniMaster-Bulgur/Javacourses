package edu.hw2;

public class Task4 {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement caller = new Throwable().getStackTrace()[1];
        return new CallingInfo(caller.getClassName(), caller.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
