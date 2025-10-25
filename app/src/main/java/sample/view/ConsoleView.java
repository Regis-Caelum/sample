package sample.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int showOptions(List<String> list) {
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(String.format("%2d. %s", i + 1, list.get(i)));
            }

            int choice = getInt("Enter your option");

            if (choice >= 1 && choice <= list.size()) {
                return choice;
            }

            System.out.printf("\nInvalid option. Please enter a number between 1 and %d.%n\n", list.size());
        }
    }

    public String getString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal, try again.");
            }
        }
    }
}
