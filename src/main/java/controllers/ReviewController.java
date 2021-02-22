package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

//Authenticate the approver ,then show all the leaves	
	@RequestMapping("/ask-to-review")
	public ModelAndView authenticateApprover(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String status = "pending";

//no session,no log In credentials		
		if (userName == null && request.getSession().getAttribute("username") == null) {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Session Expired,Please Log In!");
			return mav;
		}

//if the Approver is authenticated,populate the view with:leaves pending approval & leaves that have been approved+their reviews(readOnly)
		else if (request.getSession().getAttribute("username") != null
				|| (userName.equals("patrick") && password.equals("patrick123"))) {
			request.getSession().setAttribute("username", userName);
			List<Leave> leavesWithReviews = leaveDao.AllLeavesWithReview();
			List<Leave> leaves = leaveDao.getAllPendingLeaves(status);
			mav.setViewName("leavesList.jsp");
			mav.addObject("leaves", leaves);
			mav.addObject("leavesWithReviews", leavesWithReviews);
			return mav;
		}

//invalid login credentials		
		else {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Wrong Credentials,Try again with valid credentials!");
			return mav;
		}
	}

//Handler to bring a reviewform View,loaded with the applicant's details and their respective leave data
	@RequestMapping("/view")
	public ModelAndView showFormToReview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String employeeId = request.getParameter("employeeId");
//accessing the link directly,no session
		if (employeeId == null) {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "No leave application selected to view");
			return mav;
		}
//there is a session,parameters are passed			
		else if (request.getSession().getAttribute("username") != null) {
			int leaveId = Integer.parseInt(request.getParameter("leaveId"));
			Employee employee = employeeDao.getEmployee(employeeId);
			Leave leave = leaveDao.getLeaveById(leaveId);
			mav.setViewName("reviewForm.jsp");
			mav.addObject("leave", leave);
			mav.addObject("employee", employee);
			return mav;
		} 
//no session,		
		else {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Your Session has expired! Please Log in");
			return mav;
		}
	}

//handler to handle a new review
	@RequestMapping("/review")
	public ModelAndView saveReview(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		if (request.getSession().getAttribute("username") != null) {
			int leaveId = Integer.parseInt(request.getParameter("leaveId"));
			String reviewType = request.getParameter("reviewType");
			String remarks = request.getParameter("remarks");
			String dateOfApproval = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
			String employeeId = request.getParameter("employeeId");
			String approverId = request.getParameter("supervisorId");
			int leaveBalanceOriginal = Integer.parseInt(request.getParameter("leaveBalance"));
			String leaveType = request.getParameter("leaveType");
			int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
			int leaveBalance = leaveBalanceOriginal - daysRequested;
			reviewDao.saveReview(new Review(leaveId, reviewType, remarks, dateOfApproval));
			Employee employee = new Employee(employeeId, leaveBalance);
			System.out.println(employee);
			System.out.println("Review Saved!");

// approved leave
			if (!(leaveType.equals("sick")) && reviewType.equals("approved")) {
				leaveDao.updateLeave(new Leave(leaveId, reviewType, dateOfApproval, approverId));
				employeeDao.updateEmployee(employee);
				System.out.println(leaveBalance);
				System.out.println("date of approval & leave Balance updated!");
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "Approval sent to the applicant!");
				return mav;

			}

// rejected leave
			else {
				leaveDao.updateLeave(new Leave(leaveId, reviewType, dateOfApproval, approverId));
				System.out.println("Date of approval set!");
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "Declined status sent to the applicant!");
				return mav;
			}
		} else {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "Your Session has expired! Please Log in");
			return mav;
		}
	}

// handler to log Out an approver and clear the session
	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}

//handler to go back to a previous page
	@RequestMapping("/back")
	public String back(HttpServletRequest request,HttpServletResponse response) {
		return "redirect:/ask-to-review";

	}
}
