package kt.demo.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import kt.demo.model.Track;

public interface TrackRepository extends Repository<Track, Integer> {

	Track save(Track track) throws DataAccessException;

	Track findById(Integer id);
	
	
	@Transactional(readOnly = true)
	List<Track> findByOrderByIdDesc(Pageable pageable);
}
