package fr.eql.ai114.ngouriou.localappback.controller.rest;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.entity.message.CityMessage;
import fr.eql.ai114.ngouriou.localappback.entity.post.AssociationPost;
import fr.eql.ai114.ngouriou.localappback.entity.post.CityPost;
import fr.eql.ai114.ngouriou.localappback.entity.post.IndividualPost;
import fr.eql.ai114.ngouriou.localappback.repository.message.CityMessageRepository;
import fr.eql.ai114.ngouriou.localappback.repository.post.AssociationPostRepository;
import fr.eql.ai114.ngouriou.localappback.repository.post.CityPostRepository;
import fr.eql.ai114.ngouriou.localappback.repository.post.IndividualPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/post/")
public class PostController {

    private CityPostRepository cityPostRepository;
    private AssociationPostRepository associationPostRepository;
    private IndividualPostRepository individualPostRepository;
    private CityMessageRepository cityMessageRepository;

    @GetMapping("/city")
    public List<CityPost> getAllCityPosts() {
        return cityPostRepository.findAll();
    }

    @GetMapping("/association")
    public List<AssociationPost> getAllAssociationPosts() {
        return associationPostRepository.findAll();
    }

    @GetMapping("/individual")
    public List<IndividualPost> getAllIndividualPosts() {
        return individualPostRepository.findAll();
    }

    @PostMapping("/city")
    public CityPost createCityPost(@RequestBody CityPost cityPost) {
//        cityPostRepository.saveCustom();
        return cityPostRepository.save(cityPost);
    }

    @GetMapping("/city/{id}")
    public CityPost getCityPostById(@PathVariable long id) {
        return cityPostRepository.findByCityPostId(id);
    }

    @GetMapping("/city/{id}/messages")
    public List<CityMessage> getCityMessageByPostId(@PathVariable long id) {
        return cityMessageRepository.findCityMessagesByCityPost_CityPostId(id);
    }

    @PostMapping("/city/message")
    public CityMessage createCityMessage(@RequestBody CityMessage cityMessage) {
        return cityMessageRepository.save(cityMessage);
    }


    @Autowired
    public void setSpaceService(CityPostRepository cityPostRepository) {
        this.cityPostRepository = cityPostRepository;
    }
    @Autowired
    public void setAssociationPostRepository(AssociationPostRepository associationPostRepository) {
        this.associationPostRepository = associationPostRepository;
    }
    @Autowired
    public void setIndividualPostRepository(IndividualPostRepository individualPostRepository) {
        this.individualPostRepository = individualPostRepository;
    }

    @Autowired
    public void setCityPostRepository(CityMessageRepository cityMessageRepository) {
        this.cityMessageRepository = cityMessageRepository;
    }
}
