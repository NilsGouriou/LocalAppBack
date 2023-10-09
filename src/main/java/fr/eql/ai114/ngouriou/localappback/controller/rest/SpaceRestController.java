package fr.eql.ai114.ngouriou.localappback.controller.rest;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.entity.post.AssociationPost;
import fr.eql.ai114.ngouriou.localappback.entity.post.CityPost;
import fr.eql.ai114.ngouriou.localappback.entity.post.IndividualPost;
import fr.eql.ai114.ngouriou.localappback.repository.post.AssociationPostRepository;
import fr.eql.ai114.ngouriou.localappback.repository.post.CityPostRepository;
import fr.eql.ai114.ngouriou.localappback.repository.post.IndividualPostRepository;
import fr.eql.ai114.ngouriou.localappback.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/space")
@CrossOrigin("${front.url}")
public class SpaceRestController {

    UserDao userDao;
    CityPostRepository cityPostRepository;
    AssociationPostRepository associationPostRepository;
    IndividualPostRepository individualPostRepository;

    @GetMapping("user/{id}")
    public User find(@PathVariable long id) {
        return userDao.findById(id);
    }

    @GetMapping("user/{id}/city/messages")
    public User findMessagesByUser(@PathVariable long id) {
        return userDao.findById(id);
    }

    @GetMapping("user/{id}/city/posts")
    public List<CityPost> findCityPostsByUser(@PathVariable long id) {
        return cityPostRepository.findByAuthor(id);
    }

    @GetMapping("user/{id}/association/posts")
    public List<AssociationPost> findAssociationPostsByUser(@PathVariable long id) {
        return associationPostRepository.findByAuthor(id);
    }

    @GetMapping("user/{id}/individual/posts")
    public List<IndividualPost> findIndividualPostsByUser(@PathVariable long id) {
        return individualPostRepository.findByAuthor(id);
    }

    @Autowired
    public void setUserService(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setCityPostRepository(CityPostRepository cityPostRepository) {
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

}
