package access.assigment_problems;

public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    public String[] getBookIds() {
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] updatedBookIds = bookIds.clone();
        updatedBookIds[index] = newId;

        return new LoanReceipt(memberId, updatedBookIds);
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }

    public static void main(String[] args) {

        String[] books = {"B101", "B102"};

        LoanReceipt receipt =
                new LoanReceipt("M001", books);

        books[0] = "CHANGED";

        System.out.println(receipt.getBookIds()[0]);

        String[] copiedBooks = receipt.getBookIds();
        copiedBooks[0] = "CHANGED AGAIN";

        System.out.println(receipt.getBookIds()[0]);

        LoanReceipt corrected =
                receipt.withCorrectedBookId(1, "B999");

        System.out.println(receipt.getBookIds()[1]);
        System.out.println(corrected.getBookIds()[1]);

        LoanReceipt[] receipts = {
                new ReferenceOnlyLoanReceipt(
                        "M002",
                        new String[]{"R101"},
                        "ROOM-1"
                ),
                null,
                new LoanReceipt(
                        "M003",
                        new String[]{"B201"}
                )
        };

        System.out.println(
                processNightlyCirculation(receipts)
        );
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}