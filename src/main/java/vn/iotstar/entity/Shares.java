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
@Table(name = "Shares")
public class Shares implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId", columnDefinition = "int")
    private int shareId;

    @Column(name = "Emails", columnDefinition = "nvarchar(MAX)")
    private String emails;

    @Column(name = "SharedDate", columnDefinition = "date")
    private Date sharedDate;

    @ManyToOne
    @JoinColumn(name = "Username", columnDefinition = "nvarchar(50)")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "VideoId", columnDefinition = "int")
    private Videos video;

    
    
	public Shares() {
		super();
	}
	public int getShareId() {
		return shareId;
	}
	public void setShareId(int shareId) {
		this.shareId = shareId;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getSharedDate() {
		return sharedDate;
	}
	public void setSharedDate(Date sharedDate) {
		this.sharedDate = sharedDate;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}

    
}
