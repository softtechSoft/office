package softtech.office.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import softtech.office.bean.EmployeeBean;
import softtech.office.service.EmployeeService;
/**
 * 使ってないクラス
 *
 * @author softtech
 */
@Controller
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@ModelAttribute
    public EmployeeBean setUpEmployeeBean() {
		EmployeeBean employeeBean = new EmployeeBean();
        return employeeBean;
    }

	@Autowired
	EmployeeService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		List<EmployeeBean> beans = service.getEmployee("1");
//		EmployeeBean ebean = beans.get(0);
//
//		model.addAttribute("employeeForm", ebean);
//
//		//return "employeeList";
//		return "login";
//
//	}
}
