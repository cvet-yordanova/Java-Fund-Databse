package entites.account;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Entity
@Table(name = "saving_account")
public class SavingAccount extends BasicAccount{
    private Double interestRate;

    public SavingAccount() {
    }

    public SavingAccount(String accountNumber, BigDecimal balance, Double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Column(name = "interest_rate")
    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Transient
    public void addInterest(Double interest){
        Double interestRate = this.getInterestRate()+interest;
        this.setInterestRate(interestRate);
    }
}
