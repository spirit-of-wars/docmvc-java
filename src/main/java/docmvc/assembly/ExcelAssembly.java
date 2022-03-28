package docmvc.assembly;

import docmvc.assembly.info.DocumentInfo;

public class ExcelAssembly extends AbstractDocumentAssembly {



    private static final String Xlsx = "Xlsx"; // todo remove?

    public ExcelAssembly(DocumentInfo documentInfo) {
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
