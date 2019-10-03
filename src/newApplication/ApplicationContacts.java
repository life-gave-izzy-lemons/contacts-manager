package newApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.StandardOpenOption;


public class ApplicationContacts {
    static Input input = new Input();
    static Path p = Paths.get("src", "newApplication", "newContacts.txt");

    public static void main(String[] args) {

        userInter();
    }

    public static void viewContacts() {
        List<String> strList;
        String name = "       Name";
        String num = "Number";
        System.out.printf("%-15s | %s \n", name, num);
        System.out.println("----------------------------");
        try {
            strList = Files.readAllLines(p);
            for (int i = 0; i < strList.size(); i++) {
                System.out.printf((i + 1) + " : " + strList.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addContacts() {
        System.out.println("Enter Contact Name ");
        String name = input.getString();
        System.out.println("Enter Contact Number (no spaces or dashes) ");
        String num = input.getString(7,10);
        Contact newContact = new Contact(name, num);

        try {
            Files.write(
                    p,
                    Arrays.asList(String.format("%-11s | %s", newContact.getName(), newContact.getNumber())), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchContacts(String name) {
        List<String> strList;
        String nameTitle = "       Name";
        String numTitle = "Number";
        System.out.printf("%-15s | %s \n", nameTitle, numTitle);
        System.out.println("----------------------------");
        try {
            strList = Files.readAllLines(p);
            for (int i = 0; i < strList.size(); i++) {
                if (strList.get(i).toLowerCase().contains(name.toLowerCase())) {
                    System.out.print((i + 1) + ": " + strList.get(i) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteContacts() {
        System.out.println("Choose the number you want to delete: ");


        List<String> strList = null;
        List<String> lines = null;
        int userInput;

        try {
            lines = Files.readAllLines(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userInput = input.getInt(1, lines.size());

        List<String> newList = new ArrayList<>();
        for (String line : lines) {
            if (line.equals(lines.get(userInput - 1))) {
                continue;
            }
            newList.add(line);

            try {
                Files.write(
                        p, newList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void userInter() {
        boolean keepOn = true;
        do {
            System.out.println("1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit\n");
            int userSelect = input.getInt(1, 5);
            switch (userSelect) {
                case 1:
                    System.out.println("\n");
                    viewContacts();
                    System.out.println("\n");
                    break;
                case 2:
                    addContacts();
                    System.out.println("\n");
                    viewContacts();
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Enter a name: ");
                    String searchedName = input.getString();
                    System.out.println("\n");
                    searchContacts(searchedName);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    viewContacts();
                    System.out.println("\n");
                    deleteContacts();
                    System.out.println("\n");
                    viewContacts();
                    System.out.println("\n");
                    break;
                case 5:
                    keepOn = false;
                    break;
            }
        }while(keepOn);
    }

}
