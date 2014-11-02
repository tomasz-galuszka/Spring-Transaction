package declarative;

/**
 * Created by tomasz on 30.10.14.
 */
public class DefaultFooService implements FooService {
    @Override
    public Foo getFoo(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insertFoo(Foo foo) {
        throw new UnsupportedOperationException();
    }
}
