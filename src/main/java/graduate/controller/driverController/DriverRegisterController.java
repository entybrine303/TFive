package graduate.controller.driverController;

import java.util.List;

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

import graduate.domain.DriverRegister;
import graduate.dto.DriverRegisterDTO;
import graduate.service.DriverRegisterService;
import graduate.service.DriverRegisterService;
@Controller
@RequestMapping("tfive/account/driver-register")
public class DriverRegisterController {
	@Autowired
	private DriverRegisterService driverRegisterService;
	
	@GetMapping("view")
	public String viewRegister(ModelMap model) {
		model.addAttribute("driver", new DriverRegisterDTO());

		return "customerUI/driver-register";
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("driver") DriverRegisterDTO dao,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("customerUI/driver-register");
		}

		DriverRegister entity = new DriverRegister();
		BeanUtils.copyProperties(dao, entity);
		

		driverRegisterService.save(entity);
		

		model.addAttribute("mess", "Tài khoản đã được lưu thành công");
		model.addAttribute("driver", new DriverRegisterDTO());
		
		return new ModelAndView("customerUI/driver-register", model);
	}
	
}
