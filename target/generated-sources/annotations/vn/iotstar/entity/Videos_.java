package vn.iotstar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Videos.class)
public abstract class Videos_ {

	public static final String FAVORITES = "favorites";
	public static final String SHARES = "shares";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	public static final String VIDEO_ID = "videoId";
	public static final String TITLE = "title";
	public static final String CATEGORY = "category";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";

	
	/**
	 * @see vn.iotstar.entity.Videos#favorites
	 **/
	public static volatile ListAttribute<Videos, Favorites> favorites;
	
	/**
	 * @see vn.iotstar.entity.Videos#shares
	 **/
	public static volatile ListAttribute<Videos, Shares> shares;
	
	/**
	 * @see vn.iotstar.entity.Videos#description
	 **/
	public static volatile SingularAttribute<Videos, String> description;
	
	/**
	 * @see vn.iotstar.entity.Videos#active
	 **/
	public static volatile SingularAttribute<Videos, Boolean> active;
	
	/**
	 * @see vn.iotstar.entity.Videos#videoId
	 **/
	public static volatile SingularAttribute<Videos, Integer> videoId;
	
	/**
	 * @see vn.iotstar.entity.Videos#title
	 **/
	public static volatile SingularAttribute<Videos, String> title;
	
	/**
	 * @see vn.iotstar.entity.Videos#category
	 **/
	public static volatile SingularAttribute<Videos, Category> category;
	
	/**
	 * @see vn.iotstar.entity.Videos
	 **/
	public static volatile EntityType<Videos> class_;
	
	/**
	 * @see vn.iotstar.entity.Videos#poster
	 **/
	public static volatile SingularAttribute<Videos, String> poster;
	
	/**
	 * @see vn.iotstar.entity.Videos#views
	 **/
	public static volatile SingularAttribute<Videos, Integer> views;

}

