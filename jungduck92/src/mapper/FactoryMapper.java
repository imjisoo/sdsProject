package mapper;

import java.util.List;

import vo.ProductVO;

public interface FactoryMapper {
	
	public int createProduct (ProductVO product);
	
	public List<ProductVO> getProductList();
	
	public ProductVO getProductByIdx(String prdIdx);
	
	public int updateProduct (ProductVO product);
	
}
