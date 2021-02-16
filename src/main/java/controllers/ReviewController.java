package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String status = "pending";
		List<Leave> leavesWithReviews =leaveDao.AllLeavesWithReview();
		

		if (userName.equals("patrick") && password.equals("patrick123")) {
			mav.setViewName("leavesList.jsp");
			mav.addObject("leaves", leaveDao.getAllPendingLeaves(status));
			mav.addObject("leavesWithReviews", leavesWithReviews);
			return mav;
		} else {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Wrong Credentials,please Log in again with the correct Log in credentials!");
			return mav;
		}
	}

	@RequestMapping("/view")
	public ModelAndView showFormToReview(HttpServletRequest request, HttpServletResponse response) {
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		System.out.println(leaveId);
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
		String approverId = request.getParameter("supervisorId");
		int leaveBalanceOriginal = Integer.parseInt(request.getParameter("leaveBalance"));
		String leaveType =request.getParameter("leaveType");
		int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
		int leaveBalance = leaveBalanceOriginal - daysRequested;
		ModelAndView mav = new ModelAndView();
		System.out.println(leaveId);
		reviewDao.saveReview(new Review(leaveId, reviewType, remarks, dateOfApproval));
		System.out.println("Review Saved!");

		//approved
		if (!(leaveType.equals("sick")) && reviewType.equals("approved")) {
			leaveDao.updateLeave(new Leave(leaveId,reviewType, dateOfApproval,approverId));
			employeeDao.updateEmployee(new Employee(employeeId,leaveBalance));
			System.out.println("date of approval & leave Balance updated!");
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Approval sent to the applicant!");
			return mav;
			
		}
		
		//rejected
		else {
			leaveDao.updateLeave(new Leave(leaveId,reviewType, dateOfApproval,approverId));
			System.out.println("Date of approval set!");
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Declined status sent to the applicant!");
			return mav;
		}

		

		
	}
}
