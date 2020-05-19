package softtech.office.bean;

import lombok.Data;
/**
 * 社員情報モデル
 *
 * @author sofftech
 */
@Data
public class EmployeeBean {
	String employeeID;
	String employeeName;
	String password;
	String status;
	String sex;
	String age;
	String birthday;
	String joinedDate;
	String joinedTime;
	String postCode;
	String address;
	String phoneNumber;
	String authority;
	String mailAdress;
	String insertDate;
	String updateDate;
}
