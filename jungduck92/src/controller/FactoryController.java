package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.FactoryService;
import vo.ProductVO;

@Controller
public class FactoryController {
	
	@Autowired
	private FactoryService service;
	
	public void setService(FactoryService service) {
		
		this.service = service;
		
	}
	
	@RequestMapping("/fac_index.jd")
	public String fac_index () {
		
		return "fac/fac_index";
		
	}
	
	@RequestMapping("/productRegi.jd")
	public String productRegi () {
		
		return "fac/fac01_m01";
		
	}
	
	@RequestMapping(value="/productResult.jd", method=RequestMethod.POST)
	public ModelAndView productResult (ProductVO product, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		product.setInputId(session.getAttribute("userId").toString());
		
		if (service.productResult(product)) {
			
			mv.setViewName("fac/fac_index");
			
		} else {
			
			mv.setViewName("fac/fac01_m01");
			
		}
		
		return mv;
		
	}
	
}
