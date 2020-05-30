package softtech.office.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
//import org.terasoluna.gfw.common.validator.constraints.Compare;

/**
 *  社員情報パスワード変更クラス
 */
//@Confirm(field = "newPassword", confirmField = "newPasswordConfirm")
public class ResetPasswordBean implements Serializable {
	private static final long serialVersionUID = 1L;

	// メールアカウント
	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$",message = "正しいメールアドレスを入力してください。")
	@NotEmpty(message="メールアカウントを入力してください。")
	private String employeeID;

	//旧パスワード
	@NotEmpty(message="旧パスワードを入力してください。")
	private String oldPassword;

	//新しいパスワード
	@NotEmpty(message="新パスワードを入力してください。")
	@Size(min = 3,max = 20,message="パスワードは{min}文字以上{max}文字以下です。")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "入力された値は正しくありません。半角英数字の形式で入力してください。")
	private String newPassword;

	//新しいパスワード（確認）
	private String newPasswordConfirm;

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
	 * @return 旧パスワード
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * @param 旧パスワード セットする
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**
	 * @return 新パスワード
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param 新パスワード セットする
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return 新パスワード（再入力）
	 */
	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}
	/**
	 * @param 新パスワード（再入力）セットする
	 */
	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}

}