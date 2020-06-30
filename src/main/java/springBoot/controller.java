package springBoot;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
	
	@Autowired
	MoveRatingsRepository movieRatingRepository;
	
	@GetMapping("/")
	// Starting page : Includes navigator
	public String main() {
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String displayMovies(Model model) {
		Iterable<MovieRatings> movieRatings = movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		
		model.addAttribute("movieRatings", movieRatings);
		
		return "movie_display";
	}
	
	@GetMapping("/movies/new")
	public String movieRatingForm(Model model) {
		MovieRatings movieRatings = new MovieRatings();
		model.addAttribute("movieRatings", movieRatings);
		
		return "movie_form";
	}

	@PostMapping("/movies/new")
	public String processMovieRatingForm(@Valid MovieRatings movieRating, BindingResult result, Model model) {
		
		System.out.println("***************" + movieRating.getId() + "  "+ movieRating.getMovieTitle() + "  " + movieRating.getRating() + "  " + movieRating.getUserName() );
		
		if (result.hasErrors()) {
			return "errorPage";
		} else {
			System.out.println("<! ------- NO ERRORS FOUND IN RESULT ------- >");
			movieRating.setDateTime(new java.util.Date().toString());
			movieRatingRepository.save(movieRating);
		}
		
		return "redirect:/movies/new";
	}
	
	@GetMapping("/movies/delete")
	public String deleteRatings(Model model) {
		
		movieRatingRepository.truncateTable();
		
		return "deleteSuccess";
	}


}
