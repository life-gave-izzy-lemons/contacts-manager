import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ContactsApplication {


    public static void main(String[] args) {
        addContacts("Mark", "7874378738");
        viewContacts();
        Input input = new Input();
        String searchedName = input.getString();
//        searchContacts(searchedName);
        deleteContacts(searchedName);
    }


    public static void viewContacts() {

        Path filePath = Paths.get("src", "contacts.txt");
        List<String> strList = null;

        try {
            strList = Files.readAllLines(filePath);
            for (int i = 0; i < strList.size(); i++) {
                System.out.print((i + 1) + ": " + strList.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addContacts(String name, String num) {

        Path filePath = Paths.get("src", "contacts.txt");
        List<String> strList = null;

        try {
            Files.write(
                    Paths.get("src", "contacts.txt"),
                    Arrays.asList(String.format("%s | %s", name, num)), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchContacts(String name) {

        Path filePath = Paths.get("src", "contacts.txt");
        List<String> strList = null;

        try {
            strList = Files.readAllLines(filePath);
            for (int i = 0; i < strList.size(); i++) {
                if (strList.get(i).contains(name)) {
                    System.out.print((i + 1) + ": " + strList.get(i) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteContacts() {

        Path filePath = Paths.get("src", "contacts.txt");
        List<String> strList = null;

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("src", "contacts.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).contains()) {
                System.out.print((i + 1) + ": " + strList.get(i) + "\n");
            }
        }

        List<String> newList = new ArrayList<>();
        for (String line : lines) {
            if (line.contains()) {
                continue;
            }
            newList.add(line);

            try {
                Files.write(
                        Paths.get("src", "contacts.txt"), newList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
