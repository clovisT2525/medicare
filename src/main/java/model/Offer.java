package model;

public class Offer {

	private Integer id;
	private String name;
	private Integer valueInDiscount;

    public Offer() {
    	
    }

	public Offer(String name, Integer valueInDiscount) {
		super();
		this.name = name;
		this.valueInDiscount = valueInDiscount;
	}

	public Offer(Integer id, String name, Integer valueInDiscount) {
		super();
		this.id = id;
		this.name = name;
		this.valueInDiscount = valueInDiscount;
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

	public Integer getValueInDiscount() {
		return valueInDiscount;
	}

	public void setValueInDiscount(Integer valueInDiscount) {
		this.valueInDiscount = valueInDiscount;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", valueInDiscount=" + valueInDiscount + "]";
	}

}
