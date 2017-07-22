package entities;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
@PrimaryKeyJoinColumn(name = "bank_account_id")
//@DiscriminatorValue(value = "Bank Account")
public class BankAccount extends BasicBillingDetail{
    private String name;
    private String swiftCode;

    public BankAccount(String number, User owner, String name, String swiftCode) {
        super(number, owner);
        this.name = name;
        this.swiftCode = swiftCode;
    }

    public BankAccount() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "swift_code")
    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
