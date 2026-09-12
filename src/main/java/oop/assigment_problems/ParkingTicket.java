package oop.assigment_problems;

public class ParkingTicket {

    String vehicleNo;
    double ratePerMinute;

    ParkingTicket(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    final void printReceipt(int overstayMinutes) {
        double fine = calculateFine(overstayMinutes);
        System.out.println(vehicleNo + " fine " + (int) fine);
    }

    public static void main(String[] args) {

        String[] vehicleNos = {
                "TN09AB1234",
                "TN22CD5678",
                "TN09EF9012",
                "TN10GH3456"
        };

        double[] rates = {5, 4, 6, 4};
        int[] minutes = {6, 0, 0, 4};

        for (int i = 0; i < vehicleNos.length; i++) {

            ParkingTicket ticket =
                    new ParkingTicket(vehicleNos[i], rates[i]);

            if (minutes[i] > 0) {
                ticket.printReceipt(minutes[i]);
            } else {
                System.out.println(vehicleNos[i] + " no fine");
            }
        }
    }
}