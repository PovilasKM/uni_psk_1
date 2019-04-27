package lt.vu.usecases.async;

import java.util.concurrent.Future;

public interface AsyncInterface {

    Future<String> asyncMethod();
}
