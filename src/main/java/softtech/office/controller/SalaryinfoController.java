package softtech.office.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import softtech.office.bean.LoginBean;
import softtech.office.bean.SalaryinfoBean;
import softtech.office.dao.SalaryInfoDao;
import softtech.office.service.LoginService;
import softtech.office.service.SalaryinfoService;
import softtech.office.utily.OfficeUtily;

@Controller
public class SalaryinfoController {
	@Autowired
	SalaryinfoService salaryinfoService;
	@Autowired
	LoginService loginService;
	@Autowired
	SalaryInfoDao salaryInfoDao;

	/**
	 *  ログアウトして、ログイン画面へ遷移する。
	 *
	 *＠param salaryinfoBean　給料明細画面データ
	 *＠param model モデル
	 *@return ログイン画面
	 */
	@RequestMapping(value = "doSalary", params = "logout", method = RequestMethod.POST)
	public String logout(SalaryinfoBean salaryinfoBean, Model model) {
		LoginBean loginbean = new LoginBean();
		model.addAttribute("loginBean", loginbean);
		return "login";

	}

	/**
	 *  前月給料明細を表示する。
	 *
	 *＠param salaryinfoBean　給料明細画面データ
	 *＠param model モデル
	 *@return ログイン画面
	 */

	@RequestMapping(value = "doSalary", params = "lastmth_btn", method = RequestMethod.POST)
	public String getPreMonth(SalaryinfoBean salaryinfoBean, Model model) {

		// 画面上の年月を取得する
		String month = salaryinfoBean.getMonth();

		//　パラメータから貰った年月の前月を生成する
		OfficeUtily officeUtily = new OfficeUtily();
		String strDate = officeUtily.toYYYYMM(month);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		Calendar cl = Calendar.getInstance();
		try {
			Date date = dateFormat.parse(strDate);
			cl.setTime(date);
			cl.add(Calendar.MONTH, -1);

		} catch (ParseException e) {
			// 運用時に発生しない例外ですので、なにもしません
			e.printStackTrace();
		}
		String premonth = dateFormat.format(cl.getTime());

		// ログイン者の社員IDおよび前月を持っち給料詳細データを取得する
		SalaryinfoBean slrybean = salaryinfoService.getPreMonthSalaryinfo(loginService.getLoginID(), premonth);

		if (slrybean != null) {

			//データ変換処理
			String str = officeUtily.toDate(slrybean.getPaymentDate());
			slrybean.setPaymentDate(str);

			String strr1 = officeUtily.toDate1(slrybean.getMonth());
			slrybean.setMonth(strr1);
			//
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
			String strr = officeUtily.toDate1(premonth);
			List<FieldError> lst = new ArrayList<FieldError>();
			FieldError err1 = new FieldError("", "", strr + "の給料データはありません。");
			lst.add(err1);
			model.addAttribute("errors", lst);
			slrybean = new SalaryinfoBean();
			slrybean.setMonth(strr);
			//「前月」ボタン非活性フラグを設定する
			model.addAttribute("preflg", false);
		}

		model.addAttribute("salaryinfo", slrybean);
		model.addAttribute("nextflg", true);

		// 給料明細画面へ遷移。
		return "salaryInfo";

	}

	/**
	 *  次月給料明細を表示する。
	 *
	 *＠param salaryinfoBean　給料明細画面データ
	 *＠param model モデル
	 *@return ログイン画面
	 */

	@RequestMapping(value = "doSalary", params = "nextmth_btn", method = RequestMethod.POST)
	public String getNextMonth(SalaryinfoBean salaryinfoBean, Model model) {

		// 画面上の年月を取得する
		String month = salaryinfoBean.getMonth();

		//　パラメータから貰った年月の次月を生成する
		OfficeUtily officeUtily = new OfficeUtily();
		String strDate = officeUtily.toYYYYMM(month);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		Calendar cl = Calendar.getInstance();
		try {
			Date date = dateFormat.parse(strDate);
			cl.setTime(date);
			cl.add(Calendar.MONTH, 1);

		} catch (ParseException e) {
			// 運用時に発生しない例外ですので、なにもしません
			e.printStackTrace();
		}
		String nextmonth = dateFormat.format(cl.getTime());

		// 　ログイン者の社員IDおよび次月を持っち給料詳細データを取得する
		SalaryinfoBean slrybean = salaryinfoService.getNextMonthSalaryinfo(loginService.getLoginID(), nextmonth);

		if (slrybean != null) {

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
			//「前月」ボタン非活性フラグを設定する
			model.addAttribute("preflg", true);
			//「次月」ボタン活性フラグを設定する
			model.addAttribute("nextflg", true);

		} else {
			//詳細データが存在していない場合、エラーメッセージを表示する
			String strr = officeUtily.toDate1(nextmonth);
			List<FieldError> lst = new ArrayList<FieldError>();
			FieldError err1 = new FieldError("", "", strr + "の給料データはありません。");
			lst.add(err1);
			model.addAttribute("errors", lst);
			slrybean = new SalaryinfoBean();
			slrybean.setMonth(strr);
			//「前月」ボタン非活性フラグを設定する
			model.addAttribute("preflg", true);
			//「次月」ボタン非活性フラグを設定する
			model.addAttribute("nextflg", false);

		}

		model.addAttribute("salaryinfo", slrybean);

		// 給料明細画面へ遷移。
		return "salaryInfo";

	}

}
