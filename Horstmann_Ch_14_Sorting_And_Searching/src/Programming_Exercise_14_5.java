import java.io.File;
import java.util.*;


/**
 * "Write a telephone lookup program. Read a data set of 1000 names and telephone numbers from a file that contains the
 * numbers in random order. Handle lookups by name and also reverse lookups by phone number. Use a binary search for both
 * lookups."
 * */

public class Programming_Exercise_14_5{

    private final List<Contact> contacts;

    private Programming_Exercise_14_5(File namesAndNumbers){
        contacts=new ArrayList<>();
        readFile(namesAndNumbers);
    }

    class Contact {

        private final String name;
        private final String number;

        private Contact(String name, String number){
            this.name=name;
            this.number=number;
        }

        private String getName(){
            return this.name;
        }

        private String getNumber(){
            return this.number;
        }
    }

    class NameComparator implements Comparator<Contact> {

        public int compare(Contact item1, Contact item2){
            return item1.getName().compareTo(item2.getName());
        }
    }

    class NumberComparator implements Comparator<Contact> {

        public int compare(Contact item1, Contact item2){
            return Integer.parseInt(item1.getNumber().replaceAll("\\s", ""))-Integer.parseInt(item2.getNumber().replaceAll("\\s", ""));
        }
    }


    private void readFile(File file){

        try(Scanner in=new Scanner(file)){
            while(in.hasNextLine()){
                String[] lineParts=in.nextLine().split("\\|");
                contacts.add(new Contact(lineParts[0], lineParts[1]/*.replaceAll("\\s+", "")*/));
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }
    }

    private void nameLookup(String number){
        //Order list by number
        contacts.sort(new NumberComparator());

        //Do a binary search for the number supplied by the user (regex that removes whitespaces and hyphens if number inputted like: 06-22-33-44-55 or 06 22 33 44 55)
        int index=Collections.binarySearch(contacts, new Contact(null, number.replaceAll("[\\-\\s]+", "")), new NumberComparator());

        //If element is found that matches the name: print the name associated with that number, else print "Number not found!".
        if(index>0){
            String name=contacts.get(index).getName();
            System.out.printf("The number %s belongs to %s\n", number, name);
        }
        else{
            System.out.print("Number not found!");
        }
    }

    private void numberLookup(String name){
        //Order the list by name
        contacts.sort(new NameComparator());

        // Do a binary search for the name supplied by user
        int index=Collections.binarySearch(contacts, new Contact(name, null), new NameComparator());

        // If element is found that matches the name: print the number associated with that name, else print "Name not found!".
        if(index>0){
            String number=contacts.get(index).getNumber();
            System.out.printf("The number for %s is %s\n", name, number);
        }
        else{
        System.out.print("Name not found!");
        }
    }

    public static void main(String[] args){

        File file=new File("/path/to/NamesAndPhoneNumbers.csv");
        Programming_Exercise_14_5 contacts=new Programming_Exercise_14_5(file);

        // Look up the phone number of Lamar A. Walsh.
        contacts.numberLookup("Walsh, Lamar A.");

        //Look up the name associated with the number 09-35-68-34-76
        contacts.nameLookup("09-35-68-34-76");

    }
}
