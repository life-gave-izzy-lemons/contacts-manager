package newApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ApplicationContacts {
    public static void main(String[] args) {

    }

    public static void viewContacts() {
        List<String> strList;
        String name = "       Name";
        String num = "Number";
        System.out.printf("%-15s | %s \n", name, num);
        System.out.println("----------------------------");
        try {
            strList = Files.readAllLines(filePath);
            for (int i = 0; i < strList.size(); i++) {
                System.out.printf((i + 1) + " : " + strList.get(i) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
