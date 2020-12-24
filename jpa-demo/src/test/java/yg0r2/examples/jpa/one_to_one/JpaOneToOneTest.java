package yg0r2.examples.jpa.one_to_one;

import org.springframework.beans.factory.annotation.Autowired;

import yg0r2.examples.jpa.one_to_one.model.ChildEntity;
import yg0r2.examples.jpa.one_to_one.model.ParentEntity;
import yg0r2.examples.jpa.one_to_one.repository.ChildRepository;
import yg0r2.examples.jpa.one_to_one.repository.ParentRepository;

class JpaOneToOneTest extends JpaBaseTest<ParentEntity, ChildEntity> {

    public JpaOneToOneTest(@Autowired ParentRepository parentRepository, @Autowired ChildRepository childRepository) {
        super(parentRepository, childRepository);
    }

    @Override
    protected ChildEntity createChild(ParentEntity parent) {
        ChildEntity child = new ChildEntity();

        child.setParent(parent);

        return child;
    }

    @Override
    protected ParentEntity createParent() {
        return new ParentEntity();
    }

}
