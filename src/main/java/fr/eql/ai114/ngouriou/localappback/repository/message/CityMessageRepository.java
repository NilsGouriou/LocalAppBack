package fr.eql.ai114.ngouriou.localappback.repository.message;

import fr.eql.ai114.ngouriou.localappback.entity.message.CityMessage;
import fr.eql.ai114.ngouriou.localappback.entity.post.CityPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityMessageRepository extends JpaRepository<CityMessage, Long> {

    List<CityMessage> findCityMessagesByCityPost_CityPostId(long id);
}
