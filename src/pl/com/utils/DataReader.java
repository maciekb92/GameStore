package pl.com.utils;

import pl.com.data.BoardGame;
import pl.com.data.DigitalGame;
import pl.com.data.GameStoreEmployee;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {

    private Scanner input;

    public DataReader() {
        input = new Scanner(System.in);
    }

    public void close() {
        input.close();
    }

    public DigitalGame addNewDigitalGame() throws InputMismatchException {
        System.out.println("Title: ");
        String title = input.nextLine();
        System.out.println("Category: ");
        String category = input.nextLine();
        System.out.println("Price: ");
        double price = 0;
        int minimumAge = 0;
        try {
            price = input.nextDouble();
            input.nextLine();
            System.out.println("Minimum age: ");
            minimumAge = input.nextInt();
            input.nextLine();
        } catch(InputMismatchException e) {
            input.nextLine();
            throw e;
        }
        System.out.println("Producer: ");
        String producer = input.nextLine();
        System.out.println("Platform: ");
        String platform = input.nextLine();
        System.out.println("Release date: ");
        String releaseDate = input.nextLine();

        return new DigitalGame(title, category, price, minimumAge, producer, platform, releaseDate);
    }

    public BoardGame addNewBoardGame() throws InputMismatchException {
        System.out.println("Title: ");
        String title = input.nextLine();
        System.out.println("Price: ");
        Double price = input.nextDouble();
        input.nextLine();
        System.out.println("Release date: ");
        String releaseDate = input.nextLine();
        System.out.println("Minimum number of players: ");
        int minimumNumberOfPlayers = 0;
        int maximumNumberOfPlayers = 0;
        try {
            minimumNumberOfPlayers = input.nextInt();
            input.nextLine();
            System.out.println("Maximum number of players: ");
            maximumNumberOfPlayers = input.nextInt();
            input.nextLine();
        } catch(InputMismatchException e) {
            input.nextLine();
            throw e;
        }
        System.out.println("Author: ");
        String author = input.nextLine();
        System.out.println("Weight: ");
        String weight = input.nextLine();

        return new BoardGame(title, author, price, releaseDate, minimumNumberOfPlayers, maximumNumberOfPlayers, weight);
    }

    public GameStoreEmployee addNewGameStoreEmployee() {
        System.out.println("First name: ");
        String firstName = input.nextLine();
        System.out.println("Last name: ");
        String lastName = input.nextLine();
        System.out.println("Employee ID: ");
        String employeeID = input.nextLine();

        return new GameStoreEmployee(firstName, lastName, employeeID);
    }

    public int getOption() throws NumberFormatException {
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("Incorrect amount format.");
        } finally {
            input.nextLine();
        }
        return option;
    }
}
