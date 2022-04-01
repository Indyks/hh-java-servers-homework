package counter;

public class Counter {

    static private int counter = 0;

    public static int get() {
        return counter;
    }

    public static void increment() {
        counter++;
    }

    public static void decrease(int value) {
        counter -= value;
    }

    public static void clear() {
        counter = 0;
    }
}
