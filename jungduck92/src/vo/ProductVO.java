package vo;

import org.springframework.web.multipart.MultipartFile;

/*

PRODUCT

PRD_IDX
PRD_NAME
PRD_IMG
PRD_THUMB
PRD_PRICE
PRD_COST
PRD_QTY
PRD_USEYN
INPUT_ID
INPUT_DATE

 */

public class ProductVO {
	
	private String prdIdx;
	private String prdName;
	private String prdImg;
	private MultipartFile prdImgFile;
	private String prdThumb;
	private MultipartFile prdThumbFile;
	private String prdPrice;
	private String prdCost;
	private String prdQty;
	private String prdUseYn;
	private String inputId;
	private String inputDate;
	
	public ProductVO() {}

	public ProductVO (String prdIdx, String prdName, String prdImg, MultipartFile prdImgFile, String prdThumb, MultipartFile prdThumbFile, String prdPrice, String prdCost, String prdQty, String prdUseYn, String inputId, String inputDate) {
		
		this.prdIdx = prdIdx;
		this.prdName = prdName;
		this.prdImg = prdImg;
		this.prdImgFile = prdImgFile;
		this.prdThumb = prdThumb;
		this.prdThumbFile = prdThumbFile;
		this.prdPrice = prdPrice;
		this.prdCost = prdCost;
		this.prdQty = prdQty;
		this.prdUseYn = prdUseYn;
		this.inputId = inputId;
		this.inputDate = inputDate;
		
	}

	public ProductVO (String prdIdx, String prdName, String prdImg, String prdThumb, String prdPrice, String prdCost, String prdQty, String prdUseYn, String inputId, String inputDate) {
		
		this.prdIdx = prdIdx;
		this.prdName = prdName;
		this.prdImg = prdImg;
		this.prdThumb = prdThumb;
		this.prdPrice = prdPrice;
		this.prdCost = prdCost;
		this.prdQty = prdQty;
		this.prdUseYn = prdUseYn;
		this.inputId = inputId;
		this.inputDate = inputDate;
		
	}
	
	public String getPrdIdx() {
		
		return prdIdx;
		
	}
	
	public void setPrdIdx(String prdIdx) {
		
		this.prdIdx = prdIdx;
		
	}
	
	public String getPrdName() {
		
		return prdName;
		
	}
	
	public void setPrdName(String prdName) {
		
		this.prdName = prdName;
		
	}
	
	public String getPrdImg() {
		
		return prdImg;
		
	}
	
	public void setPrdImg(String prdImg) {
		
		this.prdImg = prdImg;
		
	}
	
	public MultipartFile getPrdImgFile() {
		
		return prdImgFile;
		
	}
	
	public void setPrdImgFile(MultipartFile prdImgFile) {
		
		this.prdImgFile = prdImgFile;
		
	}
	
	public String getPrdThumb() {
		
		return prdThumb;
		
	}
	
	public void setPrdThumb(String prdThumb) {
		
		this.prdThumb = prdThumb;
		
	}
	
	public MultipartFile getPrdThumbFile() {
		
		return prdThumbFile;
		
	}
	
	public void setPrdThumbFile(MultipartFile prdThumbFile) {
		
		this.prdThumbFile = prdThumbFile;
		
	}
	
	public String getPrdPrice() {
		
		return prdPrice;
		
	}
	
	public void setPrdPrice(String prdPrice) {
		
		this.prdPrice = prdPrice;
		
	}
	
	public String getPrdCost() {
		
		return prdCost;
		
	}
	
	public void setPrdCost(String prdCost) {
		
		this.prdCost = prdCost;
		
	}
	
	public String getPrdQty() {
		
		return prdQty;
		
	}
	
	public void setPrdQty(String prdQty) {
		
		this.prdQty = prdQty;
		
	}
	
	public String getPrdUseYn() {
		
		return prdUseYn;
		
	}
	
	public void setPrdUseYn(String prdUseYn) {
		
		this.prdUseYn = prdUseYn;
		
	}
	
	public String getInputId() {
		
		return inputId;
		
	}
	
	public void setInputId(String inputId) {
		
		this.inputId = inputId;
		
	}
	
	public String getInputDate() {
		
		return inputDate;
		
	}
	
	public void setInputDate(String inputDate) {
		
		this.inputDate = inputDate;
		
	}
	
	@Override
	public String toString() {
		
		return "PRODUCT[IDX:"+this.prdIdx+"/NAME:"+this.prdName+"/IMG:"+this.prdImg+"/THUMB:"+this.prdThumb+"/PRICE:"+this.prdPrice+"/COST:"+this.prdCost+"/QTY:"+this.prdQty+"/USEYN:"+this.prdUseYn+"]";
		
	}
	
}
