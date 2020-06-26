package kt.demo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class Track extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1370287436418922795L;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private Timestamp createdDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "track", fetch = FetchType.LAZY)
	private List<WayPoint> wayPoints;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "track", fetch = FetchType.LAZY)
	private List<TrackPoint> trackPoints;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	public List<WayPoint> getWayPoints() {
		if (this.wayPoints == null) {
			this.wayPoints = new ArrayList<WayPoint>();
		}
		return this.wayPoints;
	}

	public void addWayPoint(WayPoint wayPoint) {
		if (wayPoint.isNew()) {
			getWayPoints().add(wayPoint);
		}
		wayPoint.setTrack(this);
	}

	public List<TrackPoint> getTrackPoints() {
		if (this.trackPoints == null) {
			this.trackPoints = new ArrayList<>();
		}
		return this.trackPoints;
	}

	public void addTrackPoint(TrackPoint trackPoint) {
		if (trackPoint.isNew()) {
			getTrackPoints().add(trackPoint);
		}
		trackPoint.setTrack(this);
	}

}
