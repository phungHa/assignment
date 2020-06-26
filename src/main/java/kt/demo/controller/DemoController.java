package kt.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import kt.demo.model.Track;
import kt.demo.model.TrackPoint;
import kt.demo.model.WayPoint;
import kt.demo.service.ITrackPointService;
import kt.demo.service.ITrackService;
import kt.demo.service.IWayPointService;

@RestController
@RequestMapping("/api")
public class DemoController {

	private final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private ITrackService trackService;

	@Autowired
	private ITrackPointService trackPointService;

	@Autowired
	private IWayPointService wayPointService;

	@PostMapping("/upload")
	public Integer upload(@RequestParam("file") @NonNull MultipartFile file) {
		try {
			return trackService.saveAndStoreCDN(file.getInputStream());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/lastest")
	public List<Track> getLastestTrack(@RequestParam(name = "pageIndex", defaultValue = "0") Integer pageIndex,
			@RequestParam(name = "numItem", defaultValue = "10") Integer num) {

		return trackService.getLastest(pageIndex, num);
	}

	@GetMapping("/trackpoint")
	public List<TrackPoint> getAllTrackPoint(@RequestParam(name = "trackId") Integer trackId) {
		if (trackId != null) {
			return trackPointService.getAllByTrackId(trackId);

		} else {
			logger.error("getAllTrackPoint with trackId is null");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/waypoint")
	public List<WayPoint> getAllWaypoint(@RequestParam(name = "trackId") @NonNull Integer trackId) {
		if (trackId != null) {
			return wayPointService.getAllByTrackId(trackId);
		} else {
			logger.error(" getAllWaypoint with trackId is null");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/download")
	public String getLinkDownload(@RequestParam(name = "trackId") @NonNull Integer trackId) {
		// TODO query data in Track model, get link from CDN and return link (implement
		// when have CDN - example AWS S3)
		if (trackId != null) {
			return "download link";
		} else {
			logger.error("getLinkDownload with trackId is null");
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

}
