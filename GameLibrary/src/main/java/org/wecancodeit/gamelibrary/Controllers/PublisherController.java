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
import org.wecancodeit.gamelibrary.Models.PublisherModel;
import org.wecancodeit.gamelibrary.Repositories.PublisherRepository;
import org.wecancodeit.gamelibrary.payload.CreatePublisher;

import jakarta.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/publisher")
public class PublisherController {

    @Resource
    private PublisherRepository repository;

    public PublisherController(PublisherRepository repository) {
        this.repository = repository;
    }

//    @RequestMapping({ "", "/", "/publisher" })
//    public String getAllPublishers(Model model) {
//        model.addAttribute("publishers", repository.findAll());
//        return "displayPublishersView";
//    }

//    @GetMapping("/publisher/gameDetails/{id}")
//    public String getPublisherDetails(@PathVariable Long id, Model model) {
//        model.addAttribute("publisher", repository.findById(id).get());
//        return "gameDetailsView";
//    }
//
//    @GetMapping("/publisher/deleteDetails/{id}")
//    public String deletePublisher(@PathVariable Long id, Model model) {
//        repository.deleteById(id);        
//        return "redirect:/publisher";
//    }
    
    
  @GetMapping
  public List<PublisherModel> getPublisherDetails() {
      return repository.findAll();
  }
  
  @GetMapping("/{id}")
  public PublisherModel getPublisherDetailsByID(@PathVariable("id") long id) {
      return repository.findById(id).get();
  }
    
  @PostMapping
  public PublisherModel savePublisher(@RequestBody CreatePublisher data) {
	  PublisherModel model = new PublisherModel(data.getName());
      return repository.save(model);
  }
  
  @PutMapping("/{id}")
  public PublisherModel editPublisher(@PathVariable("id") long id, @RequestBody CreatePublisher data) {
	  PublisherModel model = repository.findById(id).get();
	  model.setName(data.getName());
      return repository.save(model);
  }
  
  @DeleteMapping("/{id}")
  public void savePublisher(@PathVariable("id") long id) {
      repository.deleteById(id);
  }
    
}
