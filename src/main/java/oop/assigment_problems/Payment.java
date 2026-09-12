package oop.assigment_problems;

public class Payment {

    void pay(double amount) {
        System.out.println("Amount paid: " + amount);
    }

    double processTransaction(Payment payment, double amount) {

        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            return cardPayment.payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
            return amount;
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
                new CardPayment(),
                new Payment(),
                new CardPayment(),
                new Payment(),
                new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {
            totalCollected += payments[i].processTransaction(
                    payments[i], amounts[i]
            );
        }

        System.out.println("Total collected: " + totalCollected);
    }
}

class CardPayment extends Payment {

    double payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);
        System.out.println("Total charged: " + total);
        return total;
    }
}