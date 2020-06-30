package springBoot;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import javax.transaction.Transactional;

public interface MoveRatingsRepository extends CrudRepository<MovieRatings, Long>{


	@Query("select m from MovieRatings m order by movieTitle, dateTime desc")
	List<MovieRatings> findAllMovieRatingsOrderByTitleDateDesc();
	
	@Query(value = "TRUNCATE TABLE movie_ratings", nativeQuery = true)
	@Modifying
    @Transactional
	void truncateTable();
	

}
