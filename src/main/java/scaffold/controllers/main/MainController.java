package scaffold.controllers.main;

import scaffold.controllers.main.InputFormBean;
import scaffold.data.entity.TestEntity;
import scaffold.data.dao.TestEntityDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Inject
    private TestEntityDao testEntityDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView displayForm(@ModelAttribute("inputBean") InputFormBean inputBean) {
        ModelAndView mav = new ModelAndView("main");
        return mav;
    }

    @RequestMapping(value = "/add",  method = RequestMethod.POST)
    public ModelAndView addNewEntry(@ModelAttribute("inputBean") InputFormBean inputBean) {
		TestEntity newEntity = new TestEntity();
		newEntity.setName(inputBean.getName());
        testEntityDao.create(newEntity);
        return displayForm(inputBean);
    }

    @RequestMapping(value = "/out", method = RequestMethod.GET)
    private ModelAndView displayAllData() {
        ModelAndView mav = new ModelAndView("display");
        List<TestEntity> allData = testEntityDao.getAll();
        mav.addObject("data",allData);
        return mav;
    }
}
