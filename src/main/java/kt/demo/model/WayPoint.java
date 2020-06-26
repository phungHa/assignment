package kt.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "way_point")
public class WayPoint extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3571251901383076848L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "track_id", referencedColumnName = "id")
	private Track track;

	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "sym")
	private String sym;

	public Track getTrack() {
		return this.track;
	}

	protected void setTrack(Track track) {
		this.track = track;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

}
