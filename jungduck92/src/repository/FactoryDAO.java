package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FactoryMapper;
import vo.ProductVO;

@Component
public class FactoryDAO {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		
		this.sessionTemplate = sessionTemplate;
		
	}
	
	public int createProduct (ProductVO product) {
		
		FactoryMapper mapper = sessionTemplate.getMapper(FactoryMapper.class);
		
		return mapper.createProduct(product);
		
	}
	
	public List<ProductVO> getProductList(){
		
		FactoryMapper mapper = sessionTemplate.getMapper(FactoryMapper.class);
		
		return mapper.getProductList();
		
	}
	
	public ProductVO getProductByIdx(String prdIdx){
		
		FactoryMapper mapper = sessionTemplate.getMapper(FactoryMapper.class);
		
		return mapper.getProductByIdx(prdIdx);
		
	}
	
	public int updateProduct(ProductVO product){
		
		FactoryMapper mapper = sessionTemplate.getMapper(FactoryMapper.class);
		
		return mapper.updateProduct(product);
		
	}
	
}
