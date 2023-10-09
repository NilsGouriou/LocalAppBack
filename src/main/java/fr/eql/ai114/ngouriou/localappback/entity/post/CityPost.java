package fr.eql.ai114.ngouriou.localappback.entity.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.entity.message.CityMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long cityPostId;
    private String title;
    private String body;

    private Date addDate;
    private Date removeDate;

    @ManyToOne
    private User author;

//    @OneToMany
////    @LazyCollection(LazyCollectionOption.FALSE)
//    private List<CityMessage> cityMessages;

}
