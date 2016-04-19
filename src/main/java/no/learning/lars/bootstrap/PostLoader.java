package no.learning.lars.bootstrap;

import no.learning.lars.entity.Post;
import no.learning.lars.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Lars on 17.04.2016.
 */

/**
 * This class implements the ApplicationListener interface.
 * The class is called when the ContextRefresedEvent occurs during startup
 * And loads predefined object into the database.
 * Another approach could be to use an sql file and tell Hibernate to load the data.
 */
@Component
public class PostLoader implements ApplicationListener<ContextRefreshedEvent> {
    private PostRepository postRepository;

    private static final Logger logger = LoggerFactory.getLogger(PostLoader.class);

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Post post1 = new Post();
        post1.setTopic("Selger min brukte kopp");
        post1.setPrice(100);
        post1.setDescription("Etter mye omtanke har jeg valgt å selge den bruke koppen min");
        post1.setCategory("Diverse");
        post1.setImgUrl("https://gamezone.no/Media/Cache/Images/5/7/WEB_Image%20Star%20Wars%20Darth%20Vader%20Keramikk%20Krus%20Kopp1620824297.Jpeg?1460678400133");
        postRepository.save(post1);

        logger.debug("Saved post with id: " + post1.getId());

        Post post2 = new Post();
        post2.setTopic("Topp klokke selges");
        post2.setPrice(1500);
        post2.setDescription("Min fantastiske å trofaste klokke søker ny eier");
        post2.setCategory("Diverse");
        post2.setImgUrl("http://miniimg4.rightinthebox.com/images/384x384/201403/bvwoaz1394702302976.jpg");
        postRepository.save(post2);

        logger.debug("Saved post with id: " + post2.getId());
    }
}
