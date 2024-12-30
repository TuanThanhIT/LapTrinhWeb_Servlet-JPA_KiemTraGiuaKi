package vn.iotstar.entity;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Videos")
public class Videos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VideoId", columnDefinition = "int")
	private int videoId;

	@Column(name = "Title", columnDefinition = "nvarchar(200)")
	private String title;

	@Column(name = "Poster", columnDefinition = "nvarchar(50)")
	private String poster;

	@Column(name = "Views", columnDefinition = "int")
	private int views;

	@Column(name = "Description", columnDefinition = "nvarchar(500)")
	private String description;

	@Column(name = "Active", columnDefinition = "bit")
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "CategoryId", columnDefinition = "int")
	private Category category;

	@OneToMany(mappedBy = "video")
	private List<Favorites> favorites;

	@OneToMany(mappedBy = "video")
	private List<Shares> shares;
	
	
	@Transient
	private int countShare;
	
	@Transient
	private int countLike;

	

	public Videos() {
		super();
	}
	
	
	public int getCountShare() {
		return countShare;
	}


	public void setCountShare(int countShare) {
		this.countShare = countShare;
	}


	public int getCountLike() {
		return countLike;
	}


	public void setCountLike(int countLike) {
		this.countLike = countLike;
	}


	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Favorites> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorites> favorites) {
		this.favorites = favorites;
	}
	public List<Shares> getShares() {
		return shares;
	}
	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}
	
	public Shares addRating(Shares shares) {
		getShares().add(shares);
		shares.setVideo(this);
		return shares;
	}
	public Shares removeRating(Shares shares) {
		getShares().remove(shares);
		shares.setShareId(0);
		return shares;
	}
	
	
}