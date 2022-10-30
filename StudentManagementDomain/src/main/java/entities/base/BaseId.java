package entities.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@MappedSuperclass
public abstract class BaseId {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    public BaseId(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
