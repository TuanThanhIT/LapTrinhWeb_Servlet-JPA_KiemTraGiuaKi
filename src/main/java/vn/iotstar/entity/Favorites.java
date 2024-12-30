package vn.iotstar.entity;
import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Favorites")
public class Favorites implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId", columnDefinition = "int")
    private int favoriteId;

    @Column(name = "LikedDate", columnDefinition = "date")
    private Date likedDate;

    @ManyToOne
    @JoinColumn(name = "VideoId", columnDefinition = "int")
    private Videos video;

    @ManyToOne
    @JoinColumn(name = "Username", columnDefinition = "nvarchar(50)")
    private Users user;
    
	public Favorites() {
		super();
	}
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public Date getLikedDate() {
		return likedDate;
	}
	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}