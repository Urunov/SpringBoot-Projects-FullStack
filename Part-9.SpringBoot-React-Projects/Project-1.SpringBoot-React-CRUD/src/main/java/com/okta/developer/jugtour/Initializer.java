package com.okta.developer.jugtour;

import com.okta.developer.jugtour.model.Event;
import com.okta.developer.jugtour.model.Group;
import com.okta.developer.jugtour.repository.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @Author: apple
 * @created on 13/07/2020
 * @Project is SpringReactCrud
 */
@Component
 class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {

        Stream.of("Hamdamboy Jug", "Urunov JUG", "Seattle JUG", "Richard JUG")
                .forEach(
                name -> repository.save(new Group(name)));

        Group djug = repository.findByName("Hamdamboy Jug");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2020-07-10T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));

        repository.save(djug);

        repository.findAll().forEach(System.out::println);

    }
}

//https://github.com/oktadeveloper/okta-spring-boot-react-crud-example/blob/master/src/main/java/com/okta/developer/jugtours/web/UserController.java
