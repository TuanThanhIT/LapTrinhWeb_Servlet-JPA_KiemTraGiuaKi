package vn.iotstar.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private int categoryId;

	@Column(name = "Categoryname", columnDefinition = "nvarchar(100)")
	private String categoryName;

	@Column(name = "Categorycode", columnDefinition = "nvarchar(100)")
	private String categoryCode;

	@Column(name = "Images", columnDefinition = "nvarchar(500)")
	private String images;

	@Column(name = "Status", columnDefinition = "bit")
	private boolean status;

	@OneToMany
	(mappedBy = "category", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Videos> videos;

	
	
	public Category() {
		super();
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Videos> getVideos() {
		return videos;
	}
	public void setVideos(List<Videos> videos) {
		this.videos = videos;
	}
	
	public Videos addVideos(Videos video) {
		getVideos().add(video);
		video.setCategory(this);
		return video;
	}
	public Videos removeVideos(Videos video) {
		getVideos().remove(video);
		video.setVideoId(0);
		return video;
	}
	
	

}
