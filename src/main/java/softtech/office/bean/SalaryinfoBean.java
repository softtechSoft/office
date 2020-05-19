package softtech.office.bean;

import lombok.Data;

/**
 *  給料明細クラス
 */
@Data
public class SalaryinfoBean {
	String employeeName;
	String address;
	String month;
	String paymentDate;
	String base;
	String overTimePlus;
	String shortageReduce;
	String transportExpense;
	String allowancePlus;
	String allowanceReduce;
	String allowanceReason;
	String welfare;
	String withholdingTax;
	String municipalTax;
	String sum;
	String deleteFlg;
	String insertDate;
	String updateDate;
}