package softuni.dto.xmlDTOs;

import softuni.dto.binding.add.CategoryAddDto;
import softuni.entites.Category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesImporDtoXml {

    @XmlElement(name = "category")
    private List<CategoryAddDto> categories;

    public CategoriesImporDtoXml(List<CategoryAddDto> categories) {
        this.categories = categories;
    }

    public CategoriesImporDtoXml() {
    }

    public List<CategoryAddDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryAddDto> categories) {
        this.categories = categories;
    }
}
