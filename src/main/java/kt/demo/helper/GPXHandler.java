package kt.demo.helper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import kt.demo.model.Track;
import kt.demo.model.TrackPoint;
import kt.demo.model.WayPoint;

public class GPXHandler extends DefaultHandler {
	
	private static final String METADATA = "metadata";
	private static final String METADATA_NAME = "name";
	private static final String METADATA_DESC = "desc";

	private static final String WAY_POINT = "wpt";
	private static final String TRACK_POINT = "trkpt";
	private static final String TRACK_POINT_ELE = "ele";
	private static final String LATITUDE = "lat";
	private static final String LONGITUDE = "lon";
	private static final String SYM = "sym";
	private static final String TIME = "time";

	private Track track;
	private String elementValue;
	private boolean isMetadata = false;
	private boolean isTrackPoint = false;

	public Track getTrack() {
		return track;
	}

	@Override
	public void startDocument() throws SAXException {
		track = new Track();
		LocalDateTime.now(ZoneOffset.UTC);
	}

	@Override
	public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
		switch (qName) {
		case METADATA:
			isMetadata = true;
			break;
		case WAY_POINT:
			WayPoint wayPoint = new WayPoint();
			wayPoint.setLatitude(Double.valueOf(attr.getValue(LATITUDE)));
			wayPoint.setLongitude(Double.valueOf(attr.getValue(LONGITUDE)));
			track.addWayPoint(wayPoint);
			break;
		case TRACK_POINT:
			isTrackPoint = true;
			TrackPoint trackPoint = new TrackPoint();
			trackPoint.setLatitude(Double.valueOf(attr.getValue(LATITUDE)));
			trackPoint.setLongitude(Double.valueOf(attr.getValue(LONGITUDE)));
			track.addTrackPoint(trackPoint);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		elementValue = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case METADATA:
			isMetadata = false;
			break;
		case METADATA_NAME:
			if (isMetadata) {
				track.setName(elementValue);
			} else {
				track.getWayPoints().get(track.getWayPoints().size() - 1).setName(elementValue);
			}
			break;
		case METADATA_DESC:
			track.setDescription(elementValue);
			break;
		case TRACK_POINT_ELE:
			track.getTrackPoints().get(track.getTrackPoints().size() - 1)
					.setElevation(Double.parseDouble(elementValue));
			break;
		case SYM:
			track.getWayPoints().get(track.getWayPoints().size() - 1).setSym(elementValue);
			break;
		case TIME:
			if(isTrackPoint) {
				LocalDateTime parsedDate = LocalDateTime.parse(elementValue, DateTimeFormatter.ISO_DATE_TIME);
				Timestamp time = Timestamp.valueOf(parsedDate);
				track.getTrackPoints().get(track.getTrackPoints().size() - 1).setAddTime(time);
			}
			isTrackPoint=false;

		}
	}

}
