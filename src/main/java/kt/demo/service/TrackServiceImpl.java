package kt.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import kt.demo.helper.GPXHandler;
import kt.demo.model.Track;
import kt.demo.repository.TrackRepository;

/**
 * 
 * @author phunghaminh
 *
 */
@Service
public class TrackServiceImpl implements ITrackService{
	
	private final Logger logger = LoggerFactory.getLogger(TrackServiceImpl.class);
	
	@Autowired
	private TrackRepository trackRepository;

	public Integer saveAndStoreCDN(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		// TODO push file to CDN (implement when have CDN - example AWS S3), and add
		// path to Track model, using for download later
		SAXParserFactory saxParseFactory = SAXParserFactory.newInstance();
		SAXParser saxParse = saxParseFactory.newSAXParser();
		GPXHandler gpxHandler = new GPXHandler();
		saxParse.parse(inputStream, gpxHandler);
		Track track = gpxHandler.getTrack();
		track.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		trackRepository.save(track);
		logger.info("save");
		return track.getId();
	}
	
	public List<Track> getLastest(int pageIndex, int numItemPerPage){
		Pageable page = PageRequest.of(pageIndex,numItemPerPage);
		logger.info("get lastest by page {}",pageIndex);
		return trackRepository.findByOrderByIdDesc(page);
	}

}
