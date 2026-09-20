package assignment_problem;
import java.util.Scanner;
import java.util.Arrays;
public class The_Premium_Loyalty_Discount {
    class GymMemberWithLedger {
        protected String memberId;
        protected int monthlyFee;
        private int[] lateFeeHistory;
        private int feeCount;

        public GymMemberWithLedger(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.lateFeeHistory = new int[10];
            this.feeCount = 0;
        }

        protected void chargeLateFee(int amount) {
            if (feeCount < lateFeeHistory.length) {
                lateFeeHistory[feeCount++] = amount;
            }
        }

        public int[] getLateFeeHistory() {
            return Arrays.copyOf(lateFeeHistory, feeCount);
        }

        public int getTotalLateFees() {
            int sum = 0;
            for (int i = 0; i < feeCount; i++) {
                sum += lateFeeHistory[i];
            }
            return sum;
        }
    }

    class PremiumMemberWithLedger extends GymMemberWithLedger {
        private String trainerName;

        public PremiumMemberWithLedger(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }

    public class LateFeeLedgerDemo {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String id = scanner.nextLine().trim();
            int fee = Integer.parseInt(scanner.nextLine().trim());
            String trainer = scanner.nextLine().trim();

            PremiumMemberWithLedger member = new PremiumMemberWithLedger(id, fee, trainer);

            int feeChargesCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < feeChargesCount; i++) {
                int amount = Integer.parseInt(scanner.nextLine().trim());
                member.chargeLateFee(amount);
            }

            System.out.println(member.getTotalLateFees());

            int[] history = member.getLateFeeHistory();
            System.out.println(Arrays.toString(history));

            scanner.close();
        }
    }
}
