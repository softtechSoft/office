package softtech.office.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.LoginBean;
import softtech.office.dao.SararyInfoDao;
import softtech.office.service.EmployeeService;
import softtech.office.service.LoginService;

/**
 *
 * @author ソフトテク
 *
 */
@Controller
//スタティックログクラス
public class ResetPasswordController {

	private static final Logger logger = LoggerFactory.getLogger(ResetPasswordController.class);

	@Autowired
	public SararyInfoDao imp;

	//
	@ModelAttribute
	public EmployeeBean setUpEmployeeBean() {
		EmployeeBean form = new EmployeeBean();
		return form;
	}

	@Autowired
	EmployeeService service;

	@Autowired
	LoginService loginService;


	//パスワード変更
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPassword(@ModelAttribute("LoginBean") LoginBean loginbean,Model model) {

//        if(service.resetPassword(loginbean)){
//
//            model.addAttribute("employeeID", loginbean.getEmployeeID());

            return "resetPassword";
//        }else {
//            model.addAttribute("errors", "パスワード変更失敗");
//            return "login";
//        }

    }

//	return "login";
//	}


	public SararyInfoDao getImp() {
		return imp;
	}

	public void setImp(SararyInfoDao imp) {
		this.imp = imp;
	}
}