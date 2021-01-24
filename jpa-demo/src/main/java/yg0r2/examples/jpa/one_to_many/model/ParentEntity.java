package yg0r2.examples.jpa.one_to_many.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import yg0r2.examples.jpa.Parent;

@Entity(name = "parent")
@Table(name = "parents")
public class ParentEntity implements Parent {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<ChildEntity> childs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
