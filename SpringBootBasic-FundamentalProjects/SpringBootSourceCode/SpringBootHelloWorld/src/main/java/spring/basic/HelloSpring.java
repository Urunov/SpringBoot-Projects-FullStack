package spring.basic;

public class HelloSpring {
    //
    private final Long id;
    private final String greeting;

    public Long getId() {
        return id;
    }

    public String getGreeting() {
        return greeting;
    }

    public HelloSpring(Long id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }
}
