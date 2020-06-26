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

import kt.demo.model.WayPoint;
import kt.demo.repository.WayPointRepository;
import kt.demo.service.IWayPointService;
import kt.demo.service.WayPointServiceImpl;

@SpringBootTest
public class WayPointServiceTest {
	@Mock
    private WayPointRepository wayPointRepository;

    @InjectMocks
    private IWayPointService wayPointService = new WayPointServiceImpl();
    
    @BeforeEach
    void setMockOutput() {
    	Integer trackId = 1;
    	List<WayPoint> result = new ArrayList<WayPoint>();
    	WayPoint waypoint0 = new WayPoint();
    	WayPoint waypoint1 = new WayPoint();
    	result.add(waypoint0);
    	result.add(waypoint1);
    	
        when(wayPointRepository.findByTrackId(trackId)).thenReturn(result);
    }
    @DisplayName("Test get waypoint by trackId trackService")
    @Test
    void testGetLastest() {
        assertEquals(2, wayPointService.getAllByTrackId(1).size());
    }


}
