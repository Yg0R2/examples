package yg0r2.examples.maven;

import yg0r2.examples.maven.commons.DummyService;

public class DummyMain {

    private static final DummyService DUMMY_SERVICE = new DummyService();

    public static void main(String[] args) {
        System.out.println(DUMMY_SERVICE.getGreetingsMessage());
    }

}
