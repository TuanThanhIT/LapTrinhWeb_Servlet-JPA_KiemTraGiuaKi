package vn.iotstar.entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static final String IMAGES = "images";
	public static final String VIDEOS = "videos";
	public static final String CATEGORY_CODE = "categoryCode";
	public static final String CATEGORY_NAME = "categoryName";
	public static final String CATEGORY_ID = "categoryId";
	public static final String STATUS = "status";

	
	/**
	 * @see vn.iotstar.entity.Category#images
	 **/
	public static volatile SingularAttribute<Category, String> images;
	
	/**
	 * @see vn.iotstar.entity.Category#videos
	 **/
	public static volatile ListAttribute<Category, Videos> videos;
	
	/**
	 * @see vn.iotstar.entity.Category#categoryCode
	 **/
	public static volatile SingularAttribute<Category, String> categoryCode;
	
	/**
	 * @see vn.iotstar.entity.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see vn.iotstar.entity.Category#categoryName
	 **/
	public static volatile SingularAttribute<Category, String> categoryName;
	
	/**
	 * @see vn.iotstar.entity.Category#categoryId
	 **/
	public static volatile SingularAttribute<Category, Integer> categoryId;
	
	/**
	 * @see vn.iotstar.entity.Category#status
	 **/
	public static volatile SingularAttribute<Category, Boolean> status;

}

