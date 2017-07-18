import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entities.Department;
import entities.Employee;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Object[]> q = entityManager.createQuery("SELECT e.department.name,max(e.salary) FROM Employee AS e " +
                "GROUP BY e.department.id HAVING max(e.salary) NOT BETWEEN 30000 AND 70000", Object[].class);
        List<Object[]> resultList = q.getResultList();
        Map<String,BigDecimal> resultMap = new HashMap<>(resultList.size());

        for (Object[] result : resultList) {
            resultMap.put((String)result[0],new BigDecimal(result[1].toString()));
        }

        for (Map.Entry s : resultMap.entrySet()) {
            System.out.printf("%s - $%.2f\n",
                    s.getKey(),
                    s.getValue());
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
