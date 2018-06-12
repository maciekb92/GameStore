package pl.com.data;

public class DigitalGame extends Game {

    private static final long serialVersionUID = -1930115361726634719L;
    private String category;
    private String platform;
    private String producer;
    private int minimumAge;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public DigitalGame(String title, String producer, double price, int minimumAge, String releaseDate, String category, String platform) {
        super(title, price, releaseDate);
        setProducer(producer);
        setMinimumAge(minimumAge);
        setCategory(category);
        setPlatform(platform);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append("Title: ");
        print.append(getTitle());
        print.append(", Producer: ");
        print.append(getProducer());
        print.append(", Price: ");
        print.append(getPrice());
        print.append(", Minimum age: ");
        print.append(getMinimumAge());
        print.append(", Release date: ");
        print.append(getReleaseDate());
        print.append(", Category: ");
        print.append(getCategory());
        print.append(", Platform: ");
        print.append(getPlatform());
        print.append(".");
        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DigitalGame that = (DigitalGame) o;

        if (getMinimumAge() != that.getMinimumAge()) return false;
        if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null)
            return false;
        if (getPlatform() != null ? !getPlatform().equals(that.getPlatform()) : that.getPlatform() != null)
            return false;
        return getProducer() != null ? getProducer().equals(that.getProducer()) : that.getProducer() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getPlatform() != null ? getPlatform().hashCode() : 0);
        result = 31 * result + (getProducer() != null ? getProducer().hashCode() : 0);
        result = 31 * result + getMinimumAge();
        return result;
    }
}
