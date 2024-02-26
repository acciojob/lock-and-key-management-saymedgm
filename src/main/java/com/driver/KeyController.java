package com.driver;

import java.util.Scanner;

public class KeyController {
    private KeyService keyService;

    public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addKey(scanner);
                    break;
                case 2:
                    getKeyDetails(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Key");
        System.out.println("2. Get Key Details");
        System.out.println("3. Exit");
    }

    private void addKey(Scanner scanner) {
        System.out.println("Enter Key ID:");
        int id = scanner.nextInt();

        System.out.println("Enter Key Type:");
        scanner.nextLine(); // Consume the newline character
        String type = scanner.nextLine();

        System.out.println("Enter Key Description:");
        String description = scanner.nextLine();

        keyService.addKey(id, type, description);
    }

    private void getKeyDetails(Scanner scanner) {
        System.out.println("Enter Key ID:");
        int id = scanner.nextInt();

        Key key = keyService.getKeyById(id);

        if (key != null) {
            System.out.println("Key Details:");
            System.out.println("ID: " + key.getId());
            System.out.println("Type: " + key.getType());
            System.out.println("Description: " + key.getDescription());
        } else {
            System.out.println("Key not found with ID: " + id);
        }
    }
}