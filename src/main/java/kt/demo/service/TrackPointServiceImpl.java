package kt.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kt.demo.model.TrackPoint;
import kt.demo.repository.TrackPointRepository;

/**
 * 
 * @author phunghaminh
 *
 */
@Service
public class TrackPointServiceImpl implements ITrackPointService {
	
	private final Logger logger = LoggerFactory.getLogger(TrackPointServiceImpl.class);
	
	@Autowired
	private TrackPointRepository trackPointRepository;

	public List<TrackPoint> getAllByTrackId(Integer trackId) {
		logger.info("get track points by track id {}", trackId);
		return trackPointRepository.findByTrackId(trackId);
	}

}
