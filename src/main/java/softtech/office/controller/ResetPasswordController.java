package softtech.office.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.LoginBean;
import softtech.office.bean.ResetPasswordBean;
import softtech.office.dao.SalaryInfoDao;
import softtech.office.service.EmployeeInfoService;
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
	public SalaryInfoDao imp;

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
	EmployeeBean employeeBean ;
	LoginBean loginBean ;
	@Autowired
	EmployeeInfoService resetPwdService;

	//パスワード変更
	@RequestMapping(value = "resetPassword", params = "reset", method = RequestMethod.POST)
    public String resetPassword(@Validated @ModelAttribute("ResetPasswordBean") ResetPasswordBean resetPasswordBean,BindingResult result, Model model) {
		// 入力にエラーある場合、画面にエラーを表示する。
			if (result.hasErrors()) {
				model.addAttribute("errors", result.getFieldErrors());
				return "resetPassword";
			}

			//Login処理
			boolean rtnbl = resetPwdService.resetLogin(resetPasswordBean);

			// ログイン成功。
			if (rtnbl) {
				if(resetPasswordBean.getNewPassword().equals(resetPasswordBean.getNewPasswordConfirm())) {

				ResetPasswordBean setPwdBean = new ResetPasswordBean();

				setPwdBean = resetPwdService.setNewPassword(resetPwdService.resetLoginID(),resetPasswordBean.getNewPasswordConfirm());
				model.addAttribute("employeeBean", setPwdBean);


				//パスワード変更成功メッセージ表示
				List<FieldError> lst = new ArrayList<FieldError>();
				FieldError err = new FieldError("", "", "パスワード変更しました！");
				lst.add(err);
				model.addAttribute("errors", lst);

				}else {
					// エラーメッセージを表示する
					List<FieldError> lst = new ArrayList<FieldError>();
					FieldError err = new FieldError("", "", "新パスワードと再入力パスワードが一致しません。");
					lst.add(err);
					model.addAttribute("errors", lst);
					//
					ResetPasswordBean resetPwdBean = new ResetPasswordBean();
					resetPwdBean.setEmployeeID(resetPasswordBean.getEmployeeID());
					resetPwdBean.setOldPassword(resetPasswordBean.getOldPassword());
					model.addAttribute("resetPasswordBean", resetPwdBean);
					return "resetPassword";
				}

				return "login";

			} else {
				// エラーメッセージを表示する
				List<FieldError> lst = new ArrayList<FieldError>();
				FieldError err1 = new FieldError("", "", "ログインは失敗しました。再ログインしてください。");
				FieldError err2 = new FieldError("", "", "またはシステム管理者へ連絡してください。");
				lst.add(err1);
				lst.add(err2);
				model.addAttribute("errors", lst);

				return "resetPassword";
			}

	}

//        if(service.resetPassword(loginbean)){
//
//            model.addAttribute("employeeID", loginbean.getEmployeeID());
//
//            return "resetPassword";
//        }else {
//            model.addAttribute("errors", "パスワード変更失敗");
//            return "login";




	public SalaryInfoDao getImp() {
		return imp;
	}

	public void setImp(SalaryInfoDao imp) {
		this.imp = imp;
	}
}