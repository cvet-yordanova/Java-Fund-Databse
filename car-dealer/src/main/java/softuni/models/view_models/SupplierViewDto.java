package softuni.models.view_models;


import com.google.gson.annotations.Expose;

public class SupplierViewDto {

    @Expose
    private Long id;

    @Expose
    private String name;

    @Expose
    private Integer countParts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountParts() {
        return countParts;
    }

    public void setCountParts(Integer countParts) {
        this.countParts = countParts;
    }
}
