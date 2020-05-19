package softtech.office.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import softtech.office.bean.LoginBean;
import softtech.office.bean.SalaryinfoBean;

@Controller
public class SalaryinfoController {

	/**
	 *  ログアウトして、ログイン画面へ遷移する。
	 *
	 *＠param salaryinfoBean　給料明細画面データ
	 *＠param model モデル
	 *@return ログイン画面
	 */
	@RequestMapping(value = "doSalary", method = RequestMethod.POST)
    public String doSalary(SalaryinfoBean salaryinfoBean, Model model) {
		LoginBean loginbean = new LoginBean();
		model.addAttribute("loginBean", loginbean);
		return "login";
	}

}
