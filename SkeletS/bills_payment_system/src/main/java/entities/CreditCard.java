package entities;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
@PrimaryKeyJoinColumn(name = "credit_card_id")
//@DiscriminatorValue(value = "credit_card")
public class CreditCard extends BasicBillingDetail{
    private String cardType;
    private String expirationMonth;
    private Integer expirationYear;

    public CreditCard() {
    }

    public CreditCard(String number, User owner, String cardType, String expirationMonth, Integer expirationYear) {
        super(number, owner);
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
