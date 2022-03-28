package docmvc.assembly;

import docmvc.assembly.info.DocumentInfo;

public class DocAssembly extends AbstractDocumentAssembly {



    public DocAssembly(DocumentInfo documentInfo) {
        super(documentInfo);
    }

    @Override
    public DocumentAssemblyResultInterface buildDocument() {
        //todo
        return null;
    }

    public static class AssemblyResult extends AbstractDocumentAssemblyResult {

        public AssemblyResult(DocumentInfo documentInfo) {
            super(documentInfo);
        }

        @Override
        public void download() {
            //todo download
        }
    }
}
