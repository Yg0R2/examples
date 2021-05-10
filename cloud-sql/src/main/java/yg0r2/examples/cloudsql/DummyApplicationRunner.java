package yg0r2.examples.cloudsql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import yg0r2.examples.cloudsql.dao.model.DummyEntity;
import yg0r2.examples.cloudsql.dao.model.DummyRepository;

@Component
public class DummyApplicationRunner implements ApplicationRunner {

    private static final String DUMMY_ENTITY_NAME = "test";

    @Autowired
    private DummyRepository dummyRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DummyEntity dummy = dummyRepository.getEntityByName(DUMMY_ENTITY_NAME)
            .orElseGet(() -> dummyRepository.save(createTestDummy()));

        System.out.println(dummy);
    }

    private static DummyEntity createTestDummy() {
        DummyEntity dummy = new DummyEntity();

        dummy.setName(DUMMY_ENTITY_NAME);

        return dummy;
    }

}
