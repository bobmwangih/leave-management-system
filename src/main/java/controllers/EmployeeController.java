package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDao;
import models.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/ask-to-apply")
	public ModelAndView askToApply(HttpServletRequest request,HttpServletResponse response) {
		String employeeId = request.getParameter("employeeId");
		//System.out.println(employeeId);
		ModelAndView mav = new ModelAndView();
		Employee employee = employeeDao.getEmployee(employeeId);
		if(employee != null) {
			mav.setViewName("applicationForm.jsp");
			mav.addObject("employee", employee);
			return mav;	
		}
		else {
			mav.setViewName("index.jsp");
			mav.addObject("employeeId", employeeId);
			return mav;
		}
			
	}
	
}
