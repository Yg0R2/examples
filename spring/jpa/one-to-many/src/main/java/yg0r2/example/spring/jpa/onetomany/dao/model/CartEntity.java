package yg0r2.example.spring.jpa.onetomany.dao.model;

import yg0r2.example.spring.jpa.dao.model.ExampleEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carts")
public class CartEntity implements ExampleEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @JoinColumn(name = "item_id")
    @OneToMany(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    private List<ItemEntity> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

}
