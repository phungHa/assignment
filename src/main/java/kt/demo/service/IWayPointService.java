package kt.demo.service;

import java.util.List;

import kt.demo.model.WayPoint;

public interface IWayPointService {
	public List<WayPoint> getAllByTrackId(Integer trackId);

}
