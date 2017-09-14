package entites.account;

import java.math.BigDecimal;

public interface Account {
    String getAccountNumber();
    BigDecimal getBalance();
    void depositMoney(BigDecimal amountMoney);
    void withDrawMoney(BigDecimal amountMoney);
}
