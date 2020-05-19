package softtech.office.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import softtech.office.bean.SalaryinfoBean;
import softtech.office.bean.SalaryinfoSelectBean;
import softtech.office.dao.SalaryInfoDao;

@Component
public class SalaryinfoService {

	// 給料明細DAO
	@Autowired
	SalaryInfoDao salaryInfoDao;

	public SalaryinfoBean getSalaryinfo(String employeeID) {

		SalaryinfoBean ebean = new SalaryinfoBean();

		////　パラメータから貰った年月の当月を生成する
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar cl = Calendar.getInstance();
		String month = sdf.format(cl.getTime());

		//給料明細DAOを経由、ログイン者IDおよび当月文字列を持っち、当月分の給料データを取得する
		SalaryinfoSelectBean selectBean = new SalaryinfoSelectBean();
		selectBean.setEmployeeID(employeeID);
		selectBean.setMonth(month);

		ebean = salaryInfoDao.getSalaryInfo(selectBean);
		//rtns.add(ebean);

		return ebean;
	}

	public SalaryinfoBean getPreMonthSalaryinfo(String employeeID, String month) {

		SalaryinfoBean ebean = new SalaryinfoBean();

		//給料明細DAOを経由、ログイン者IDおよび前月文字列を持っち、前月分の給料データを取得する
		SalaryinfoSelectBean selectBean = new SalaryinfoSelectBean();
		selectBean.setEmployeeID(employeeID);
		selectBean.setPremonth(month);

		ebean = salaryInfoDao.getPreMonthSalaryinfo(selectBean);
		//rtns.add(ebean);

		return ebean;
	}

	public SalaryinfoBean getNextMonthSalaryinfo(String employeeID, String month) {

		SalaryinfoBean ebean = new SalaryinfoBean();

		//給料明細DAOを経由、ログイン者IDおよび次月文字列を持っち、次月分の給料データを取得する
		SalaryinfoSelectBean selectBean = new SalaryinfoSelectBean();
		selectBean.setEmployeeID(employeeID);
		selectBean.setNextmonth(month);

		ebean = salaryInfoDao.getNextMonthSalaryinfo(selectBean);
		//rtns.add(ebean);

		return ebean;
	}
}
