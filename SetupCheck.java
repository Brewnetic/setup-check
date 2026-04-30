// SetupCheck.java
// Verifies that VS Code can compile and run Java code.

public class SetupCheck {

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("VS Code Java setup is working.");
        System.out.println("Sample sum: " + add(2, 3));
    }
}