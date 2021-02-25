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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDao;
import dao.LeaveDao;
import models.Employee;
import models.Leave;

@Controller
public class LeaveController {

	@Autowired
	private LeaveDao leaveDao;

	@Autowired
	private EmployeeDao employeeDao;
	
//Handler to save a new leave application/an edited leave application
	@RequestMapping("/apply")
	public ModelAndView apply(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String employeeId = request.getParameter("employeeId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String leaveType = request.getParameter("leaveType");
		int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int leaveBalance = Integer.parseInt(request.getParameter("leaveBalance"));
		String address = request.getParameter("address");
		String dateOfApplication = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		String status = "pending";
		Employee employee = new Employee(employeeId, firstName, lastName, email, leaveBalance);
		Leave leave = new Leave(employeeId, leaveType, daysRequested, startDate, endDate, address, dateOfApplication,
				status);
		
		session.setAttribute("employee", employee);
		ModelAndView mav = new ModelAndView();
//saving a new leave entry

		if (request.getParameter("leaveId").isEmpty()) {
			if (leaveBalance > daysRequested || leaveType.equals("sick")) {
				leaveDao.saveLeave(leave);
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "leave saved Successfully");
				System.out.println("leave saved Successfully");
				session.invalidate();
				return mav;
			} 
//Insufficient leave days,display the error drop the application			
			else {
				
				System.out.println("leave days not sufficient");
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("origin", "insufficientDays");
				mav.addObject("message", "Invalid leave days Requested,Leave application will not Saved!");

				return mav;

			}
		}

//updating an existing leave entry		

		else {
			if (leaveBalance > daysRequested || leaveType.equals("sick")) {
				int leaveId = Integer.parseInt(request.getParameter("leaveId"));
				leaveDao.updateEditedLeave(new Leave(leaveId, employeeId, leaveType, daysRequested, startDate, endDate,
						address, dateOfApplication, status));
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "leave updated Successfully");
				System.out.println("leave updated Successfully");
				session.invalidate();
				return mav;
			}
//insufficient days,drop the application			
			else {
				System.out.println("leave days not sufficient");
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("origin", "insufficientDays");
				mav.addObject("message", "Invalid leave days Requested,Leave application will not Updated!");
				return mav;
			}
		}

	}
	
//handler to view a saved leave	

	@RequestMapping("/ask-to-view-application")
	public ModelAndView viewApplication(HttpServletRequest request, HttpServletResponse response) {
		String employeeId = request.getParameter("employeeId");
		String status = "pending";
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		List<Leave> leaves = leaveDao.getLeaveByEmployeeIdForEditing(employeeId, status);
		List<Leave> leavesWithReview = leaveDao.getLeaveAndReview(employeeId);
		if (!(leaves.isEmpty()) || !(leavesWithReview.isEmpty())) {
			mav.setViewName("viewApplication.jsp");
			mav.addObject("leaves", leaves);
			session.setAttribute("leavesWithReview", leavesWithReview);
			session.setAttribute("leaves", leaves);
			return mav;
		} else {
			mav.setViewName("leaveSaved.jsp");
			mav.addObject("message", "This employee doesnt have any leave records in our system");
			return mav;
		}
	}

//handler to reload application form for the actor to edit leave details	
	@RequestMapping("/edit")
	public ModelAndView editApplication(HttpServletRequest request, HttpServletResponse response) {
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		String employeeId = request.getParameter("employeeId");
		Employee employee = employeeDao.getEmployee(employeeId);
		request.getSession().setAttribute("employee", employee);
		Leave leave = leaveDao.getLeaveById(leaveId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("applicationForm.jsp");
		mav.addObject("employee", employee);
		mav.addObject("leave", leave);
		return mav;
	}

// handler to delete a leave record from the database
	@RequestMapping("/delete")
	public ModelAndView deleteLeave(@RequestParam("leaveId") int leaveId) {
		leaveDao.delete(leaveId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("leaveSaved.jsp");
		mav.addObject("message", "leave deleted successfully!");
		return mav;
	}
	
//handler to view Leave remarks of a declined application
	@RequestMapping("/seeRemarks")
	public ModelAndView getLeaveByIdWithRemarks(@RequestParam("leaveId") int leaveId) {
		Leave leave = leaveDao.getLeaveByIdWithReview(leaveId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("remarks.jsp");
		mav.addObject("message", leave.getReview().remarks);
		return mav;
	}
}
