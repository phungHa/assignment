package kt.demo.service;

import java.util.List;

import kt.demo.model.TrackPoint;

public interface ITrackPointService {
	public List<TrackPoint> getAllByTrackId(Integer trackId);

}
