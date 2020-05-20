package softtech.office.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import softtech.office.bean.LoginBean;
import softtech.office.bean.ResetPasswordBean;
import softtech.office.service.EmployeeService;
import softtech.office.service.LoginService;

/**
 *パスワードを変更する画面
 * @author ソフトテク
 *
 */
@Controller
public class ResetPasswordController {

	private static final Logger logger = LoggerFactory.getLogger(ResetPasswordController.class);

	@Autowired
	EmployeeService employeeService;

	@Autowired
	LoginService loginService;

	//パスワード変更
	@RequestMapping(value = "doRest", method = RequestMethod.POST)
    public String doRest( @Valid @ModelAttribute("ResetPasswordBean") ResetPasswordBean resetPasswordBean,
    		BindingResult result,Model model) {

		// 入力にエラーある場合、画面にエラーを表示する。
		  if(result.hasErrors()) {
			    model.addAttribute("errors", result.getFieldErrors());
			   return "resetPassword";
	      }
		  //不一致判断
		  if(!resetPasswordBean.getPassword1().equals(resetPasswordBean.getPassword2())) {
			// エラーメッセージを表示。
			  List<FieldError> lst = new ArrayList<FieldError>();
			  FieldError err1 = new FieldError("","" , "新パスワードは一致していません。再入力してください。");
			  lst.add(err1);
			  model.addAttribute("errors",lst );
			  return "resetPassword";
		  }
          //存在チェック
		  LoginBean loginbean = new LoginBean();
		  loginbean.setEmployeeID(resetPasswordBean.getEmployeeID());
		  loginbean.setPassword(resetPasswordBean.getOldPassword());
		  boolean rtnbl = loginService.doLogin(loginbean);
		  //パスワードをリセットする
          if (rtnbl) {
        	  employeeService.resetPassword(resetPasswordBean);
          }
            return "login";

    }
}