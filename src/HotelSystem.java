import java.util.Scanner;

import entities.Room;
import util.Options;

public class HotelSystem {

    public void menu() {

        Scanner scan = new Scanner(System.in);
        Room room = new Room();

        boolean exit = false;
        do {
            Options options = new Options();

            // Validate option
            int selectedOption = -1;
            boolean optionValid = false;
            do {
                options.seeOptions();

                try {
                    System.out.printf("%nEnter the option: ");
                    selectedOption = Integer.parseInt(scan.nextLine());
                    optionValid = true;

                } catch (Exception e) {
                    System.out.printf("%n-- Error: Invalid Option%n");
                }

            } while (optionValid == false);

            if (selectedOption == 0) {
                exit = true;
            } else if (options.validOption(selectedOption) == true) {

                options.selectOption(room, selectedOption);
            }

        } while (exit == false);

        scan.close();
        System.out.printf("%nThanks for testing :)");
        System.exit(0);
    }
}
