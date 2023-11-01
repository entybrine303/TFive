package graduate.controller.adminController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import graduate.domain.Categories;
import graduate.domain.Dish;
import graduate.dto.CategoriesDTO;
import graduate.dto.DishDTO;
import graduate.reponsitory.DishReponsitory;
import graduate.service.CategoriesService;
import graduate.service.DishService;
import graduate.service.StorageService;
@Controller
@RequestMapping("tfive/admin/dish")
public class ManagementDishController {
	
	@Autowired
	private DishReponsitory dishRepository;
	@Autowired
	private DishService dishService;
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private StorageService storageService;

	@ModelAttribute("categories") // lựa chọn danh mục
	public List<CategoriesDTO> getCategories() {
		return categoriesService.findAll().stream().map(item -> {
			CategoriesDTO dto = new CategoriesDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	void fillToTable(ModelMap model) {
		List<Dish> list = dishService.findAll();
		model.addAttribute("dishs", list);
	}

	@GetMapping("view")
	public String viewForm(ModelMap model) {
		fillToTable(model);
		model.addAttribute("dish", new DishDTO());
		return "restaurantUI/managementDish";
	}

//  Dùng để load ảnh đã được lưu 
	@GetMapping("/uploads/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView save(ModelMap model, @Valid @ModelAttribute("dish") DishDTO dto, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView(viewForm(model));
		}

		Dish entity = new Dish();
		BeanUtils.copyProperties(dto, entity);
		
		Categories categories = new Categories();
		categories.setCategoriesID(dto.getCategoriesID());
		entity.setCategoriesID(categories);
		
		if (!dto.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			entity.setImg(storageService.getStoredFileName(dto.getImageFile(), uuString));
			storageService.store(dto.getImageFile(), entity.getImg());
		}
		dishService.save(entity);
		model.addAttribute("mess", "Product is saved");
		return new ModelAndView(viewForm(model), model);
	}

	@GetMapping("delete/{dishID}")
	public ModelAndView delete(ModelMap model, @PathVariable("dishID") String dishID) {
		dishService.deleteById(dishID);
		model.addAttribute("mess", "Dish id delete");
		return new ModelAndView(viewForm(model), model);
	}

	@GetMapping("edit/{dishID}")
	public ModelAndView edit(ModelMap model, @PathVariable("dishID") String dishID) {
		fillToTable(model);
		Optional<Dish> opt = dishService.findById(dishID);
		DishDTO dto = new DishDTO();

		if (opt.isPresent()) {
			Dish entity = opt.get();

			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			dto.setCategoriesID(entity.getCategoriesID().getCategoriesID());
			dto.setImg(entity.getImg());
			model.addAttribute("dish", dto);

			return new ModelAndView("restaurantUI/managementDish", model);
		}
		model.addAttribute("mess", "Dish is not existed");

		return new ModelAndView("restaurantUI/managementDish", model);
	}

}
