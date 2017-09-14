package softuni.models.viewModels.game;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

public class GameDetailsView {

    private Long id;
    private String title;
    private String trailer;
    private String thumbnailURL;
    private double size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public GameDetailsView() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public String toString() {
        return
                " Title: " + title + "\n" +
                " Trailer: " + trailer + "\n" +
                " ThumbnailURL: " + thumbnailURL + "\n" +
                " Size: " + size + "\n"+
                " Price: " + price + "\n"+
                " Description: " + description + "\n" +
                " ReleaseDate: " + releaseDate +"\n";
    }
}
