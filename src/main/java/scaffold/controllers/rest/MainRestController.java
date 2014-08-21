package scaffold.controllers.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scaffold.controllers.main.InputFormBean;
import scaffold.data.dao.TestEntityDao;
import scaffold.data.entity.TestEntity;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MainRestController {

    @Inject
    private TestEntityDao testEntityDao;

    @RequestMapping(value = "/add",  method = RequestMethod.PUT)
    public void addNewEntry(@RequestBody InputFormBean inputBean) {
        TestEntity newEntity = new TestEntity();
        newEntity.setName(inputBean.getName());
        testEntityDao.create(newEntity);
    }

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    private List<TestEntity> getAllData() {
        return testEntityDao.getAll();
    }
}
