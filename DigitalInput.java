import java.util.Scanner;

public class DigitalInput implements IInput {
    Scanner scanner = new Scanner(System.in);
    @Override
    public String readInput() {
        return scanner.nextLine();
    }

    @Override
    public int readIntInput() {
        return scanner.nextInt();
    }
}
