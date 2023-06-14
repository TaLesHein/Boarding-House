package util;

import java.util.Scanner;

import entities.Room;

/*  Class intended for handling options, in the form of data output,
 *  data validation and option selection.
 */

public class Options {

    private String options[] = new String[5];

    public Options() {

        options[0] = "[1] Avaiable Rooms";
        options[1] = "[2] Rent Room";
        options[2] = "[3] Vacate room";
        options[3] = "[4] Check guest details";
        options[4] = "[0] Exit";

    }

    public void seeOptions() {

        for (int i = 0; i < options.length; i++) {

            System.out.println(options[i]);

        }
    }

    public boolean validOption(int option) {

        // Valid whether the option exists or not.
        if (option <= this.options.length - 1 && option >= 0) {

            return true;
        } else {
            System.out.printf("%n-- Error: Option is invalid%n");
            return false;
        }

    }

    public void selectOption(Room room, int option) {

        Scanner scan = new Scanner(System.in);

        int numRoom;
        boolean roomValid;

        switch (option) {

            // Exit Option
            case 0:
                return;

            // Avaiable Rooms Option
            case 1:
                room.avaibleRooms();
                break;

            // Rent Room Option
            case 2:

                // Register guest information to rent room

                // Validating the hostname so that it is not null or empty
                String name = null;
                boolean nameValid = false;
                do{
                    System.out.printf("%nEnter the guest's name: ");
                    name = scan.nextLine();

                    if (name != null && !name.isEmpty()) {
                        name = StringUtils.capitalizeFirstString(name);
                        nameValid = true;
                    }
                    else{
                        System.out.printf("%n-- Error: Null or empty name");
                    }
                }while(nameValid == false);

                // Validate guest gender so there are no errors
                char gender;
                boolean genderValid = false;
                do {
                    System.out.printf("%nEnter the guest's gender: ");
                    gender = Character.toUpperCase(scan.nextLine().charAt(0));

                    if (gender == 'M' || gender == 'F') {
                        genderValid = true;
                    } else {
                        System.out.printf("%n-- Error: Invalid gender%n");
                        genderValid = false;
                    }
                } while (genderValid == false);

                // Validate guest email so there are no errors
                String email = null;
                boolean emailValid = false;
                do{
                    System.out.printf("%nEnter the guest's email: ");
                    email = scan.nextLine();

                    if (StringUtils.isValidEmail(email) == true){
                        emailValid = true;
                    }
                    else{
                        System.out.printf("%n-- Error: Invalid email%n");
                    }
                }while(emailValid== false);

                /*
                 * Validate the room number, validating whether it exists or not,
                 * addition to catching exceptions
                 */

                numRoom = -1;
                roomValid = false;
                do {
                    try {
                        System.out.printf("%nEnter the room number: ");
                        numRoom = Integer.parseInt(scan.nextLine());
                        roomValid = true;
                    } catch (NumberFormatException e) {
                        System.out.printf("%-- Error: Room does not exist%n");
                    }
                } while (!roomValid);

                if (confirmData(name, email, gender, numRoom) == true) {
                    room.rentRoom(name, email, gender, numRoom);
                }
                break;

            // Vacate Room
            case 3:

                /*
                 * Validate the room number, validating whether it exists or not,
                 * addition to catching exceptions
                 */

                numRoom = -1;
                roomValid = false;
                do {

                    System.out.printf("%nWhich room do you want to vacate? ");
                    try {

                        numRoom = Integer.parseInt(scan.nextLine());
                        roomValid = true;

                    } catch (Exception e) {

                        System.out.printf("%n-- Error: Invalid Room%n");
                    }
                } while (roomValid == false);

                room.makeRoomAvaible(numRoom);

                break;

            // Check Rooms Informations
            case 4:
                room.guestList();
                break;
        }
    }

    // Shows the user all the information registered so that he confirm its veracity
    public boolean confirmData(String name, String email, char gender, int numRoom) {

        Scanner scan = new Scanner(System.in);
        char confirmData;

        // Display all information on the screen
        System.out.printf("%nName: %s, Email: %s, gender: %c, Room: %d%n", name, email, gender, numRoom);
        System.out.print("Confirm Data? (y/n) ");

        // Validate user choices
        do {

            confirmData = Character.toUpperCase(scan.nextLine().charAt(0));

            if (confirmData != 'Y' && confirmData != 'N') {
                System.out.printf("%n-- Error: Options Invalid");
            }

        } while (confirmData == 'Y' && confirmData == 'N');

        /*
         * If the user confirms, it will return true to the previous method that will
         * register this data
         * 
         * If the user does not confirm, it will return false to the previous method
         * that will cancel
         * the registration
         */

        if (confirmData == 'Y') {
            return true;
        } else {
            System.out.println("Registration Canceled");
            return false;
        }

    }

}
