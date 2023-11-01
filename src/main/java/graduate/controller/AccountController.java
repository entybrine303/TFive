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

import graduate.utils.Sub;
@Controller
@RequestMapping("tfive")
public class AccountController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("my-order")
	public String viewOrder(ModelMap model) {
		Sub sub=new Sub();
		sub.checkUsername(request);
		
		return "customerUI/my-order";
	}
	
	@GetMapping("profile")
	public String viewProfile(ModelMap model) {
		Sub sub=new Sub();
		sub.checkUsername(request);
		
		return "customerUI/profile";
	}
	
}
