package bookshop_system.app.entities;


import java.math.BigDecimal;

public interface ReducedBook {
    String getTitle();
    EditionType getEditionType();
    AgeRestriction getAgeRestriction();
    BigDecimal getPrice();

}
