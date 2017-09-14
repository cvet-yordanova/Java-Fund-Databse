package softuni.models.binding;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CustomerDto {

    @Expose
    private String name;

    @Expose
    @DateTimeFormat
    private Date birthDate;

    @Expose
    @SerializedName(value = "isYoungDriver")
    private Boolean youngDriver;

    public CustomerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getYoungDriver() {
        return youngDriver;
    }

    public void setYoungDriver(Boolean youngDriver) {
        this.youngDriver = youngDriver;
    }
}
