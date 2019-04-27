package lt.vu.usecases.controllers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.async.AsyncComponent;
import lt.vu.usecases.interceptors.MyInterceptor;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named
@ViewScoped
@Slf4j
@MyInterceptor
public class AsyncController implements Serializable {

    @Inject
    private AsyncComponent asyncComponent;

    @Getter
    private Future<String> resultInFuture = null;

    @Getter
    private String resultString;

    public void callAsyncMethod() throws ExecutionException, InterruptedException {
        if (resultInFuture == null) {
            resultInFuture = asyncComponent.asyncMethod();
            resultString = "Result is ready? " + resultInFuture.isDone();
        } else {
            if (resultInFuture.isDone()) {
                String result = resultInFuture.get();
                resultInFuture = null;
                resultString = "Result is finally ready, and it is: " + result;
            } else {
                resultString = "Result is not yet ready... please wait a moment...";
            }
        }
    }

}