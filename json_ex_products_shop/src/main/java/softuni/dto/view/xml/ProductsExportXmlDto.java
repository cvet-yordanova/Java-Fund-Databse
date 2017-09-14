package softuni.dto.view.xml;

import softuni.dto.view.ProductViewDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsExportXmlDto {

    @XmlElement(name = "product")
    private List<ProductViewDto> productViewDtos;

    public List<ProductViewDto> getProductViewDtos() {
        return productViewDtos;
    }

    public void setProductViewDtos(List<ProductViewDto> productViewDtos) {
        this.productViewDtos = productViewDtos;
    }

    public ProductsExportXmlDto() {

    }
}
