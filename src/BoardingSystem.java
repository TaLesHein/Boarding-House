import java.util.Scanner;

import entities.Room;
import util.Options;

public class BoardingSystem {

    public void menu() {

        Scanner scan = new Scanner(System.in);
        Room room = new Room();

        boolean exit = false;
        do {
            Options options = new Options();

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

            if (options.validOption(selectedOption) == true) {

                options.selectOption(room, selectedOption);
            }

        } while (exit == false);

        scan.close();
        System.exit(0);
    }
}
