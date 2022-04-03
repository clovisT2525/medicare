package model;

public class Tag {

	private Integer id;
	private String name;

    public Tag() {
    	
    }

	public Tag(String name) {
		super();
		this.name = name;
	}

	public Tag(Integer id, String name) {
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
		return "Tag [id=" + id + ", name=" + name + "]";
	}
    
    
    
}
