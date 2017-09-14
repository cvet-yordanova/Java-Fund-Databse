package softuni.dto;


import org.modelmapper.ModelMapper;
import softuni.model.Employee;

import java.util.ArrayList;
import java.util.List;


public final class DtoMappingUtil {

    private static ModelMapper mapper = new ModelMapper();

    private DtoMappingUtil(){};

    public static EmployeeDto convertEmployee(Employee employee){
        return mapper.map(employee, EmployeeDto.class);
    }

    public static Employee convertToEmployee(EmployeeDto employeeDto){
        return mapper.map(employeeDto, Employee.class);
    }

    public static <S,D> D convert(S source, Class<D> destClass){
        return mapper.map(source, destClass);
    }
    public static <S,D> List<D> convert(Iterable<S> sources, Class<D> destClass){
                List<D> resultList = new ArrayList<D>();

        for (S source : sources) {
            D d = convert(source,destClass);
            resultList.add(d);
        }

        return resultList;
    }

}
