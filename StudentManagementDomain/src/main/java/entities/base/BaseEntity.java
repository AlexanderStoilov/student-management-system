package entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends BaseId {

    private String name;

    public BaseEntity(){
        super();
    }

    public BaseEntity(String name){
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}