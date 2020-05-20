package softtech.office.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginBean implements Serializable {
	// 社員ID
	@NotEmpty(message="社員IDを入力してください。")
	private String employeeID;

	//パスワード
	@NotEmpty(message="パスワードを入力してください。")
	private String password;

	/**
	 * @return employeeID
	 */
	public String getEmployeeID() {
		return employeeID;
	}
	/**
	 * @param employeeID セットする employeeID
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
