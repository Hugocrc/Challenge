package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Movie;

// Esta anotação marca a classe como um controlador Spring que lida com solicitações HTTP e retorna respostas em formato JSON.
@RestController
// Esta anotação define um prefixo de URL para todas as rotas definidas neste controlador.
@RequestMapping("/api/user")
public class MovieController {
 
    @Autowired
    private MovieRepository movieRepository;
        
    // Método que retorna uma lista de todos os filmes
    @GetMapping
    public List<Movie> findAllMovies() {
        Iterable<Movie> iterableMovies = movieRepository.findAll();
        List<Movie> movies = new ArrayList<>();

        // Iterar sobre o Iterable e adicionar cada elemento à lista
        for (Movie movie : iterableMovies) {
            movies.add(movie);
        }

        return movies;
    }
 
    // Método que retorna um filme através do seu id
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable(value = "id") long id) {
        Optional<Movie> movie = movieRepository.findById(id);
    
        if(movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método que retorna uma lista de filmes com a mesma data
    @GetMapping("/byDate/{date}")
    public List<Movie> findMoviesByDate(@PathVariable(value = "date") String date) {
        List<Movie> movies = findAllMovies();
        List<Movie> moviesDate = new ArrayList<Movie>();

        for(Movie m: movies){
            if(m.getDate().equals(date)){
                moviesDate.add(m);
            }
        }

        return moviesDate;
    }

    // Método que cria um novo filme
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody Map<String, String> body){
        long lastIdLong = movieRepository.findMaxId(); // Obtém o valor long
        int lastId = (Math.toIntExact(lastIdLong)) + 1; // Converte para int
        String name = body.get("name");
        String date = body.get("date");
        String rating = body.get("rating");
        String revenue = body.get("revenue");
        return movieRepository.save(new Movie(lastId, name, date, rating, revenue));
    }

    // Método que atualiza todas as informações de um filme
    @PutMapping("/movie/{id}")
    public Movie changeInfMovie(@PathVariable(value = "id") long id, @RequestBody Movie updatedMovie){
        Optional<Movie> movieOptional = movieRepository.findById(id);

        Movie existingMovie = movieOptional.get();
        existingMovie.setName(updatedMovie.getName());
        existingMovie.setDate(updatedMovie.getDate());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setRevenue(updatedMovie.getRevenue());

        return movieRepository.save(existingMovie);
    }

    // Método que atualiza algumas informações de um filme existente com base no que foi fornecido no corpo da solicitação
    @PatchMapping("/movie/{id}")
    public Movie changeSomeInfMovie(@PathVariable(value = "id") long id, @RequestBody Movie updatedMovie){
        Optional<Movie> movieOptional = movieRepository.findById(id);

        Movie existingMovie = movieOptional.get();
        // Atualiza apenas os campos que foram fornecidos no corpo da solicitação
        if (updatedMovie.getName() != null) {
            existingMovie.setName(updatedMovie.getName());
        }
        if (updatedMovie.getDate() != null) {
            existingMovie.setDate(updatedMovie.getDate());
        }
        if (updatedMovie.getRating() != null) {
            existingMovie.setRating(updatedMovie.getRating());
        }
        if (updatedMovie.getRevenue() != null) {
            existingMovie.setRevenue(updatedMovie.getRevenue());
        }

        return movieRepository.save(existingMovie);
    }

    // Método que apaga um filme
    @DeleteMapping("movie/{id}")
    public boolean delete(@PathVariable String id){
        long movieId = Long.parseLong(id);
        Optional<Movie> movieOptional = movieRepository.findById(movieId);

        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movieRepository.delete(movie);
            return true;
        } else {
            return false; // Retorna false se o filme não foi encontrado
        }
    }
}
