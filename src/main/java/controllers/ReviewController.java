package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDao;
import dao.LeaveDao;
import dao.ReviewDao;
import models.Employee;
import models.Leave;
import models.Review;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private LeaveDao leaveDao;

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("/ask-to-review")
	public ModelAndView authenticateApprover(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName.equals("patrick") && password.equals("patrick123")) {
			mav.setViewName("leavesList.jsp");
			mav.addObject("leaves", leaveDao.getAllLeaves());
			return mav;
		} else {
			mav.setViewName("index.jsp");
			return mav;
		}
	}

	@RequestMapping("/view")
	public ModelAndView showFormToReview(HttpServletRequest request, HttpServletResponse response) {
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		String employeeId = request.getParameter("employeeId");
		Employee employee = employeeDao.getEmployee(employeeId);
		Leave leave = leaveDao.getLeaveById(leaveId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reviewForm.jsp");
		mav.addObject("employee", employee);
		mav.addObject("leave", leave);
		return mav;
	}

	@RequestMapping("/review")
	public ModelAndView saveReview(HttpServletRequest request, HttpServletResponse response) {
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		String reviewType = request.getParameter("reviewType");
		String remarks = request.getParameter("remarks");
		String dateOfApproval = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		String employeeId = request.getParameter("employeeId");
		String supervisorId = request.getParameter("supervisorId");
		int leaveBalanceOriginal = Integer.parseInt(request.getParameter("leaveBalance"));
		String leaveType =request.getParameter("leaveType");
		int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
		int leaveBalance = leaveBalanceOriginal - daysRequested;
		ModelAndView mav = new ModelAndView();
		
		reviewDao.saveReview(new Review(leaveId, reviewType, remarks, dateOfApproval, supervisorId));
		System.out.println("Review Saved!");

		if (!(leaveType.equals("sick")) && reviewType.equals("approved")) {
			leaveDao.updateLeave(new Leave(leaveId,reviewType, dateOfApproval));
			employeeDao.updateEmployee(new Employee(employeeId,leaveBalance));
			System.out.println("date of approval & leave Balance updated!");
			mav.setViewName("index.jsp");
			return mav;
			
		} else {
			leaveDao.updateLeave(new Leave(leaveId,reviewType, dateOfApproval));
			System.out.println("Date of approval set!");
			mav.setViewName("index.jsp");
			return mav;
		}

		

		
	}
}
