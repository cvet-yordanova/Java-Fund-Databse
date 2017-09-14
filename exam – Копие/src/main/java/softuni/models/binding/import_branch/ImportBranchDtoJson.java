package softuni.models.binding.import_branch;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import softuni.entities.Town;

public class ImportBranchDtoJson {

    @Expose
    private String name;

    @Expose
    @SerializedName(value = "town")
    private String townName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
