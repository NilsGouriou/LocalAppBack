package fr.eql.ai114.ngouriou.localappback.entity.post;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualPost {

    @Id
    private long individualPostId;
    private String title;
    private String body;

    private Date addDate;
    private Date removeDate;

    @ManyToOne
    private User author;
}