package interfaces;

public class CreditCard implements Payable, Refundable {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void refund(int amount) {
        System.out.println("The sum is refunded and amounts to: " + amount);
    }

    @Override
    public String getMethod() {
        return "Credit card";
    }

    public void pay(String cardName, int amount) {
        if (Payable.isValid(amount)) System.out.println(cardName + ": " + amount);
    }
}
