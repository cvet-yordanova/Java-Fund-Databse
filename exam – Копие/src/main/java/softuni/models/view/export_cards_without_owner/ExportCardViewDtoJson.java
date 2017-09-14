package softuni.models.view.export_cards_without_owner;


import com.google.gson.annotations.Expose;

public class ExportCardViewDtoJson {

    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
