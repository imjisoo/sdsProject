package controller;

import java.util.List;

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
	
	@RequestMapping("/productList.jd")
	public ModelAndView productList () {
		
		ModelAndView mv = new ModelAndView();
		
		List<ProductVO> product_list = service.getProductList();
		
		mv.addObject("product_list", product_list);
		
		mv.setViewName("fac/fac01_m02");
		
		return mv;
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
			
			mv.setViewName("fac/fac01_s01");
			
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/productUpdate.jd", method=RequestMethod.POST)
	public ModelAndView productUpdate (String prdIdx) {
		
		ModelAndView mv = new ModelAndView();
		
		ProductVO product = service.getProductByIdx(prdIdx);
		
		mv.addObject("product", product);
		
		mv.setViewName("fac/fac01_m03");
		
		return mv;
		
	}
	
	@RequestMapping(value="/productUpdateResult.jd", method=RequestMethod.POST)
	public ModelAndView productUpdateResult(ProductVO product){
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println(product.getPrdImgFile());
		System.out.println(product.getPrdImg());
		
		/*int updateResult = service.updateProduct(product);
		
		mv.addObject("updateResult", updateResult);
		
		mv.setViewName("fac/fac01_s03");*/
		
		return mv;
		
	}
	
}
