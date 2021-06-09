package yg0r2.examples.resilience.client.decorator.model;

public class ResilienceConfig {

    private CircuitBreaker circuitBreaker;

    public CircuitBreaker getCircuitBreaker() {
        return circuitBreaker;
    }

    public void setCircuitBreaker(CircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

}
