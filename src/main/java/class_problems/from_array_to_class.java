package class_problems;
import java.util.Scanner;
public class from_array_to_class {
    class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public class PlacementRecordManager {
        public static void main(String[] args) {
            PlacementRecord[] records = new PlacementRecord[3];
            records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
            records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
            records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);
            for (PlacementRecord record : records) {
                record.printRecord();
            }
        }
    }
}