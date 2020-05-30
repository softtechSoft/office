package softtech.office.dao;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.ResetPasswordBean;

/**
 *社員情報DAO
 *
 * @author softtech
 */
public interface EmployeeInfoDao {
	EmployeeBean getEmployee(String mailAdress);

	EmployeeBean getEmployeeOldPwd(String string);

	EmployeeBean setNewPassword(String string);

	ResetPasswordBean setNewPassword(EmployeeBean employeeBean);

}
