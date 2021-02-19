package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ReportsDao;
import models.Leave;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class DownloadsController {

	@Autowired
	ReportsDao reportsDao;
	private Calendar calender=Calendar.getInstance();
	
//Downloading approved Leave application	
	@RequestMapping("download")
	public void downloadApprovedLeavePdf(@RequestParam("leaveId") int leaveId,HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
		System.out.println(leaveId);
//getting the values to be included in the report from the database
		Leave leave = reportsDao.leaveWithReviewAndItsActors(leaveId);
		System.out.println(leave);
		
//converting the result to a  List in order for it to be passed to the JR datasource
		 List<Leave> leaves = new ArrayList<Leave>(); 
	        leaves.add(leave); 
	        
//Reading the Jasper report xml file
		final InputStream stream = this.getClass().getResourceAsStream("/approvedLeave.jrxml");
		
// Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);
        
// Fetching the leave from the data source.
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
