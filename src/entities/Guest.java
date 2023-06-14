package entities;

public class Guest {

    private String name, email;
    private char gender;
    private int guestRoom;

    public Guest(String name, String email, char gender, int room) {

        this.name = name;
        this.email = email;
        this.gender = gender;
        this.guestRoom = room;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public int getGuestRoom() {
        return guestRoom;
    }

    public String toString() {
        return this.name + ", "
                + this.email + ", "
                + this.guestRoom;
    }
}