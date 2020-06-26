package kt.demo.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.xml.sax.SAXException;

import kt.demo.model.Track;
import kt.demo.repository.TrackRepository;
import kt.demo.service.ITrackService;
import kt.demo.service.TrackServiceImpl;

@SpringBootTest
public class TrackServiceTest {
	@Mock
    private TrackRepository trackRepository;

    @InjectMocks
    private ITrackService trackService = new TrackServiceImpl();

    @BeforeEach
    void setMockOutput() {
    	Pageable page = PageRequest.of(3,10);
        List<Track> result = new ArrayList<Track>();
        Track item = new Track();
        item.setId(1);
        result.add(item);
    	
        when(trackRepository.findByOrderByIdDesc(page)).thenReturn(result);
        when(trackRepository.save(Mockito.any(Track.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @DisplayName("Test get Lastest TrackRepository")
    @Test
    void testGetLastest() {
        assertEquals(1, trackService.getLastest(3, 10).get(0).getId());
    }
    
    @DisplayName("Test save track TrackRepository")
    @Test
    void testGet() throws ParserConfigurationException, SAXException, IOException {
    	String initialString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
    			"<gpx xmlns=\"http://www.topografix.com/GPX/1/1\" version=\"1.1\" creator=\"OruxMaps v.7.1.6 Donate\">\n" + 
    			"	<metadata>\n" + 
    			"		<name>Bardenas Reales</name>\n" + 
    			"		<desc>description </desc>\n" + 
    			"		<time>2017-10-22T09:41:33Z</time>\n" + 
    			"	</metadata>\n" + 
    			"	<wpt lat=\"42.2205377\" lon=\"-1.4564538\">\n" + 
    			"		<name>Sorteamos por arriba</name>\n" + 
    			"		<sym>/static/wpt/Waypoint</sym>\n" + 
    			"	</wpt>"+
    			"<trk>"+
    			"<trkseg>"+
    			"	<trkpt lat=\"42.2208895\" lon=\"-1.4580696\">"+
    			"		<ele>315.86</ele>"+
    			"		<time>2017-10-22T09:41:38+07:00</time>"+
    			"	</trkpt>"+
    			"</trkseg>"+
    			"</trk>"+
    			"</gpx>";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
        assertEquals(null, trackService.saveAndStoreCDN(targetStream));
    }
    
    
    

}
