package addressbook;

import java.util.*;

public class AddressBookMain {
    public enum IOService {
        CONSOLE_IO, FILE_IO
    }
    private List<Contacts> addressbooklist;

    public AddressBookMain(List<Contacts> addressbooklist) {
        this.addressbooklist = addressbooklist;
    }
    public void readAddressBookData(Scanner consoleInputReader) {
        System.out.println("Enter firstname");
        String firstName = consoleInputReader.next();
        System.out.println("Enter lastname");
        String lastName = consoleInputReader.next();
        System.out.println("Enter address");
        String address = consoleInputReader.next();
        System.out.println("Enter city");
        String city = consoleInputReader.next();
        System.out.println("Enter state");
        String state = consoleInputReader.next();
        System.out.println("Enter zip");
        String zip = consoleInputReader.next();
        System.out.println("Enter phone number");
        String phoneNumber = consoleInputReader.next();
        System.out.println("Enter email");
        String email = consoleInputReader.next();
        addressbooklist.add(new Contacts(firstName,lastName,address,city,state,zip,phoneNumber,email));
    }
    public void writeAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\nWriting Address Book Roaster to Console\n" + addressbooklist);
        else
            new AddressBookIO().writeData(addressbooklist);
    }
    public long readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            this.addressbooklist = new AddressBookIO().readData();
        return addressbooklist.size();
    }
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new AddressBookIO().countEntries();
        return 0;
    }
    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new AddressBookIO().printData();
    }
    public static void main(String[] args) {
        ArrayList<Contacts> addressbooklist = new ArrayList<>();
        AddressBookMain addressBook = new AddressBookMain(addressbooklist);
        Scanner consoleInputReader = new Scanner(System.in);
        addressBook.readAddressBookData(consoleInputReader);
        addressBook.writeAddressBookData(IOService.CONSOLE_IO);
    }



}
