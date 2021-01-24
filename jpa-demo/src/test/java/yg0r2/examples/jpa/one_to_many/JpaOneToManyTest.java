package yg0r2.examples.jpa.one_to_many;

import org.springframework.beans.factory.annotation.Autowired;

import yg0r2.examples.jpa.JpaBaseTest;
import yg0r2.examples.jpa.one_to_many.model.ChildEntity;
import yg0r2.examples.jpa.one_to_many.model.ParentEntity;
import yg0r2.examples.jpa.one_to_many.repository.ChildRepository;
import yg0r2.examples.jpa.one_to_many.repository.ParentRepository;

class JpaOneToManyTest extends JpaBaseTest<ParentEntity, ChildEntity> {

    public JpaOneToManyTest(@Autowired ParentRepository parentRepository, @Autowired ChildRepository childRepository) {
        super(parentRepository, childRepository);
    }

    @Override
    protected ChildEntity createChild(ParentEntity parent) {
        ChildEntity childEntity = new ChildEntity();

        childEntity.setParent(parent);

        return childEntity;
    }

    @Override
    protected ParentEntity createParent() {
        return new ParentEntity.Builder().build();
    }

}
