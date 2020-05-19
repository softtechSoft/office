package softtech.office.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import softtech.office.bean.SalaryinfoBean;
import softtech.office.bean.SalaryinfoSelectBean;
import softtech.office.dao.SararyInfoDao;

@Component
public class SalaryinfoService {

	// 給料明細DAO
	@Autowired
	SararyInfoDao sararyInfoDao;

	public SalaryinfoBean getSalaryinfo(String employeeID) {

		SalaryinfoBean ebean = new  SalaryinfoBean();
		// 当月を作成
		//Calendarクラスのオブジェクトを生成する
		 Calendar cl = Calendar.getInstance();
		 //SimpleDateFormatクラスでフォーマットパターンを設定する
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String month = sdf.format(cl.getTime());

		SalaryinfoSelectBean selectBean = new SalaryinfoSelectBean();
		selectBean.setEmployeeID(employeeID);
		selectBean.setMonth(month);

		ebean  = sararyInfoDao.getSalaryInfo(selectBean);
		//rtns.add(ebean);

		return ebean;
	}
}

