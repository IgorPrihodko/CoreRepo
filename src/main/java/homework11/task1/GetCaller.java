package homework11.task1;

public class GetCaller {

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        StackTraceElement element;
        String className;
        String methodName;
        String message;
        if (stackTraceElements.length < 3) {
            return null;
        } else {
            element = stackTraceElements[2];
            className = element.getClassName();
            methodName = element.getMethodName();
            message = className + "#" + methodName;
        }
        return message;
    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod2();
    }

    private static void anotherMethod2() {
        System.out.println(getCallerClassAndMethodName());
    }
}

