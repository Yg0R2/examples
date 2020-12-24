package yg0r2.examples.jpa.one_to_one.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import yg0r2.examples.jpa.Parent;

@Entity(name = "parent")
@Table(name = "parents")
public class ParentEntity implements Parent {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ChildEntity child;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ChildEntity getChild() {
        return child;
    }

    public void setChild(ChildEntity child) {
        this.child = child;
    }

}
