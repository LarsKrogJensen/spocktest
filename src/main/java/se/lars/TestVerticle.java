package se.lars;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class TestVerticle extends AbstractVerticle{
    private final Service service;


    public TestVerticle(Service service) {
        this.service = service;
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.setTimer(1000, __ -> {
            String hello = service.update("hello");
            String hello2 = service.update("hello");
            startFuture.complete();
        });
    }
}
