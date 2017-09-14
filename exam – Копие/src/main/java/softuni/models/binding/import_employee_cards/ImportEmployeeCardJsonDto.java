package softuni.models.binding.import_employee_cards;


import com.google.gson.annotations.Expose;

public class ImportEmployeeCardJsonDto {

    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
