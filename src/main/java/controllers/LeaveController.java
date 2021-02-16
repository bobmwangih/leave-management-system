package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class LeaveController {

	@Autowired
	private LeaveDao leaveDao;

	@Autowired
	private EmployeeDao employeeDao;
	
	private Calendar calender=Calendar.getInstance();

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
		Employee employee= new Employee(employeeId,firstName,lastName,email,leaveBalance);
		Leave leave =new Leave(employeeId, leaveType, daysRequested,startDate,endDate, address, dateOfApplication, status);
		//session.setAttribute("leave", leave);
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
			} else {
				System.out.println("leave days not sufficient");
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "leave days not sufficient,Leave not saved");
		
				return mav;

			}
		}

//updating an existing leave entry		

		else {
			if (leaveBalance > daysRequested || leaveType.equals("sick"))
			{
				int leaveId = Integer.parseInt(request.getParameter("leaveId"));
				leaveDao.updateEditedLeave(new Leave(leaveId, employeeId, leaveType, daysRequested,startDate,endDate, address, dateOfApplication, status));
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "leave updated Successfully");
				System.out.println("leave updated Successfully");
				session.invalidate();
				return mav;
			} 
			else 
			{
				System.out.println("leave days not sufficient");
				mav.setViewName("leaveSaved.jsp");
				mav.addObject("message", "leave days not sufficient,Leave not saved");
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
		mav.setViewName("leaveSaved.jsp");
		mav.addObject("message", "leave deleted successfully!");
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
	
	@RequestMapping("/seeRemarks")
	public ModelAndView getLeaveByIdWithRemarks(@RequestParam("leaveId") int leaveId) {
		Leave leave = leaveDao.getLeaveByIdWithReview(leaveId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("remarks.jsp");
		mav.addObject("message", leave.getReview().remarks);
		return mav;
	}
	
	@RequestMapping("download")
	public void downloadPdf(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
		List<Leave> leaves = leaveDao.leavezWithReview();
	
		
		final InputStream stream = this.getClass().getResourceAsStream("/testReport.jrxml");
		
		 // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);
        
     // Fetching the leaves from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(leaves);
        
        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters =null;
        
     // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        
        Integer month=calender.get(Calendar.MONTH);
        response.setContentType("application/x-download");
        response.addHeader("Content-disposition", "attachment; filename="+"leave_report"+calender.get(Calendar.DATE)+"-"+String.valueOf(month+1)+"-"+calender.get(Calendar.YEAR)+".pdf");
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(print, out);
        out.flush();
        out.close();
        
	}
}
