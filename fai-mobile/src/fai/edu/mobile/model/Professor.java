package fai.edu.mobile.model;

public class Professor {
	
	/**
	 * Classe de modelo de Professores
	 * @param name
	 * @param detail
	 * @param image
	 */
	public Professor(String name, String detail, String image) {
		super();
		this.name = name;
		this.detail = detail;
		this.image = image;
	}
	
	private String name;
	private String detail;
	private String image;

	public String getName() {
		return name;
	}
	
	public void setName(String nameText) {
		name = nameText;
	}
	
	public String getDetails() {
		return detail;
	}
	
	public void setDetails(String born) {
		this.detail = born;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
}