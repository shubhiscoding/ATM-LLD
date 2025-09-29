import java.util.Scanner;

public class ATM {
    IATMState currentState;
    Card card;
    CashDispenser cashDispenser;
    IInput inputMethod;

    public ATM(CashDispenser cashDispenser, IInput inputMethod) {
        currentState = new InitState();
        this.card = new Card();
        this.cashDispenser = cashDispenser;
        this.inputMethod = inputMethod;
    }

    public void setState(IATMState state) {
        currentState = state;
    }

    public void displayATMState() {
        Scanner sc = new Scanner(System.in);
        char ch = 'c';
        do{
            if(ch == 'c'){
                currentState.displayATMState(this);
            } else {
                break;
            }
            System.out.println("Press 'c' to continue or any other key to exit:");
            ch = sc.next().charAt(0);
        }while(true);
    }
}
