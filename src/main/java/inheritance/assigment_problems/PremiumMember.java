package inheritance.assignment_problems;

public class PremiumMember extends GymMember {

    protected String trainerName;

    public PremiumMember(
            String memberId,
            int monthlyFee,
            String trainerName) {

        super(memberId, monthlyFee);

        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Premium Member | Trainer: "
                        + trainerName
                        + " | Sessions: "
                        + sessionsAttended
        );
    }

    @Override
    protected void chargeLateFee(int amount) {

        super.chargeLateFee(amount / 2);
    }
}