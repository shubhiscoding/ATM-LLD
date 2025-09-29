public class InitState implements IATMState {

    @Override
    public void displayATMState(ATM atm) {
        System.out.println("ATM is in Init State");
        atm.setState(new CardInsertedState());
    }
    
}
