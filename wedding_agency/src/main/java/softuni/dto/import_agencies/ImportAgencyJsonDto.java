package softuni.dto.import_agencies;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ImportAgencyJsonDto {

    @Expose
    private String name;
    @Expose
    private Integer employeesCount;
    @Expose
    private String town;

    private BigDecimal amount;

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
