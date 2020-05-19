package softtech.office.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import softtech.office.bean.EmployeeBean;
import softtech.office.bean.LoginBean;


@Component
public class EmployeeService {

	public List<EmployeeBean> getEmployee(String employeeID) {

		EmployeeBean ebean = new  EmployeeBean();
		List<EmployeeBean> rtns = new ArrayList<EmployeeBean>();

		//List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM employee");
		//ebean.setEmployeeNo(list.get(0).get("name").toString());
		rtns.add(ebean);

		return rtns;
	}

	public boolean resetPassword(LoginBean loginbean) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}

