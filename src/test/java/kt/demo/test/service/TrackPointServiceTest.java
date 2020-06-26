package kt.demo.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import kt.demo.model.TrackPoint;
import kt.demo.repository.TrackPointRepository;
import kt.demo.service.ITrackPointService;
import kt.demo.service.TrackPointServiceImpl;

@SpringBootTest
public class TrackPointServiceTest {
	@Mock
    private TrackPointRepository trackPointRepository;

    @InjectMocks
    private ITrackPointService trackPointService = new TrackPointServiceImpl();
    
    @BeforeEach
    void setMockOutput() {
    	Integer trackId = 1;
    	List<TrackPoint> result = new ArrayList<TrackPoint>();
    	TrackPoint trackpoint0 = new TrackPoint();
    	TrackPoint trackpoint1 = new TrackPoint();
    	result.add(trackpoint0);
    	result.add(trackpoint1);
    	
        when(trackPointRepository.findByTrackId(trackId)).thenReturn(result);
    }
    @DisplayName("Test get waypoint by trackId trackService")
    @Test
    void testGetLastest() {
        assertEquals(2, trackPointService.getAllByTrackId(1).size());
    }


}
