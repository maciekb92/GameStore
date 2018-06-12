package pl.com.app;

import pl.com.data.*;
import pl.com.utils.DataReader;
import pl.com.utils.FileManager;
import pl.com.utils.GameStoreUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class GameStoreControl {

    private DataReader dataReader;
    private GameStore gameStore;
    private FileManager fileManager;

    public GameStoreControl() {
        dataReader = new DataReader();
        gameStore = new GameStore();
        fileManager = new FileManager();
        try {
            gameStore = fileManager.readGameStoreFromFile();
            System.out.println("Data loaded from file");
        } catch (ClassNotFoundException | IOException e) {
            gameStore = new GameStore();
            System.out.println("New database created for GameStore");
        }
    }

    public void ControlLoop() {
        Option option = null;
        while(option != Option.EXIT) {
            try {
                printOptions();
                option = Option.createOptions(dataReader.getOption());
                switch (option) {
                    case EXIT:
                        exit();
                        System.out.println("Exit program");
                        break;
                    case ADD_DIGITAL_GAME:
                        addDigitalGame();
                        break;
                    case PRINT_DIGITAL_GAMES:
                        printDigitalGames();
                        break;
                    case ADD_BOARD_GAME:
                        addBoardGame();
                        break;
                    case PRINT_BOARD_GAMES:
                        printBoardGames();
                        break;
                    case ADD_GAME_STORE_EMPLOYEE:
                        addGameStoreEmployee();
                        break;
                    case PRINT_GAME_STORE_EMPLOYEE:
                        printGameStoreEmployee();
                        break;
                    default:
                        System.out.println("Incorrect value. Try again!");
                }
            } catch(InputMismatchException e) {
                System.out.println("Incorrect value. Game has not been added.");
            } catch(NumberFormatException e) {
                System.out.println("Incorrect value. Try again.");
            }
        }
        dataReader.close();
    }

    private void printOptions() {
        System.out.println("Select option: ");
        for(Option o: Option.values()) {
            System.out.println(o);
        }
    }

    private void addDigitalGame() {
        DigitalGame digitalGame = dataReader.addNewDigitalGame();
        gameStore.addDigitalGame(digitalGame);
    }

    private void addBoardGame() {
        BoardGame boardGame = dataReader.addNewBoardGame();
        gameStore.addBoardGame(boardGame);
    }

    private void addGameStoreEmployee() {
        GameStoreEmployee gameStoreEmployee = dataReader.addNewGameStoreEmployee();
        gameStore.addGameStoreEmployee(gameStoreEmployee);
    }

    private void printDigitalGames() {
        GameStoreUtils.printDigitalGamesList(gameStore);
    }

    private void printBoardGames() {
        GameStoreUtils.printBoardGamesList(gameStore);
    }

    private void printGameStoreEmployee() {
        GameStoreUtils.printGameStoreEmployeeList(gameStore);
    }

    private void exit() {
        fileManager.writeGameStoreToFile(gameStore);
    }

    private enum Option {
        EXIT(0,"Exit"),
        ADD_DIGITAL_GAME(1,"Add digital game."),
        PRINT_DIGITAL_GAMES(2,"Print list of the available digital games."),
        ADD_BOARD_GAME(3,"Add board game."),
        PRINT_BOARD_GAMES(4,"Print list of the available board games."),
        ADD_GAME_STORE_EMPLOYEE(5, "Add Game Shop Employee."),
        PRINT_GAME_STORE_EMPLOYEE(6, "Print list of Game Shop Employee");

        private int optionValue;
        private String optionDescription;

        public int getOptionValue() {
            return optionValue;
        }

        public String getOptionDescription() {
            return optionDescription;
        }

        Option(int optionValue, String optionDescription) {
            this.optionValue = optionValue;
            this.optionDescription = optionDescription;
        }

        @Override
        public String toString() {
            return getOptionValue() + " - " + getOptionDescription();
        }

        public static Option createOptions(int optionValue) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[optionValue];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("Option doesn't exists.");
            }
            return result;
        }

    }
}
