package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "cash")
@Table(name = "cashes")
public class Cash extends Present{


    private BigDecimal amount;

    @NotNull
    @Column(name = "amount", nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


}
