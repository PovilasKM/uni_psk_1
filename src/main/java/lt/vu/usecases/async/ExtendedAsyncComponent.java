package lt.vu.usecases.async;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.io.Serializable;

@Specializes
@ApplicationScoped
public class ExtendedAsyncComponent extends AsyncComponent implements Serializable {

}