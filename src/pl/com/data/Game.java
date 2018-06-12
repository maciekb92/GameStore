package pl.com.data;

import java.io.Serializable;

public abstract class Game implements Serializable, Comparable<Game> {

    private static final long serialVersionUID = -4697754606069647775L;
    private String title;
    private double price;
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    protected Game(String title, double price, String releaseDate) {
        setTitle(title);
        setPrice(price);
        setReleaseDate(releaseDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (Double.compare(game.getPrice(), getPrice()) != 0) return false;
        if (getTitle() != null ? !getTitle().equals(game.getTitle()) : game.getTitle() != null) return false;
        return getReleaseDate() != null ? getReleaseDate().equals(game.getReleaseDate()) : game.getReleaseDate() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitle() != null ? getTitle().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getReleaseDate() != null ? getReleaseDate().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Game game) {
        return title.compareTo(game.getTitle());
    }
}
