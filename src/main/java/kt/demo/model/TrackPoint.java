package kt.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "track_point")
public class TrackPoint extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8894533129631049524L;

	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "elevation")
	private Double elevation;
	
	@Column(name = "add_time")
	private Timestamp addTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id", referencedColumnName = "id")
	private Track track;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getElevation() {
		return elevation;
	}

	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Track getTrack() {
		return this.track;
	}

	protected void setTrack(Track track) {
		this.track = track;
	}

}
