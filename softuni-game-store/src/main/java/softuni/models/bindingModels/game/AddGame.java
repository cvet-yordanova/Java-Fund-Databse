package softuni.models.bindingModels.game;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class AddGame {

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 symbols.")
    @Pattern(regexp = "[A-Z]+.+", message = "Title must start with uppercase letter.")
    private String title;

    @DecimalMin(value = "0.00",message = "Price must be a positive number.")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    private BigDecimal price;

    private Double size;

    @Size(min = 11, max = 11, message = "Trailer must be 11 symbols.")
    private String trailer;

    @Pattern(regexp = "((http:\\/\\/)|(https:\\/\\/)).+")
    private String thumbnail;

    @Size(min = 20)
    private String description;
    private Date releaseDate;


    public AddGame() {
    }

    public AddGame(String title, BigDecimal price, Double size, String trailer, String thumbnail, String description, Date releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnail = thumbnail;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
