package model;

public class Seller {

	private Integer id;
	private String name;

    public Seller() {
    	
    }

	public Seller(String name) {
		super();
		this.name = name;
	}

	public Seller(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + "]";
	}
    
    
    
}
