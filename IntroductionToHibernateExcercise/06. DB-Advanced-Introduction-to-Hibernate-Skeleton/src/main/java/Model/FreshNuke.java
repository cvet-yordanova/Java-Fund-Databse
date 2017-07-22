package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "fn")
public class FreshNuke extends BasicShampoo{


}
