import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        Scanner file = new Scanner(new File("src/phoneBook.txt"));

        int lineCounter = 0;

        while(file.hasNextLine()) {
            String line = file.nextLine();
            lineCounter++;
        }
        file.close();
        Scanner fileOpen = new Scanner(new File("src/phoneBook.txt"));
        Contacts[] contactInformation = new Contacts[lineCounter];

        int index = 0;
        while(fileOpen.hasNextLine()) {
            String line = fileOpen.nextLine();
            Scanner lineScan = new Scanner(line);

            while(lineScan.hasNext()) {
                String fName = lineScan.next();
                String lName = "";
                while (lineScan.hasNext() && !lineScan.hasNextInt()) {
                    lName += lineScan.next() + " ";
                }
                int pNumber = lineScan.nextInt();
                Contacts newContact = new Contacts(fName, lName, pNumber);
                contactInformation[index] = newContact;
            }
            index++;
        }
    }
}
