package patterns.decorator1.realisation2;

public class Decorator implements Component {
    protected Component component;

    public Decorator (Component component) {
this.component = component;

    }

    @Override
    public void operation() {
        component.operation();
    }
}
