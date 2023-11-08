package graduate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import graduate.domain.Account;
import graduate.domain.Customer;
import graduate.dto.LoginDTO;
import graduate.dto.RegisterDTO;
import graduate.service.AccountService;
import graduate.service.CustomerService;
import graduate.utils.CheckSession;
import graduate.utils.RamdomID;
@Controller
@RequestMapping("tfive/account")
public class LoginController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	

	@GetMapping("login")
	public String viewLogin(ModelMap model) {
		CheckSession sub=new CheckSession();
		sub.checkUsername(request);
		sub.checkRole(request);
		
		model.addAttribute("register", new RegisterDTO());
		return "customerUI/login";
	}
	
	@GetMapping("logout")
	public ModelAndView logout(ModelMap model) {
		session.setAttribute("username", null);
		session.setAttribute("role", "guest");
		return new ModelAndView(viewLogin(model));
		
//		 // Chuyển hướng về trang hiện tại (load lại trang)
//        String referer = request.getHeader("referer");
//		return new ModelAndView("redirect:" + referer);
	}
	
	@PostMapping("pLogin")
	public ModelAndView login(ModelMap model, 
			@Valid @ModelAttribute("account") LoginDTO dao, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("customerUI/login", model);
		}
		
		Account account=accountService.login(dao.getUsername(), dao.getPassword());
		
		if (account==null) {
			model.addAttribute("mess", "Invalid username or password");
			return new ModelAndView("customerUI/login", model);
		}
		
		session.setAttribute("username", account.getUsername());
		session.setAttribute("role", account.getRole());
		
			Customer customer=customerService.findByUsername(account.getUsername());
			session.setAttribute("customerID", customer.getCustomerID());
		
//		 // Lấy đường dẫn trang trước đó từ session
//        String referer = (String) request.getSession().getAttribute("referer");
//        if (referer != null && !referer.isEmpty()) {
//            // Xóa thông tin đã lưu trong session
//            request.getSession().removeAttribute("referer");
//            // Chuyển hướng về trang trước đó
//            return new ModelAndView("redirect:" + referer);
//        }
		
		return new ModelAndView("customerUI/index");
	}

	@PostMapping("/pRegister")
	public ModelAndView saveorUpdate(ModelMap model, 
			@Valid @ModelAttribute("register") RegisterDTO dao, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("customerUI/login");
		}
		if (!dao.getConfirmPassword().equals(dao.getPassword())) {
			model.addAttribute("mess", "Đăng kí thất bại! Mật khẩu không trùng khớp");
			return new ModelAndView("customerUI/login");
		}
		Account entity = new Account();
		
		BeanUtils.copyProperties(dao, entity);
		entity.setRole("user");
		
		accountService.save(entity);
		
//		Tạo customerID để lưu trữ dữ liệu của user, dữ liêu được lưu ở bảng Customer
//		Khởi tạo trường customerID và username tương ứng với account được đăng kí
		Customer customer=new Customer();
		customer.setCustomerID("U-"+RamdomID.generateRandomId());
		customer.setAccount(new Account(entity.getUsername()));
		customerService.save(customer);
		
		model.addAttribute("mess", "Đăng kí thành công");
		return new ModelAndView("customerUI/login");
	}

}
