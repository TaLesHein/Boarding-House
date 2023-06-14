package entities;

import java.util.Scanner;

public class Room {

    private Guest rooms[] = new Guest[10];

    public void avaibleRooms() {

        System.out.printf("%nAvaible Rooms%n");
        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i] == null) {
                System.out.println("# " + (i + 1));
            }
            else{
                System.out.println("# X");
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.printf("%nEnter with any button...");
        String space = scan.nextLine();
        System.out.println();

    }

    public void rentRoom(String name, String email, char gender, int room) {

        if (rooms[room - 1] != null) {
            System.out.printf("%n-- Ops, this room is already booked!! %n");
            return;
        }

        Guest guest = new Guest(name, email, gender, room);
        rooms[room - 1] = guest;

        char hostgender = guest.getGender();
        if (hostgender == 'M') {
            System.out.printf("%n- Congratulations, room #%d has been reserved for Mr %s%n", room, guest.getName());
        } else {
            System.out.printf("%n- Congratulations, room #%d has been reserved for Mrs %s%n", room, guest.getName());
        }

    }

    public void makeRoomAvaible(int room) {

        if (rooms[room - 1] == null) {
            System.out.printf("%nThis room is already empty%n");
            return;
        }

        rooms[room] = null;

        System.out.printf("%nRoom #%d has been released", room);
    }

    public void guestList() {

        System.out.println();
        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i] != null) {
                System.out.printf("%n#%d - "
                        + "Guest: %s, "
                        + "Email: %s%n", (i + 1), rooms[i].getName(), rooms[i].getEmail());
            }

        }

        Scanner scan = new Scanner(System.in);
        System.out.printf("%nEnter with any button...");
        scan.nextLine();
        System.out.println();

    }
}
