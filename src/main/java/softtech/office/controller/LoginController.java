package softtech.office.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import softtech.office.bean.SalaryinfoBean;
import softtech.office.service.EmployeeService;
import softtech.office.service.LoginService;
import softtech.office.service.SalaryinfoService;
import softtech.office.utily.OfficeUtily;

/**
 *  ログイン処理する。
 *
 * @author Softtech
 * @since  2019/10/1
 */
@Controller
public class LoginController {
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	SalaryinfoService salaryinfoService;

	/**
	 *    ログイン画面初期処理
	 *       ログイン画面へ遷移する。
	 * @param  モデル
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		LoginBean loginbean = new LoginBean();
		model.addAttribute("loginBean", loginbean);
		return "login";
	}

	/**
	 * ログイン処理
	 *
	 * @param loginbean　画面入力値　
	 * @param result　チェック結果
	 * @param model　モデル
	 * @return  遷移先画面
	 */
	@RequestMapping(value = "login", params = "login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			BindingResult result, Model model) {
		// 入力にエラーある場合、画面にエラーを表示する。
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors());
			return "login";
		}

		//Login処理
		boolean rtnbl = loginService.doLogin(loginBean);

		// ログイン成功。
		if (rtnbl) {
			// 　ログイン者の社員IDおよび当月を持っち給料詳細データを取得する
			SalaryinfoBean slrybean = salaryinfoService.getSalaryinfo(loginService.getLoginID());

			if (slrybean != null) {

				OfficeUtily officeUtily = new OfficeUtily();
				//データ変換処理
				String str = officeUtily.toDate(slrybean.getPaymentDate());
				slrybean.setPaymentDate(str);

				String strr = officeUtily.toDate1(slrybean.getMonth());
				slrybean.setMonth(strr);

				if (slrybean.getBase() != null) {
					slrybean.setBase(officeUtily.getCurrencyInstance(slrybean.getBase()));
				}
				if (slrybean.getOverTimePlus() != null) {
					slrybean.setOverTimePlus(officeUtily.getCurrencyInstance(slrybean.getOverTimePlus()));
				}
				if (slrybean.getShortageReduce() != null) {
					slrybean.setShortageReduce(officeUtily.getCurrencyInstance(slrybean.getShortageReduce()));
				}
				if (slrybean.getTransportExpense() != null) {
					slrybean.setTransportExpense(officeUtily.getCurrencyInstance(slrybean.getTransportExpense()));
				}
				if (slrybean.getAllowancePlus() != null) {
					slrybean.setAllowancePlus(officeUtily.getCurrencyInstance(slrybean.getAllowancePlus()));
				}
				if (slrybean.getAllowanceReduce() != null) {
					slrybean.setAllowanceReduce(officeUtily.getCurrencyInstance(slrybean.getAllowanceReduce()));
				}
				if (slrybean.getWelfareSelf() != null) {
					slrybean.setWelfareSelf(officeUtily.getCurrencyInstance(slrybean.getWelfareSelf()));
				}
				if (slrybean.getWelfareComp() != null) {
					slrybean.setWelfareComp(officeUtily.getCurrencyInstance(slrybean.getWelfareComp()));
				}
				if (slrybean.getWelfareBaby() != null) {
					slrybean.setWelfareBaby(officeUtily.getCurrencyInstance(slrybean.getWelfareBaby()));
				}
				if (slrybean.getEplyInsSelf() != null) {
					slrybean.setEplyInsSelf(officeUtily.getCurrencyInstance(slrybean.getEplyInsSelf()));
				}
				if (slrybean.getEplyInsComp() != null) {
					slrybean.setEplyInsComp(officeUtily.getCurrencyInstance(slrybean.getEplyInsComp()));
				}
				if (slrybean.getEplyInsWithdraw() != null) {
					slrybean.setEplyInsWithdraw(officeUtily.getCurrencyInstance(slrybean.getEplyInsWithdraw()));
				}
				if (slrybean.getRental() != null) {
					slrybean.setRental(officeUtily.getCurrencyInstance(slrybean.getRental()));
				}
				if (slrybean.getRentalMgmtFee() != null) {
					slrybean.setRentalMgmtFee(officeUtily.getCurrencyInstance(slrybean.getRentalMgmtFee()));
				}
				if (slrybean.getWithholdingTax() != null) {
					slrybean.setWithholdingTax(officeUtily.getCurrencyInstance(slrybean.getWithholdingTax()));
				}
				if (slrybean.getMunicipalTax() != null) {
					slrybean.setMunicipalTax(officeUtily.getCurrencyInstance(slrybean.getMunicipalTax()));
				}
				if (slrybean.getSum() != null) {
					slrybean.setSum(officeUtily.getCurrencyInstance(slrybean.getSum()));
				}
				//「前月」ボタン活性フラグを設定する
				model.addAttribute("preflg", true);
			} else {
				//詳細データが存在していない場合、エラーメッセージを表示する
				List<FieldError> lst = new ArrayList<FieldError>();
				FieldError err1 = new FieldError("", "", "新パスワードと再入力パスワードが一致しません。");
				lst.add(err1);
				model.addAttribute("errors", lst);
				slrybean = new SalaryinfoBean();
				//「前月」ボタン非活性フラグを設定する
				model.addAttribute("preflg", false);
			}
			model.addAttribute("salaryinfo", slrybean);
			model.addAttribute("nextflg", false);

			// 給料明細画面へ遷移。
			return "salaryInfo";

			//　ログイン失敗
		} else {
			// エラーメッセージを表示する
			List<FieldError> lst = new ArrayList<FieldError>();
			FieldError err1 = new FieldError("", "", "ログインは失敗しました。再ログインしてください。");
			FieldError err2 = new FieldError("", "", "またはシステム管理者へ連絡してください。");
			lst.add(err1);
			lst.add(err2);
			model.addAttribute("errors", lst);
//			LoginBean loginbean = new LoginBean();
//			loginbean.setEmployeeID(loginBean.getEmployeeID());
//			loginbean.setPassword(loginBean.getPassword());
//			model.addAttribute("loginBean", loginbean);
			return "login";
		}

	}

	/**
	 * パスワード変更
	 *
	 * @param loginbean　画面入力値　
	 * @param model　モデル
	 * @return  遷移先画面
	 */
	@RequestMapping(value = "login", params = "resetpswd", method = RequestMethod.POST)
	public String resetPassword(@ModelAttribute("loginBean") LoginBean loginBean,Model model) {

		//パスワード重置画面にメールアカウントの値を渡す
		ResetPasswordBean resetPwdBean = new ResetPasswordBean();
		resetPwdBean.setEmployeeID(loginBean.getEmployeeID());
		model.addAttribute("resetPasswordBean", resetPwdBean);

			// パスワード重置画面へ遷移
			return "resetPassword";

		/*
		List<FieldError> lst = new ArrayList<FieldError>();
		FieldError err1 = new FieldError("", "", "只今工事中・・・");
		lst.add(err1);
		model.addAttribute("errors", lst);
		return "login";
		*/
	}

}