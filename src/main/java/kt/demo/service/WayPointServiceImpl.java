package kt.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kt.demo.model.WayPoint;
import kt.demo.repository.WayPointRepository;

/**
 * 
 * @author phunghaminh
 *
 */
@Service
public class WayPointServiceImpl implements IWayPointService{
	
	private final Logger logger = LoggerFactory.getLogger(WayPointServiceImpl.class);
	
	@Autowired
	private WayPointRepository wayPointRepository;

	public List<WayPoint> getAllByTrackId(Integer trackId) {
		logger.info("get waypoints by track id {}",trackId);
		return wayPointRepository.findByTrackId(trackId);
	}

}
