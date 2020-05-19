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
import softtech.office.bean.SalaryinfoBean;
import softtech.office.service.LoginService;
import softtech.office.service.SalaryinfoService;

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
	SalaryinfoService salaryinfoService;

	/**
	 *    ログイン画面初期処理
	 *       ログイン画面へ遷移する。
	 * @param  モデル
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		LoginBean loginbean = new LoginBean();
		model.addAttribute("loginbean", loginbean);
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
	public String login( @Valid @ModelAttribute("LoginBean") LoginBean loginbean,
                                       BindingResult result, Model model)
	{
          // 入力にエラーある場合、画面にエラーを表示する。
		  if(result.hasErrors()) {
			    model.addAttribute("errors", result.getFieldErrors());
			   return "login";
	      }

		  //Login処理
		  boolean rtnbl = loginService.doLogin(loginbean);

		  // ログイン成功。
		  if (rtnbl){
			  // 　給料明細の情報を取得する。
			  SalaryinfoBean  slrybean = new SalaryinfoBean();
			  slrybean = salaryinfoService.getSalaryinfo(loginService.getLoginID());

			  model.addAttribute("salaryinfo", slrybean);

			// 給料明細画面へ遷移。
			  return "salaryInfo";

		  //　ログイン失敗
		  } else {
			  // エラーメッセージを表示。
			  List<FieldError> lst = new ArrayList<FieldError>();
			  FieldError err1 = new FieldError("","" , "ログインは失敗しました。再ログインしてください。");
			  FieldError err2= new FieldError("","" , "またはシステム管理者へ連絡してください。");
			  lst.add(err1);
			  lst.add(err2);
			  model.addAttribute("errors",lst );
	           return "login";
	      }

	}
	/**
	 * パスワードを再設定
	 *
	 * @param loginbean　画面入力値　
	 * @param model　モデル
	 * @return  遷移先画面
	 */
	@RequestMapping(value = "login", params = "resetpswd", method = RequestMethod.POST)
    public String resetPassword(LoginBean loginbean,Model model) {

    	  List<FieldError> lst = new ArrayList<FieldError>();
		  FieldError err1 = new FieldError("","" , "只今工事中・・・");
		  lst.add(err1);
		  model.addAttribute("errors",lst );
          return "login";

    }

}