package pl.com.data;

import java.util.ArrayList;
import java.util.List;

public class GameStoreEmployee extends Employee {

    private static final long serialVersionUID = 1986276621049515759L;
    private List<Game> gameHistory;
    private List<Game> soldGames;

    public List<Game> getGameHistory() {
        return gameHistory;
    }

    public List<Game> getSoldGames() {
        return soldGames;
    }

    public GameStoreEmployee(String firstName, String lastName, String employeeID) {
        super(firstName, lastName, employeeID);
        gameHistory = new ArrayList<>();
        soldGames = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameStoreEmployee that = (GameStoreEmployee) o;

        if (getGameHistory() != null ? !getGameHistory().equals(that.getGameHistory()) : that.getGameHistory() != null)
            return false;
        return getSoldGames() != null ? getSoldGames().equals(that.getSoldGames()) : that.getSoldGames() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGameHistory() != null ? getGameHistory().hashCode() : 0);
        result = 31 * result + (getSoldGames() != null ? getSoldGames().hashCode() : 0);
        return result;
    }
}
