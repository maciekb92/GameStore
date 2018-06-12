package pl.com.data;

public class BoardGame extends Game {

    private static final long serialVersionUID = 1247550583324925603L;
    private int minimumNumberOfPlayers;
    private int maximumNumberOfPlayers;
    private String author;
    private String weight;

    public int getMinimumNumberOfPlayers() {
        return minimumNumberOfPlayers;
    }

    public void setMinimumNumberOfPlayers(int minimumNumberOfPlayers) {
        this.minimumNumberOfPlayers = minimumNumberOfPlayers;
    }

    public int getMaximumNumberOfPlayers() {
        return maximumNumberOfPlayers;
    }

    public void setMaximumNumberOfPlayers(int maximumNumberOfPlayers) {
        this.maximumNumberOfPlayers = maximumNumberOfPlayers;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public BoardGame(String title, String author, double price, String releaseDate, int minimumNumberOfPlayers, int maximumNumberOfPlayers, String weight) {
        super(title, price, releaseDate);
        setAuthor(author);
        setMinimumNumberOfPlayers(minimumNumberOfPlayers);
        setMaximumNumberOfPlayers(maximumNumberOfPlayers);
        setWeight(weight);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append("Title: ");
        print.append(getTitle());
        print.append(", Author: ");
        print.append(getAuthor());
        print.append(", Price: ");
        print.append(getPrice());
        print.append(" euro, Release date: ");
        print.append(getReleaseDate());
        print.append(", Minimum number of players: ");
        print.append(getMinimumNumberOfPlayers());
        print.append(", Maximum number of players: ");
        print.append(getMaximumNumberOfPlayers());
        print.append(", Weight: ");
        print.append(getWeight());
        print.append(".");
        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BoardGame boardGame = (BoardGame) o;

        if (getMinimumNumberOfPlayers() != boardGame.getMinimumNumberOfPlayers()) return false;
        if (getMaximumNumberOfPlayers() != boardGame.getMaximumNumberOfPlayers()) return false;
        if (getAuthor() != null ? !getAuthor().equals(boardGame.getAuthor()) : boardGame.getAuthor() != null)
            return false;
        return getWeight() != null ? getWeight().equals(boardGame.getWeight()) : boardGame.getWeight() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getMinimumNumberOfPlayers();
        result = 31 * result + getMaximumNumberOfPlayers();
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        return result;
    }
}
