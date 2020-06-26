package kt.demo.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {
	
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void getLastestTrack() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/lastest?pageIndex=0&numItem=10").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    
    @Test
    public void getAllTrackPoint() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/trackpoint?trackId=1").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    
    @Test
    public void getAllTrackPointNull() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/trackpoint").toString(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }
    
    @Test
    public void getAllWaypoint() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/waypoint?trackId=1").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
    
    @Test
    public void getAllWaypointNull() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/waypoint?trackId=").toString(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }

    @Test
    public void getLinkDownloadTest() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/download?trackId=1").toString(), String.class);
        assertEquals("download link", response.getBody());

    }

    @Test
    public void getLinkDownloadTestNull() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + port + "/api/download").toString(), String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    }
}
