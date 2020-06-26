package kt.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kt.demo.model.WayPoint;

public interface WayPointRepository extends Repository<WayPoint, Integer> {

	@Query("FROM WayPoint wp where wp.track.id = :id")
	@Transactional(readOnly = true)
	List<WayPoint> findByTrackId(@Param("id") int trackId);
}
