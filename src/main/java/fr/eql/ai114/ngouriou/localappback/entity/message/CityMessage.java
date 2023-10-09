package fr.eql.ai114.ngouriou.localappback.entity.message;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.entity.post.CityPost;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private long cityMessageId;
    private String body;

    private Date addDate;
    private Date removeDate;

    @ManyToOne
    private User author;

    @ManyToOne
    private CityPost cityPost;
}
