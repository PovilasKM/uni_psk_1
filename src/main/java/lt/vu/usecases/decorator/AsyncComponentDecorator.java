package lt.vu.usecases.decorator;

import lt.vu.usecases.async.AsyncComponent;
import lt.vu.usecases.async.AsyncInterface;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.concurrent.Future;

@Decorator
public class AsyncComponentDecorator implements AsyncInterface {

    @Inject
    @Delegate
    @Any
    private AsyncComponent asyncComponent;

    public Future<String> asyncMethod() {
        System.out.println("Decorator before asyncMethod");
        return asyncComponent.asyncMethod();
    }
}