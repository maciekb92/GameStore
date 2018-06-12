package pl.com.data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GameStore implements Serializable {

    private static final long serialVersionUID = 4950831783310973605L;
    private Map<String, Game> games;
    private Map<String, GameStoreEmployee> gameStoreEmployees;

    public Map<String, Game> getGames() {
        return games;
    }

    public Map<String, GameStoreEmployee> getGameStoreEmployee() {
        return gameStoreEmployees;
    }

    public GameStore() {
        games = new HashMap<>();
        gameStoreEmployees = new HashMap<>();
    }

    public void addDigitalGame(DigitalGame digitalGame) {
        addGame(digitalGame);
    }

    public void addBoardGame(BoardGame boardGame) {
        addGame(boardGame);
    }

    public void addGameStoreEmployee(GameStoreEmployee gameStoreEmployee) {
        gameStoreEmployees.put(gameStoreEmployee.getEmployeeID(), gameStoreEmployee);
    }

    private void addGame(Game game) {
        games.put(game.getTitle(), game);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
            for(Game g: games.values()) {
                print.append(g);
                print.append("\n");
            }
            return print.toString();
    }

    public static class AlphabeticalComparator implements Comparator<Game> {
        @Override
        public int compare(Game game1, Game game2) {
            if(game1 == null && game2 == null) {
                return 0;
            }
            if(game1 == null) {
                return 1;
            }
            if(game2 == null) {
                return -1;
            }
            return game1.getTitle().compareTo(game2.getTitle());
        }
    }

    public static class AlphabeticalEmployeeComparator implements Comparator<GameStoreEmployee> {
        @Override
        public int compare(GameStoreEmployee gameStoreEmployee1, GameStoreEmployee gameStoreEmployee2) {
            return gameStoreEmployee1.getLastName().compareTo(gameStoreEmployee2.getLastName());
        }
    }

    /* public static class DateComparator implements Comparator<Game> {
        @Override
        public int compare(Game game1, Game game2) {
            if(game1 == null && game2 == null) {
                return 0;
            }
            if(game1 == null) {
                return 1;
            }
            if(game2 == null) {
                return -1;
            }
            String i1 = game1.getReleaseDate();
            String i2 = game2.getReleaseDate();
            return -i1.compareTo(i2);
        }
    } */
}




