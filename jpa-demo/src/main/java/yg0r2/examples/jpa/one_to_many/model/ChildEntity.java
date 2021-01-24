package yg0r2.examples.jpa.one_to_many.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import yg0r2.examples.jpa.Child;

@Entity(name = "child")
@Table(name = "childs")
public class ChildEntity implements Child {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @JoinColumn(name = "parent_id", nullable = false)
    @ManyToOne
    private ParentEntity parent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ParentEntity getParent() {
        return parent;
    }

    public void setParent(ParentEntity parent) {
        this.parent = parent;
    }

}
