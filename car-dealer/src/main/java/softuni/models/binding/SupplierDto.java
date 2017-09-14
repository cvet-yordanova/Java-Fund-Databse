package softuni.models.binding;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupplierDto {

    @Expose
    private String name;

    @SerializedName(value = "isImporter")
    @Expose
    private Boolean usesImportedParts;

    public SupplierDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getUsesImportedParts() {
        return usesImportedParts;
    }

    public void setUsesImportedParts(Boolean usesImportedParts) {
        this.usesImportedParts = usesImportedParts;
    }
}
