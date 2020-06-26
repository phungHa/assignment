package kt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kt.demo.model.TrackPoint;

public interface TrackPointRepository extends Repository<TrackPoint, Integer> {

	@Query("FROM TrackPoint tp where tp.track.id = :id")
	@Transactional(readOnly = true)
	List<TrackPoint> findByTrackId(@Param("id") int trackId);
}
