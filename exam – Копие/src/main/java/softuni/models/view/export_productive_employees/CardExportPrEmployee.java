package softuni.models.view.export_productive_employees;


import com.google.gson.annotations.Expose;

public class CardExportPrEmployee {

    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
