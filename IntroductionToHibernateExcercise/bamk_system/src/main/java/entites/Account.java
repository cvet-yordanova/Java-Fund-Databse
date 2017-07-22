package entites;

import java.math.BigDecimal;

public interface Account {
    Long getAccountNumber();
    BigDecimal getBalance();
    void depositMoney(BigDecimal amountMoney);
    void withDrawMoney(BigDecimal amountMoney);
}
