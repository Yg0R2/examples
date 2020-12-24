package yg0r2.examples.jpa.one_to_one.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import yg0r2.examples.jpa.Child;

@Entity(name = "child")
@Table(name = "childs")
public class ChildEntity implements Child {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @JoinColumn(name = "parent_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
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
