package docmvc.assembly;

import java.io.FileNotFoundException;

public interface DocumentAssemblyInterface {

    DocumentAssemblyResultInterface buildDocument() throws FileNotFoundException;
}
