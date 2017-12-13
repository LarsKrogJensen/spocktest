package se.lars;

public class Service {
    private final Dependency dep;

    public Service(Dependency dep) {
        this.dep = dep;
    }

    public String update(String value) {
        return dep.update(value);
    }
}
