package softtech.office.dao;

import softtech.office.bean.SalaryinfoBean;
import softtech.office.bean.SalaryinfoSelectBean;

public interface SalaryInfoDao {

	SalaryinfoBean getSalaryInfo(SalaryinfoSelectBean para);

	SalaryinfoBean getPreMonthSalaryinfo(SalaryinfoSelectBean para);

	SalaryinfoBean getNextMonthSalaryinfo(SalaryinfoSelectBean para);
}
