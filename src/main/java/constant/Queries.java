package constant;

public class Queries {

	public static final String GET_ALL_MEDICINES = 
			"select id, name, description, seller_id, price, offer_id, tag_id, is_active, image_url from medicine";

	public static final String GET_ALL_TAGS = 
			"select id, name from tag";

	public static final String GET_ALL_OFFERS = 
			"select id, name, value_in_discount from offer";

	public static final String GET_ALL_SELLERS = 
			"select id, name from seller";

	public static final String VERIFY_LOGIN =
			"select is_admin from user where username = ? and password = ?";

	public static final String INSERT_USER =
			"insert into user(username, password, is_admin) values(?, ?, 0);";
	
	public static final String INSERT_MEDICINE = 
			"insert into medicine(name,description,seller_id,price,offer_id,tag_id,is_active,image_url) values (?,?,?,?,?,?,?,?)";

	public static final String INSERT_TAG = 
			"insert into tag(name) values (?)";

	public static final String INSERT_OFFER = 
			"insert into offer(name, value_in_discount) values (?,?)";

	public static final String INSERT_SELLER = 
			"insert into seller(name) values (?)";
	
	public static final String EDIT_MEDICINE = 
			"update medicine set name=?,description=?,seller_id=?,price=?,offer_id=?,tag_id=?,is_active=?,image_url=? where id=?";

}
