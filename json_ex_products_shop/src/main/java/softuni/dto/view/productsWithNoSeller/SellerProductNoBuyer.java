package softuni.dto.view.productsWithNoSeller;


import com.google.gson.annotations.Expose;

public class SellerProductNoBuyer {


    private String firstName;

    private String lastName;
    @Expose
    private String fullName;

    public SellerProductNoBuyer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        if(this.getFirstName() == null){
            this.fullName = lastName;
        }
        else {
            this.fullName = this.getFirstName().concat(" " + this.getLastName());
        }
    }
}
