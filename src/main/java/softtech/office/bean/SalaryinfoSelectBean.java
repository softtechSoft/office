package softtech.office.bean;

/**
 *  給料明細クラス
 */

public class SalaryinfoSelectBean {
	String employeeID;
	String month;
	String premonth;
	String nextmonth;

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
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month セットする month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return premonth
	 */
	public String getPremonth() {
		return premonth;
	}
	/**
	 * @param premonth セットする nxtmonth
	 */
	public void setPremonth(String premonth) {
		this.premonth = premonth;
	}
	/**
	 * @return nextmonth
	 */
	public String getNextmonth() {
		return nextmonth;
	}
	/**
	 * @param nextmonth セットする nextmonth
	 */
	public void setNextmonth(String nextmonth) {
		this.nextmonth = nextmonth;
	}

}