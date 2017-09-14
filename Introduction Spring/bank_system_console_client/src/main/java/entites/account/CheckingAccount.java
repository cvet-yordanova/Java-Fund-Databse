package entites.account;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
@Table(name = "checking_account")
public class CheckingAccount extends BasicAccount{
    private Double fee;

    public CheckingAccount() {
    }

    public CheckingAccount(String accountNumber, BigDecimal balance, Double fee) {
        super(accountNumber, balance);
        this.fee = fee;
    }

    @Column(name = "fee")
    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    @Transient
    public void deductFee(Double fee){
        Double interestRate = this.getFee()-fee;
        this.setFee(interestRate);
    }
}
