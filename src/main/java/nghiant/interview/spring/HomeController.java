package nghiant.interview.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import nghiant.interview.business.SchoolManager;
import nghiant.interview.entity.Batch;
import nghiant.interview.entity.Student;
import nghiant.interview.model.AddBatchModel;
import nghiant.interview.model.SchoolModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private SchoolManager schoolManager;

    @RequestMapping(value = "/addBatch")
    public ModelAndView addBatch(AddBatchModel addBatchModel) {
	ModelAndView mav = new ModelAndView("addBatch", "model", addBatchModel);
	Batch batch = addBatchModel.getBatch();
	if (batch == null) {
	    addBatchModel.setBatch(new Batch());
	    addBatchModel.setStudent(new Student());
	} else {
	    Student student = addBatchModel.getStudent();
	    schoolManager.addBatch(batch, student);
	}
	return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView getLstStudentByIdBatch(Locale locale, Model model, SchoolModel schoolModel, @RequestParam(value = "selectedBatch.id", required = true) String idBath) {
	logger.info("Id batch is:" + idBath);
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

	String formattedDate = dateFormat.format(date);

	model.addAttribute("serverTime", formattedDate);
	schoolManager.getBatchInfo(schoolModel);
	ModelAndView mav = new ModelAndView("home", "model", schoolModel);
	return mav;
    }

    public SchoolManager getSchoolManager() {
	return schoolManager;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model, SchoolModel schoolModel) {
	logger.info("Welcome home! The client locale is {}.", locale);

	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

	String formattedDate = dateFormat.format(date);

	model.addAttribute("serverTime", formattedDate);
	schoolManager.getBatchInfo(schoolModel);
	ModelAndView mav = new ModelAndView("home", "model", schoolModel);
	return mav;
    }

    public void setSchoolManager(SchoolManager schoolManager) {
	this.schoolManager = schoolManager;
    }

}
