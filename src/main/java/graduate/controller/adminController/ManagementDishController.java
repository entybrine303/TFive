package graduate.controller.adminController;

import java.util.Date;
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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import graduate.domain.Category;
import graduate.domain.Dish;
import graduate.domain.Restaurant;
import graduate.dto.CategoryDTO;
import graduate.dto.DishDTO;
import graduate.repository.DishRepository;
import graduate.service.CategoryService;
import graduate.service.DishService;
import graduate.service.StorageService;
import graduate.utils.RamdomID;
import graduate.utils.RedirectHelper;
import groovyjarjarantlr4.v4.runtime.atn.SemanticContext.AND;

@Controller
@RequestMapping("tfive/admin/dish")
public class ManagementDishController {

	@Autowired
	private DishRepository dishRepository;
	@Autowired
	private DishService dishService;
	@Autowired
	private CategoryService categoriesService;
	@Autowired
	private StorageService storageService;

	@ModelAttribute("categories") // lựa chọn danh mục
	public List<CategoryDTO> getCategories() {
		return categoriesService.findAll().stream().map(item -> {
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	void fillToTable(ModelMap model) {
		List<Dish> list = dishService.findAll();
		model.addAttribute("dishes", list);
	}

	@GetMapping("view")
	public String viewForm(ModelMap model) {
		fillToTable(model);

		DishDTO dishDTO = new DishDTO();
		dishDTO.setDishID("D-" + RamdomID.generateRandomId());
		model.addAttribute("dish", dishDTO);
		return "restaurantUI/managementDish";
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView save(ModelMap model, @Valid @ModelAttribute("dish") DishDTO dto, BindingResult result) {
		if (result.hasErrors()) {
		    // Lấy danh sách tất cả các lỗi
		    List<ObjectError> errors = result.getAllErrors();
		    
		    // In thông tin về lỗi
		    for (ObjectError error : errors) {
		        System.out.println("Error: " + error.getDefaultMessage());
		    }
		    // Thực hiện xử lý khi có lỗi
		    return new ModelAndView(viewForm(model));
		}
		
		if (dishService.existsById(dto.getDishID()) && dto.getIsEdit() == false) {
			model.addAttribute("mess", "ID này đã tồn tại. Vui lòng chọn một ID khác.");
			return new ModelAndView(viewForm(model), model);
		}
		Dish entity = new Dish();
		BeanUtils.copyProperties(dto, entity);
		
		Category category = new Category();
		category.setCategoryID(dto.getCategoryID());
		entity.setCategory(category);
		if(dto.getIsEdit()==true) entity.setCreatedDate(new Date());

		if (!dto.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			entity.setImg(storageService.getStoredFileName(dto.getImageFile(), uuString));
			storageService.storeImageWithResize(dto.getImageFile(), entity.getImg(), 209, 171);
		}else if (dto.getImageFile().isEmpty() && dto.getIsEdit()==true) {
			entity.setImg(dto.getImg());
		}
		entity.setRestaurant(new Restaurant("R01"));
		dishService.save(entity);
		model.addAttribute("mess", "Product is saved");
		return RedirectHelper.redirectTo("/tfive/admin/dish/view");
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
			dto.setCategoryID(entity.getCategory().getCategoryID());
			dto.setImg(entity.getImg());
			model.addAttribute("dish", dto);

			return new ModelAndView("restaurantUI/managementDish", model);
		}
		model.addAttribute("mess", "Dish is not existed");

		return new ModelAndView(viewForm(model), model);
	}

}
