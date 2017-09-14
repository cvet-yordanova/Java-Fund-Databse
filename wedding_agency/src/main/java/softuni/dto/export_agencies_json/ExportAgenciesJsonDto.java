package softuni.dto.export_agencies_json;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExportAgenciesJsonDto {

    @Expose
    private String name;

    @Expose
    @SerializedName(value = "count")
    private Integer employeesCount;

    @Expose
    private String town;

    public ExportAgenciesJsonDto(String name, Integer employeesCount, String town) {
        this.name = name;
        this.employeesCount = employeesCount;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
