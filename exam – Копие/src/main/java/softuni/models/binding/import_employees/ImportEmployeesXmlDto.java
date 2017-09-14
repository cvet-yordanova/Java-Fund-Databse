package softuni.models.binding.import_employees;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportEmployeesXmlDto {

    @XmlElement(name = "employee")
    private List<ImportEmployeeXmlDto> importEmployeeXmlDtos;

    public List<ImportEmployeeXmlDto> getImportEmployeeXmlDtos() {
        return importEmployeeXmlDtos;
    }

    public void setImportEmployeeXmlDtos(List<ImportEmployeeXmlDto> importEmployeeXmlDtos) {
        this.importEmployeeXmlDtos = importEmployeeXmlDtos;
    }
}
