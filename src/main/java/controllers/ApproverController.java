package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ApproverDao;
import models.Approver;

@Controller
public class ApproverController {

	@Autowired
	public ApproverDao approverDao;
	
	@RequestMapping("/getApprover")
	public ModelAndView getApproverWithReviews() {
		Approver approver = approverDao.getApproverAndReviews();
		System.out.println(approver);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reviewsList.jsp");
		mav.addObject("approver", approver);
		return mav;
	}
}
