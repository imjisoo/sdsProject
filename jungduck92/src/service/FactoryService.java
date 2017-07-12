package service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.FactoryDAO;
import vo.ProductVO;

@Component
public class FactoryService {
	
	@Autowired
	private FactoryDAO dao;
	
	public void setDao(FactoryDAO dao) {
		
		this.dao = dao;
		
	}
	
	public boolean productResult (ProductVO product) {
		
		String path = "\\\\70.12.111.135/Users/upload/";
		
		Date date = new Date();
		
		SimpleDateFormat spf = new SimpleDateFormat("yyMMddHHmmssSSS");
		
		String saveImgName = "IMG_"+spf.format(date);
		String saveThumbName = "THUMB_"+spf.format(date);
		
		File savedFileImg = new File(path+saveImgName);
		File savedFileThumb = new File(path+saveThumbName);
		
		product.setPrdImg(saveImgName);
		product.setPrdThumb(saveThumbName);
		
		try {
			
			product.getPrdImgFile().transferTo(savedFileImg);
			product.getPrdThumbFile().transferTo(savedFileThumb);
			
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
			
			return false;
			
		}
		
		if (dao.createProduct(product) == 1) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}
