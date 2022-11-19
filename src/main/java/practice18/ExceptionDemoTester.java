package practice18;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

interface ExceptionDemo {
    void exceptionDemo() throws Throwable;

    default String[] getInputsToTest() {
        return new String[]{};
    }
}

// Задания

class Exercise1Step1 implements ExceptionDemo {
    @Override
    public void exceptionDemo() {
        System.out.println(2 / 0);
    }
}

class Exercise1Step2 implements ExceptionDemo {
    @Override
    public void exceptionDemo() {
        try {
            System.out.println(2.0 / 0.0); // Исключения нет, потому что IEEE определяет это как Infinity
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }
}

class Exercise2Step1 implements ExceptionDemo {
    @Override
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter an integer ");
        String intString = myScanner.next(); // NumberFormatException для строки Qwerty
        int i = Integer.parseInt(intString); // NumberFormatException для 1.2
        System.out.println(2 / i); // ArithmeticException для 0
    }

    @Override
    public String[] getInputsToTest() {
        return new String[]{"Qwerty 0 1.2 2", "0", "1.2", "2"};
    }
}

class Exercise2Step3 implements ExceptionDemo {
    @Override
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter an integer ");

        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Ожидалось целое число");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }
    }

    @Override
    public String[] getInputsToTest() {
        return new String[]{"Qwerty 0 1.2 2", "0", "1.2", "2"};
    }
}

class Exercise3Step1 implements ExceptionDemo {
    @Override
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter an integer ");

        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Получено исключение");
        } /*catch (NumberFormatException e) {
            System.out.println("Ожидалось целое число");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }*/
    }

    @Override
    public String[] getInputsToTest() {
        return new String[]{"Qwerty 0 1.2 2", "0", "1.2", "2"};
    }
}

class Exercise4Step1 implements ExceptionDemo {
    @Override
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter an integer ");

        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Получено исключение");
        } finally {
            System.out.println("finally выполняется в любом случае");
        }
    }

    @Override
    public String[] getInputsToTest() {
        return new String[]{"Qwerty 0 1.2 2", "0", "1.2", "2"};
    }
}

class Exercise5Step1 implements ExceptionDemo {
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
    }

    @Override
    public void exceptionDemo() {
        getDetails(null);
    }
}

class Exercise5Step2 implements ExceptionDemo {
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
    }

    @Override
    public void exceptionDemo() {
        try {
            getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("Получено исключение " + e);
        }
    }
}

class Exercise6Step1 implements ExceptionDemo {
    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    @Override
    public void exceptionDemo() {
        printMessage("123");
        printMessage(null);
    }
}

class Exercise6Step2 implements ExceptionDemo {
    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("getDetails кинул исключение");
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    @Override
    public void exceptionDemo() {
        printMessage("123");
        printMessage(null);
    }
}

class Exercise7Step1 implements ExceptionDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key = myScanner.next();
        try {
            printDetails(key);
        } catch (Exception e) {
            System.out.println("Получено исключение");
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key == "") {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    @Override
    public void exceptionDemo() {
        getKey();
    }

    @Override
    public String[] getInputsToTest() {
        return new String[] { "Ok", "" };
    }
}

class Exercise8Step1 implements ExceptionDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        while (true) {
            try {
                printDetails(myScanner.next());
                break;
            } catch (Exception e) {
                System.out.println("[Повторите попытку]");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key == "") {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    @Override
    public void exceptionDemo() {
        getKey();
    }

    @Override
    public String[] getInputsToTest() {
        return new String[] { "  \nOk" };
    }
}

// Main
public class ExceptionDemoTester {
    public static void main(String[] args) {
        var demos = new ExceptionDemo[]{
            new Exercise1Step1(),
            new Exercise1Step2(),
            new Exercise2Step1(),
            new Exercise2Step3(),
            new Exercise3Step1(),
            new Exercise4Step1(),
            new Exercise5Step1(),
            new Exercise5Step2(),
            new Exercise6Step1(),
            new Exercise6Step2(),
            new Exercise7Step1(),
            new Exercise8Step1(),
        };

        for (var demo : demos) {
            testDemo(demo);
        }
    }

    private static void testDemo(ExceptionDemo demo) {
        var inputs = demo.getInputsToTest();

        if (inputs.length == 0) {
            testDemoWithInput(demo, null);
        } else {
            for (var input : inputs) {
                testDemoWithInput(demo, input);
            }
        }
    }

    private static void testDemoWithInput(ExceptionDemo demo, String input) {
        System.out.println("* Running " + demo.getClass().getName());

        if (input != null) {
            var inputStream = new ByteArrayInputStream((input + "\n").getBytes());
            System.setIn(inputStream);
            System.out.println("* With input: " + input);
        }

        try {
            demo.exceptionDemo();

            System.out.println("! No exception was caught by " + ExceptionDemoTester.class.getName());
        } catch (Throwable exception) {
            System.out.println("! " + ExceptionDemoTester.class.getName() + " caught an exception:");
            System.out.println(exception);
            var stackTrace = exception.getStackTrace();
            System.out.println(" at " + stackTrace[stackTrace.length - 1]);
            for (int i = stackTrace.length - 2; i >= 0; i--) {
                System.out.println("    " + stackTrace[i]);
            }
        } finally {
            System.out.println();
        }
    }
}
