package fr.eql.ai114.ngouriou.localappback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long residentId;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String address;

//    @OneToMany
//    private List<Message> messages;
//
//    @OneToMany
//    private List<Post> posts;
}
