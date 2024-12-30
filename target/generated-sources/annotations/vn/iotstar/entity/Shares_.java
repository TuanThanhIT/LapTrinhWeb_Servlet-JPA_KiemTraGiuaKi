package vn.iotstar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.sql.Date;

@StaticMetamodel(Shares.class)
public abstract class Shares_ {

	public static final String EMAILS = "emails";
	public static final String SHARE_ID = "shareId";
	public static final String VIDEO = "video";
	public static final String SHARED_DATE = "sharedDate";
	public static final String USER = "user";

	
	/**
	 * @see vn.iotstar.entity.Shares#emails
	 **/
	public static volatile SingularAttribute<Shares, String> emails;
	
	/**
	 * @see vn.iotstar.entity.Shares#shareId
	 **/
	public static volatile SingularAttribute<Shares, Integer> shareId;
	
	/**
	 * @see vn.iotstar.entity.Shares#video
	 **/
	public static volatile SingularAttribute<Shares, Videos> video;
	
	/**
	 * @see vn.iotstar.entity.Shares
	 **/
	public static volatile EntityType<Shares> class_;
	
	/**
	 * @see vn.iotstar.entity.Shares#sharedDate
	 **/
	public static volatile SingularAttribute<Shares, Date> sharedDate;
	
	/**
	 * @see vn.iotstar.entity.Shares#user
	 **/
	public static volatile SingularAttribute<Shares, Users> user;

}

