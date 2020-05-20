package softtech.office.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

//@Data
public class ResetPasswordBean implements Serializable {
	// 社員ID
	@NotEmpty(message="社員IDを入力してください。")
	private String employeeID;

	//旧パスワード
	@NotEmpty(message="旧パスワードを入力してください。")
	private String oldPassword;

	//パスワード1
	@NotEmpty(message="パスワード1を入力してください。")
	private String password1;

	//パスワード2
	@NotEmpty(message="パスワード2を入力してください。")
	private String password2;

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
	 * @return oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword セットする oldPassword
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return password1
	 */
	public String getPassword1() {
		return password1;
	}

	/**
	 * @param password1 セットする password1
	 */
	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	/**
	 * @return password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2 セットする password2
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
