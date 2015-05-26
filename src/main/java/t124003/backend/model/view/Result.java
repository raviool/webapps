package t124003.backend.model.view;

public class Result {
	private int document;
	private String name;
	private String description;
	private String last_name;
	private String doc_catalog_name;
	private String doc_status;
	private String doc_type;
	
	public int getDocument() {
		return document;
	}
	
	public void setDocument(int document) {
		this.document = document;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getDoc_catalog_name() {
		return doc_catalog_name;
	}
	
	public void setDoc_catalog_name(String doc_catalog_name) {
		this.doc_catalog_name = doc_catalog_name;
	}
	
	public String getDoc_status() {
		return doc_status;
	}
	
	public void setDoc_status(String doc_status) {
		this.doc_status = doc_status;
	}
	
	public String getDoc_type() {
		return doc_type;
	}
	
	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}
}
