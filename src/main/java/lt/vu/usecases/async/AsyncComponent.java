package lt.vu.usecases.async;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
public class AsyncComponent implements AsyncInterface, Serializable {

    @Futureable
    public Future<String> asyncMethod() {
        System.out.println("Starts working on a really big task, like, really ...");
        try {
            Thread.sleep(10000); // sleep for 10 seconds
        } catch (InterruptedException e) {
            // noop
        }
        System.out.println("Big task completed. Or is it?");
        return new AsyncResult<>("BIG result");
    }
}