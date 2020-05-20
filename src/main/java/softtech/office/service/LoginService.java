package softtech.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.LoginBean;
import softtech.office.dao.EmployeeInfoDao;

@Service
public class LoginService  {

	// 社員情報DAO
	@Autowired
	EmployeeInfoDao employee;

	// 社員情報
	EmployeeBean employeeBean ;
	/**
	 * ログイン処理
	 *
	 * @param loginBean ログイン画面の入力情報
	 * @return ログイン結果。TRUE：ログイン成功、FALSE：ログイン失敗。
	 * @author Softtech
	 */
	public boolean doLogin(LoginBean loginBean) {
		  //　社員情報を取得する
		  employeeBean = new EmployeeBean();
		  employeeBean = employee.getEmployee(loginBean.getEmployeeID());

		   if(employeeBean !=null) {
	           if(employeeBean.getPassword() != null) {
	        	   // ログイン画面に入力したパスワードとDBに登録したパスワードと一致する場合、ログイン成功。
	        	   if( employeeBean.getPassword().equals(loginBean.getPassword())) {
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
	/**
	 * ログイン処理
	 *
	 * @param loginBean ログイン画面の入力情報
	 * @return ログイン結果。TRUE：ログイン成功、FALSE：ログイン失敗。
	 * @author Softtech
	 */
	public String getLoginID() {
		if (employeeBean == null) {
			return "";
		} else {
			return employeeBean.getEmployeeID();
		}
	}
}

