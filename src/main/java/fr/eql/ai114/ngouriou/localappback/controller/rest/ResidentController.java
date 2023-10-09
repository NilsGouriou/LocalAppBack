package fr.eql.ai114.ngouriou.localappback.controller.rest;

import fr.eql.ai114.ngouriou.localappback.entity.Resident;
import fr.eql.ai114.ngouriou.localappback.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ResidentController {

    @Autowired
    private ResidentRepository residentRepository;

    @GetMapping("/residents")
    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    @PostMapping("/residents")
    public Resident createResident(@RequestBody Resident resident) {
        return residentRepository.save(resident);
    }


}
