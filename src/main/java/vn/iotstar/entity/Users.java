package vn.iotstar.entity;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "Username", columnDefinition = "nvarchar(50)")
    private String username;

    @Column(name = "Password", columnDefinition = "nvarchar(50)")
    private String password;

    @Column(name = "Phone", columnDefinition = "nvarchar(15)")
    private String phone;

    @Column(name = "Fullname", columnDefinition = "nvarchar(50)")
    private String fullname;

    @Column(name = "Email", columnDefinition = "nvarchar(150)")
    private String email;

    @Column(name = "Admin", columnDefinition = "bit")
    private boolean admin;

    @Column(name = "Active", columnDefinition = "bit")
    private boolean active;

    @Column(name = "Images", columnDefinition = "nvarchar(500)")
    private String images;

    @OneToMany(mappedBy = "user")
    private List<Favorites> favorites;

    @OneToMany(mappedBy = "user")
    private List<Shares> shares;
    

	public Users() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
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
	
	public Favorites addFavorites(Favorites favorites) {
		getFavorites().add(favorites);
		favorites.setUser(this);
		return favorites;
	}
	public Favorites removeFavorites(Favorites favorites) {
		getFavorites().remove(favorites);
		favorites.setFavoriteId(0);
		return favorites;
	}
	
	public Shares addShares(Shares shares) {
		getShares().add(shares);
		shares.setUser(this);
		return shares;
	}
	public Shares removeShare(Shares shares) {
		getShares().remove(shares);
		shares.setShareId(0);
		return shares;
	}
	
    
}