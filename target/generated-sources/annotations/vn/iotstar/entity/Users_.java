package vn.iotstar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static final String FAVORITES = "favorites";
	public static final String SHARES = "shares";
	public static final String PASSWORD = "password";
	public static final String IMAGES = "images";
	public static final String PHONE = "phone";
	public static final String ADMIN = "admin";
	public static final String ACTIVE = "active";
	public static final String FULLNAME = "fullname";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

	
	/**
	 * @see vn.iotstar.entity.Users#favorites
	 **/
	public static volatile ListAttribute<Users, Favorites> favorites;
	
	/**
	 * @see vn.iotstar.entity.Users#shares
	 **/
	public static volatile ListAttribute<Users, Shares> shares;
	
	/**
	 * @see vn.iotstar.entity.Users#password
	 **/
	public static volatile SingularAttribute<Users, String> password;
	
	/**
	 * @see vn.iotstar.entity.Users#images
	 **/
	public static volatile SingularAttribute<Users, String> images;
	
	/**
	 * @see vn.iotstar.entity.Users#phone
	 **/
	public static volatile SingularAttribute<Users, String> phone;
	
	/**
	 * @see vn.iotstar.entity.Users#admin
	 **/
	public static volatile SingularAttribute<Users, Boolean> admin;
	
	/**
	 * @see vn.iotstar.entity.Users#active
	 **/
	public static volatile SingularAttribute<Users, Boolean> active;
	
	/**
	 * @see vn.iotstar.entity.Users#fullname
	 **/
	public static volatile SingularAttribute<Users, String> fullname;
	
	/**
	 * @see vn.iotstar.entity.Users
	 **/
	public static volatile EntityType<Users> class_;
	
	/**
	 * @see vn.iotstar.entity.Users#email
	 **/
	public static volatile SingularAttribute<Users, String> email;
	
	/**
	 * @see vn.iotstar.entity.Users#username
	 **/
	public static volatile SingularAttribute<Users, String> username;

}

