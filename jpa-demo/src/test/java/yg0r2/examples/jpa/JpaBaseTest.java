package yg0r2.examples.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class JpaBaseTest<P extends Parent, C extends Child> {

    private final ChildRepository<C> childRepository;
    private final ParentRepository<P> parentRepository;

    public JpaBaseTest(ParentRepository<P> parentRepository, ChildRepository<C> childRepository) {
        this.childRepository = childRepository;
        this.parentRepository = parentRepository;
    }

    protected abstract C createChild(P parent);

    protected abstract P createParent();

    @BeforeEach
    void setUp() {
        P parent = parentRepository.save(createParent());

        childRepository.save(createChild(parent));
    }

    @AfterEach
    @BeforeAll
    void tearDown() {
        parentRepository.deleteAll();
        childRepository.deleteAll();
    }

    @Test
    void testDeleteParent() {
        parentRepository.deleteAll();

        assertEquals(0, parentRepository.findAll().size());
        assertEquals(0, childRepository.findAll().size());
    }

    @Test
    void testDeleteUserProfile() {
        childRepository.deleteAll();

        assertEquals(1, parentRepository.findAll().size());
        assertEquals(0, childRepository.findAll().size());
    }

}
