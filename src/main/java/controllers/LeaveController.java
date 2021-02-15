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
	

	@RequestMapping("/apply")
	public ModelAndView apply(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String employeeId = request.getParameter("employeeId");
		String leaveType = request.getParameter("leaveType");
		int daysRequested = Integer.parseInt(request.getParameter("daysRequested"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int leaveBalance = Integer.parseInt(request.getParameter("leaveBalance"));
		String address = request.getParameter("address");
		String dateOfApplication = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		String status = "pending";
		Leave leave =new Leave(employeeId, leaveType, daysRequested,startDate,endDate, address, dateOfApplication, status);
		session.setAttribute("leave", leave);
		ModelAndView mav = new ModelAndView();
		
//saving a new leave entry

		if (request.getParameter("leaveId").isEmpty()) {
			if (leaveBalance > daysRequested || leaveType.equals("sick")) {
				leaveDao.saveLeave(leave);
				mav.setViewName("index.jsp");
				System.out.println("leave saved Successfully");
				session.invalidate();
				return mav;
			} else {
				System.out.println("leave days not sufficient");
				mav.setViewName("applicationForm.jsp");
				
				return mav;

			}
		}

//updating an existing leave entry		

		else {
			if (leaveBalance > daysRequested || leaveType.equals("sick"))
			{
				int leaveId = Integer.parseInt(request.getParameter("leaveId"));
				leaveDao.updateEditedLeave(new Leave(leaveId, employeeId, leaveType, daysRequested,startDate,endDate, address, dateOfApplication, status));
				mav.setViewName("index.jsp");
				System.out.println("leave updated Successfully");
				session.invalidate();
				return mav;
			} 
			else 
			{
				System.out.println("leave days not sufficient");
				mav.setViewName("index.jsp");
				return mav;
			}
		}

	}

	@RequestMapping("/ask-to-view-application")
	public ModelAndView viewApplication(HttpServletRequest request, HttpServletResponse response) {
		String employeeId = request.getParameter("employeeId");
		String status ="pending";
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		List<Leave> leaves = leaveDao.getLeaveByEmployeeIdForEditing(employeeId,status);
		List<Leave> leavesWithReview =leaveDao.getLeaveAndReview(employeeId);
		if (leaves != null || leavesWithReview!= null) {
			mav.setViewName("viewApplication.jsp");
			mav.addObject("leaves", leaves);
			session.setAttribute("leavesWithReview", leavesWithReview);
			return mav;
		} else {
			mav.setViewName("index.jsp");
			mav.addObject("employeeId", employeeId);
			return mav;
		}
	}

	@RequestMapping("/edit")
	public ModelAndView editApplication(HttpServletRequest request, HttpServletResponse response) {
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		String employeeId = request.getParameter("employeeId");
		Employee employee = employeeDao.getEmployee(employeeId);
		Leave leave = leaveDao.getLeaveById(leaveId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("applicationForm.jsp");
		mav.addObject("employee", employee);
		mav.addObject("leave", leave);
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteLeave(@RequestParam("leaveId") int leaveId ) {
		leaveDao.delete(leaveId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewApplication.jsp");
		return mav;
	}
	
	@RequestMapping("/getEmployeeAndLeaves")
	public ModelAndView getEmployeeAndLeaves(HttpServletRequest request,HttpServletResponse response) {
		List<Leave> leaves =leaveDao.getLeaveAndReview("t33265896");
		HttpSession session = request.getSession();
		session.setAttribute("leaves", leaves);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewApplication.jsp");
		return mav;
	}
}
