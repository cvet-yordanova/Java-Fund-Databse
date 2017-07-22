package entites;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicAccount implements Account{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    private Long accountNumber;
    private BigDecimal balance;

    public BasicAccount() {
    }

    public BasicAccount(Long accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    @Id
    public Long getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    @Column(name = "balance")
    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setAccountNumber(Long accountNumber) {
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
        em.getTransaction().begin();
        em.persist(this);
        em.close();
    }

    @Override
    @Transient
    public void withDrawMoney(BigDecimal amountMoney) {
        BigDecimal money = this.getBalance().subtract(amountMoney);
        this.setBalance(money);
        em.getTransaction().begin();
        em.persist(this);
        em.close();
    }
}
