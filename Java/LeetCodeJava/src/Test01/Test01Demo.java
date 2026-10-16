package Test01;

public class Test01Demo {
    public static void main(String[] args) {
        System.out.println(getValue());
    }

    public static int getValue() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
}
