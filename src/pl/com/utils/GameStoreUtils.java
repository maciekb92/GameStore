package pl.com.utils;

import pl.com.data.*;
import java.util.*;

public class GameStoreUtils {

    public static void printDigitalGamesList(GameStore gameStore) {
        List<Game> games = new ArrayList<>();
        games.addAll(gameStore.getGames().values());
        Collections.sort(games, new GameStore.AlphabeticalComparator());
        int countDigitalGames = 0;
        for(Game g: games) {
            if(g instanceof DigitalGame) {
                System.out.println(g);
                countDigitalGames++;
            }
        }

        if(countDigitalGames == 0) {
            System.out.println("Empty list of Digital Games.");
        }
    }

    public static void printBoardGamesList(GameStore gameStore) {
        List<Game> games = new ArrayList<>();
        games.addAll(gameStore.getGames().values());
        Collections.sort(games, new GameStore.AlphabeticalComparator());
        int countBoardGames = 0;
        for(Game g: games) {
            if(g instanceof BoardGame) {
                System.out.println(g);
                countBoardGames++;
            }
        }

        if(countBoardGames == 0) {
            System.out.println("Empty list of Board Games.");
        }
    }

    public static void printGameStoreEmployeeList(GameStore gameStore) {
        List<GameStoreEmployee> gameStoreEmployees = new ArrayList<>();
        gameStoreEmployees.addAll(gameStore.getGameStoreEmployee().values());
        Collections.sort(gameStoreEmployees, new GameStore.AlphabeticalEmployeeComparator());
        int countEmployees = 0;
        for(GameStoreEmployee e: gameStoreEmployees) {
            if(e instanceof GameStoreEmployee) {
                System.out.println(e);
                countEmployees++;
            }
        }

        if(countEmployees == 0) {
            System.out.println("Empty list of Game Shop Employees.");
        }
    }
}
