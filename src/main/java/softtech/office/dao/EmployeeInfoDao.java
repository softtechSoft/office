package softtech.office.dao;

import softtech.office.bean.EmployeeBean;

/**
 *社員情報DAO
 *
 * @author softtech
 */
public interface EmployeeInfoDao {
	EmployeeBean getEmployee(String mailAdress);
	void resetPassword(String mailAddress,String oldPaswd,String newPaswd);
}
