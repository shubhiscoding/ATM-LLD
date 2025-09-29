import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> cashInventory = new HashMap<>();
        cashInventory.put(100, 100); // 10 notes of 100
        cashInventory.put(500, 100); // 10 notes of 500
        cashInventory.put(2000, 50); // 5 notes of 2000
        cashInventory.put(10, 200); // 20 notes of 10
        cashInventory.put(20, 200); // 20 notes of 20
        CashDispenser dispenser = new CashDispenser(cashInventory);

        ATM atm = new ATM(dispenser, new DigitalInput());
        atm.displayATMState();
    }
}
