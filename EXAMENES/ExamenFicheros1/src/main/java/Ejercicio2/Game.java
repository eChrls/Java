package ejercicio2;

public class Game {
    private String game;
    private String developer;
    private String genre;
    private String platform;
    private double rating;
    private double price;

    // Constructor por defecto (necesario para Jackson)
    public Game() {
    }

    public String getGame() {
        return game;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Game{" +
               "game='" + game + '\'' +
               ", developer='" + developer + '\'' +
               ", genre='" + genre + '\'' +
               ", platform='" + platform + '\'' +
               ", rating=" + rating +
               ", price=" + price +
               '}';
    }
}