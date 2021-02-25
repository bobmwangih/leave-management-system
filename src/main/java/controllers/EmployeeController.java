package controllers;

import java.util.Objects;

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
	
	
//entry handler mapping for an actor: Applicant	
	@RequestMapping("/ask-to-apply")
	public ModelAndView askToApply(HttpServletRequest request,HttpServletResponse response) {
		String employeeId = request.getParameter("employeeId");
		System.out.println(employeeId);
		ModelAndView mav = new ModelAndView();
		Employee employee = employeeDao.getEmployee(employeeId);
		
//if the employee Id inputed is valid
		if(!(Objects.isNull(employee))) {
			mav.setViewName("applicationForm.jsp");
			mav.addObject("employee", employee);
			return mav;	
		}
		
//Employee Id does not exist
		else {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", employeeId+" does not exist in our Systems");
			return mav;
		}
			
	}
	
}
