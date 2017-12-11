package se.lars;

public class Service {
    private final Dependency dep;

    public Service(Dependency dep) {
        this.dep = dep;
    }

    public void update(String value) {
        dep.update(value);
    }
}
