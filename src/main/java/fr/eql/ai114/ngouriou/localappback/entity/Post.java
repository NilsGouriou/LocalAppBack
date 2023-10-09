package fr.eql.ai114.ngouriou.localappback.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private long postId;
    private String title;
    private String body;

    @ManyToOne
    private User author;
}
