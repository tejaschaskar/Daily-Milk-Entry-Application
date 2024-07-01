import java.io.*;
import java.util.Scanner;

// MilkEntry class to store the date, time of day, and quantity of milk
class MilkEntry {
    private String date;
    private String timeOfDay;
    private double quantity;

    public MilkEntry(String date, String timeOfDay, double quantity) {
        this.date = date;
        this.timeOfDay = timeOfDay;
        this.quantity = quantity;

    }

    public String getDate() {
        return date;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {

        return "Date: " + date+ ", Time of Day: " + timeOfDay + ", Quantity: " + quantity;
    }
}

// Main application class
public class MilkEntryApp {
    private static final String FILE_NAME = "milk_entries.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter date (DD-MM-YYYY): ");
            String date = scanner.nextLine();

            // Prompt for morning entry
            System.out.println("Enter morning quantity: ");
            double morningQuantity = Double.parseDouble(scanner.nextLine());
            MilkEntry morningEntry = new MilkEntry(date, "morning", morningQuantity);
            saveEntry(morningEntry);
            System.out.println("Morning entry saved.");

            // Prompt for evening entry
            System.out.println("Enter evening quantity: ");
            double eveningQuantity = Double.parseDouble(scanner.nextLine());
            MilkEntry eveningEntry = new MilkEntry(date, "evening", eveningQuantity);
            saveEntry(eveningEntry);
            System.out.println("Evening entry saved.");

            System.out.println("Do you want to enter another day's entries? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("All entries:");
        displayEntries();
    }

    // Method to save a milk entry to the text file
    private static void saveEntry(MilkEntry entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(entry.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to display all milk entries from the text file
    private static void displayEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
