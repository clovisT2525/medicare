package model;

public class Medicine {
	
	private Integer id;
	private String name;
	private String description;
	private Integer sellerId;
	private Integer price;
	private Integer offerId ;
	private Integer tagId;
    private boolean isActive;
    private String imageUrl;
	
    public Medicine() {
    	
    }
    
	public Medicine(Integer id, String name, String description, Integer sellerId, Integer price, Integer offerId,
			Integer tagId, Boolean isActive, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sellerId = sellerId;
		this.price = price;
		this.offerId = offerId;
		this.tagId = tagId;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
	}
	
	public Medicine(String name, String description, Integer sellerId, Integer price, Integer offerId, Integer tagId,
			Boolean isActive, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.sellerId = sellerId;
		this.price = price;
		this.offerId = offerId;
		this.tagId = tagId;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", description=" + description + ", sellerId=" + sellerId
				+ ", price=" + price + ", offerId=" + offerId + ", tagId=" + tagId + ", isActive=" + isActive 
				+ ", imageUrl=" + imageUrl
				+ "]";
	}

}
