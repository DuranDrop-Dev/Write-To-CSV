import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String[]> dataLines = new ArrayList<>();

    public static void main(String[] args) {
        userData();
        writeData();
    }

    public static void userData() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        dataLines.add(new String[]{firstName,lastName, String.valueOf(age)});
    }

    public static void writeData() {
        String csvFile = "data.csv";
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            for (String[] rowData : dataLines) {
                for (String rowDatum : rowData) {
                    writer.write(rowDatum);
                    writer.append(',');
                }
                writer.write('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
