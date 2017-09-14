package softuni.dto.import_picture_json;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ImportPictureJsonDto {

    @Expose
    private String path;

    @Expose
    private BigDecimal size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }
}
