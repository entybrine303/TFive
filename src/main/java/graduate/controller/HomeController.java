package graduate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import graduate.controller.adminController.ManagementCategoriesController;
import graduate.utils.Sub;
@Controller
@RequestMapping("tfive")
public class HomeController {
	@Autowired
	private ManagementCategoriesController managementCategoriesController;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@GetMapping("")
	public String viewHome(ModelMap model) {
		Sub sub=new Sub();
		sub.checkUsername(request);
		
		managementCategoriesController.fillToTable(model);
		return "customerUI/index";
	}
	
}
