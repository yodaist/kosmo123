package kr.co.kosmo.mvc.controller.overseas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/overseas")
public class OverseastripController {
	//@Autowired
	
	
	//�ؿܿ��� View�� �̵�
	@GetMapping(value = "/overseastrip")
	public ModelAndView overseastrip() {
		ModelAndView mav = new ModelAndView("overseastrip/overseastrip");
		return mav;
	}
	
}
