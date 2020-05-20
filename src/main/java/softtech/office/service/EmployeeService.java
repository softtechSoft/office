package softtech.office.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.ResetPasswordBean;
import softtech.office.dao.EmployeeInfoDao;


@Component
public class EmployeeService {

	@Autowired
	EmployeeInfoDao employeeDao;

	public List<EmployeeBean> getEmployee(String employeeID) {

		EmployeeBean ebean = new  EmployeeBean();
		List<EmployeeBean> rtns = new ArrayList<EmployeeBean>();

		//List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM employee");
		//ebean.setEmployeeNo(list.get(0).get("name").toString());
		rtns.add(ebean);

		return rtns;
	}

	public boolean resetPassword(ResetPasswordBean resetPasswordBean) {

		return false;
	}
}

