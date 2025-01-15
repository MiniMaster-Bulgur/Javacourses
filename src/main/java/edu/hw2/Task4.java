package edu.hw2;

public class Task4 {

    private Task4() {
    }

    private static final int STACK_TRACE_DEPTH = 3;

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < STACK_TRACE_DEPTH) {
            throw new IllegalStateException();
        }
        StackTraceElement caller = stackTrace[STACK_TRACE_DEPTH - 1];
        return new CallingInfo(caller.getClassName(), caller.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
