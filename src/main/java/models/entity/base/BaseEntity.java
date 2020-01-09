package models.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof BaseEntity)) {
            return false;
        }
        return equals((BaseEntity)o);
    }
    public boolean equals(BaseEntity o){
        return getId() == o.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
