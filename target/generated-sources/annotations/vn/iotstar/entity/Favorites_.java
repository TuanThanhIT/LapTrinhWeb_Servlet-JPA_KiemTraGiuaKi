package vn.iotstar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel(Favorites.class)
public abstract class Favorites_ {

	public static final String FAVORITE_ID = "favoriteId";
	public static final String LIKED_DATE = "likedDate";
	public static final String VIDEO = "video";
	public static final String USER = "user";

	
	/**
	 * @see vn.iotstar.entity.Favorites#favoriteId
	 **/
	public static volatile SingularAttribute<Favorites, Integer> favoriteId;
	
	/**
	 * @see vn.iotstar.entity.Favorites#likedDate
	 **/
	public static volatile SingularAttribute<Favorites, Date> likedDate;
	
	/**
	 * @see vn.iotstar.entity.Favorites#video
	 **/
	public static volatile SingularAttribute<Favorites, Videos> video;
	
	/**
	 * @see vn.iotstar.entity.Favorites
	 **/
	public static volatile EntityType<Favorites> class_;
	
	/**
	 * @see vn.iotstar.entity.Favorites#user
	 **/
	public static volatile SingularAttribute<Favorites, Users> user;

}

