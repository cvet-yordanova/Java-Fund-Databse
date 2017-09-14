package entites.account;


import entites.account.Account;
import user.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicAccount implements Account {

    private String accountNumber;
    private BigDecimal balance;
    private User user;

    public BasicAccount() {
    }

    public BasicAccount(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    @Id
    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    @Column(name = "balance")
    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    @Transient
    public void depositMoney(BigDecimal amountMoney) {
        BigDecimal money = this.getBalance().add(amountMoney);
        this.setBalance(money);
    }

    @Override
    @Transient
    public void withDrawMoney(BigDecimal amountMoney) {
        BigDecimal money = this.getBalance().subtract(amountMoney);
        this.setBalance(money);
    }

    @ManyToOne
    @JoinColumn(name = "account_users",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
