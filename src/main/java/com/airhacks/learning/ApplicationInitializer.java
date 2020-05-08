package com.airhacks.learning;

import com.airhacks.learning.dao.service.PersonDAOService;
import com.airhacks.learning.dao.service.TweetDAOService;
import com.airhacks.learning.model.Person;
import com.airhacks.learning.model.Tweet;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kemal BEYAZ
 * @created 08/05/2020
 */
@Startup
@Singleton
public class ApplicationInitializer {

    @Inject
    TweetDAOService tweetDAOService;

    @Inject
    PersonDAOService personDAOService;

    @PostConstruct
    public void init() {
        // Perform action during application's startup
        saveSamplePerson();
        saveSampleTweets();
    }

    public void saveSamplePerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Bekir"));
        list.add(new Person("Ömer"));

        personDAOService.saveAll(list);
    }

    public void saveSampleTweets() {
        List<Tweet> list = personDAOService.getAll()
                .stream()
                .limit(5)
                .map(person -> new Tweet("Message about something, like complaints about systems.", person))
                .collect(Collectors.toList());

        tweetDAOService.saveAll(list);
    }
}
