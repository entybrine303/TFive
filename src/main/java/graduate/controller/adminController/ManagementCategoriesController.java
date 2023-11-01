package graduate.controller.adminController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import graduate.domain.Categories;
import graduate.dto.CategoriesDTO;
import graduate.service.CategoriesService;

@Controller
@RequestMapping("tfive/admin/categories/")
public class ManagementCategoriesController {

	@Autowired
	private CategoriesService categoriesService;

	public void fillToTable(ModelMap model) {
		List<Categories> list = categoriesService.findAll();
		model.addAttribute("categories", list);
	}

	@GetMapping("view")
	public String viewForm(ModelMap model) {
		fillToTable(model);

		model.addAttribute("category", new CategoriesDTO());
		return "restaurantUI/managementCategories";
	}

	@PostMapping("save")
	public ModelAndView save(ModelMap model, @Valid @ModelAttribute("category") CategoriesDTO dto,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("restaurantUI/managementCategories");
		}

		if (categoriesService.existsById(dto.getCategoriesID()) && dto.getIsEdit() == false) {
			model.addAttribute("mess", "ID này đã tồn tại. Vui lòng chọn một ID khác.");
			return new ModelAndView(viewForm(model), model);
		}
		Categories entity = new Categories();
		BeanUtils.copyProperties(dto, entity);
		categoriesService.save(entity);
		if (dto.getIsEdit()) {
			model.addAttribute("mess", "Category is update");
		} else {
			model.addAttribute("mess", "Category is saved");
		}

		return new ModelAndView(viewForm(model), model);
	}

	@GetMapping("delete/{categoriesId}")
	public ModelAndView delete(ModelMap model, @PathVariable("categoriesId") String categoriesId) {
		categoriesService.deleteById(categoriesId);
		model.addAttribute("mess", "Category id delete");
		return new ModelAndView(viewForm(model), model);
	}

	@GetMapping("edit/{categoriesId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoriesId") String categoriesId) {
		fillToTable(model);
		Optional<Categories> opt = categoriesService.findById(categoriesId);
		CategoriesDTO dto = new CategoriesDTO();

		if (opt.isPresent()) {
			Categories entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);

			model.addAttribute("category", dto);
			return new ModelAndView("restaurantUI/managementCategories", model);
		}
		model.addAttribute("mess", "Category is not existed");

		return new ModelAndView("restaurantUI/managementCategories", model);
	}

}
