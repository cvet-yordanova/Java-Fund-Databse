package softuni.dto.export_agencies_by_town_xml_dto;


import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExportAgencyXmlDto {

    @XmlAttribute
    private String name;
//    @XmlAttribute
//    private BigDecimal profit;
    @XmlElementWrapper(name = "weddings")
    @XmlElement(name = "wedding")
    private List<ExportWeddingByTownXmlDto> weddings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "profit")
    public BigDecimal getProfit() {

        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        for (ExportWeddingByTownXmlDto wedding : weddings) {
            bigDecimal.add(wedding.CashAmount());
        }
        return bigDecimal;
    }

    //public void setProfit(BigDecimal profit) {
   //     this.profit = profit;
   // }

    public List<ExportWeddingByTownXmlDto> getWeddings() {
        return weddings;
    }

    public void setWeddings(List<ExportWeddingByTownXmlDto> weddings) {
        this.weddings = weddings;
    }
}
