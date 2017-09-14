package softuni.dto;


import softuni.entities.Lens;

import java.util.List;

public class LensesDto {
    private List<Lens> lens;

    public List<Lens> getLens() {
        return lens;
    }

    public void setLens(List<Lens> lens) {
        this.lens = lens;
    }
}
