package newApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.StandardOpenOption;

public class ContactMenu extends MenuOptions {

    public static void displayMenu() {
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
                    String searchedName = input.getString("Enter a name:");
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
                    System.out.println("Goodbye!");
                    break;
            }
        }while(keepOn);
    }

}
