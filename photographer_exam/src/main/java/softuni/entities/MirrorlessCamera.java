package softuni.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mirrorless_camera")
public class MirrorlessCamera extends Camera{

    private String maxVideoResolution;
    private Integer maxFrameRate;

    public MirrorlessCamera(String maxVideoResolution, Integer maxFrameRate) {
        this.maxVideoResolution = maxVideoResolution;
        this.maxFrameRate = maxFrameRate;
    }

    public MirrorlessCamera() {
    }

    @Column(name = "max_video_resolution", columnDefinition = "text")
    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    @Column(name = "max_frame_rate")
    public Integer getMaxFrameRate() {
        return maxFrameRate;
    }

    public void setMaxFrameRate(Integer maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}
