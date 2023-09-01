package org.wecancodeit.gamelibrary.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.gamelibrary.Models.BoardGameModel;
import org.wecancodeit.gamelibrary.Models.PublisherModel;
import org.wecancodeit.gamelibrary.Repositories.BoardGameRepository;
import org.wecancodeit.gamelibrary.Repositories.PublisherRepository;
import org.wecancodeit.gamelibrary.payload.CreateBoardGame;

import jakarta.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/board-game")
public class BoardGameController {
	@Resource
    private PublisherRepository publisherRepository;
	
	@Resource
    private BoardGameRepository repository;

    public BoardGameController(PublisherRepository publisherRepository, BoardGameRepository repository) {
        this.publisherRepository = publisherRepository;
        this.repository = repository;
    }
    
      
    @PostMapping
    public BoardGameModel saveBoardGame(@RequestBody CreateBoardGame data) {
    	PublisherModel publisher = publisherRepository.findById(data.getPublisherId()).get();
  	  	BoardGameModel model = new BoardGameModel(data.getName(), data.getDescription(), data.getImageUrl(), publisher);
        return repository.save(model);
    }
    
    @GetMapping
    public List<BoardGameModel> getAllBoardGame() {
    	List<BoardGameModel> model = repository.findAll();
        return model;
    }
    
    @GetMapping("/{id}")
    public BoardGameModel getBoardGameById(@PathVariable("id") long id) {
        return repository.findById(id).get();
    }
    
    @PutMapping("/{id}")
    public BoardGameModel editBoardGame(@PathVariable("id") long id, @RequestBody CreateBoardGame data) {
    	BoardGameModel model = repository.findById(id).get();
  	  	model.setName(data.getName());
	  	model.setDescription(data.getDescription());
	  	model.setImageUrl(data.getImageUrl());
        return repository.save(model);
    }
    
    @DeleteMapping("/{id}")
    public void saveBoardGame(@PathVariable("id") long id) {
        repository.deleteById(id);
    }
}
