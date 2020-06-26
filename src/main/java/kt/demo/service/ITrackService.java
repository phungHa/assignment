package kt.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import kt.demo.model.Track;

public interface ITrackService {
	public Integer saveAndStoreCDN(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException;
	public List<Track> getLastest(int pageIndex, int numItemPerPage);

}
