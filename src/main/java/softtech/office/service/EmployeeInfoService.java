package softtech.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.ResetPasswordBean;
import softtech.office.dao.EmployeeInfoDao;


@Component
public class EmployeeInfoService {
	@Autowired
	EmployeeInfoDao employeeInfoDao;

	EmployeeBean employeeBean ;

	// 社員情報
	ResetPasswordBean resetPasswordBean;

	/**
	 * ログイン処理
	 *
	 * @param ResetPasswordBean ログイン画面の入力情報
	 * @return ログイン結果。TRUE：ログイン成功、FALSE：ログイン失敗。
	 * @author Softtech
	 */
	public boolean resetLogin(ResetPasswordBean resetPasswordBean) {
		  //　社員情報を取得する
		  employeeBean = new EmployeeBean();
		  employeeBean = employeeInfoDao.getEmployeeOldPwd(resetPasswordBean.getEmployeeID());

		   if(employeeBean !=null) {
	           if(employeeBean.getPassword() != null) {
	        	   // パスワード変更画面に入力した旧パスワードとDBに登録したパスワードと一致する場合、ログイン成功。
	        	   if( (employeeBean.getPassword().equals(resetPasswordBean.getOldPassword()))) {
	        		   		return true;
        	   } else {
        		   return false;
        	   }
           } else {
        	   return false;
           }
	   } else {
		   return false;
	   }

	}

	public ResetPasswordBean setNewPassword(String employeeID,String newPasswordConfirm) {
		ResetPasswordBean rBean = new ResetPasswordBean();
		employeeBean = new EmployeeBean();
		String password = newPasswordConfirm;
		employeeBean.setEmployeeID(employeeID);
		employeeBean.setPassword(password);

		//社員情報DAOを経由、ログイン者IDを持っち、社員情報データを取得する

		rBean = employeeInfoDao.setNewPassword(employeeBean);
		return rBean;
	}


	/**
	 * ログイン処理
	 *
	 * @param ResetPasswordBean ログイン画面の入力情報
	 * @return ログイン結果。TRUE：ログイン成功、FALSE：ログイン失敗。
	 * @author Softtech
	 */
	public String resetLoginID() {
		if (employeeBean == null) {
			return "";
		} else {
			return employeeBean.getEmployeeID();
		}
	}
//	public boolean resetPassword(LoginBean loginbean) {
//		// TODO 自動生成されたメソッド・スタブ
//
//		return false;
//	}



}

