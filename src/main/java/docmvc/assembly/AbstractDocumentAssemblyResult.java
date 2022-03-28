package docmvc.assembly;

import docmvc.assembly.info.DocumentInfo;

public abstract class AbstractDocumentAssemblyResult implements DocumentAssemblyResultInterface {

    protected Object driver;

    protected DocumentInfo documentInfo;

    public AbstractDocumentAssemblyResult(DocumentInfo documentInfo, Object driver) {
        this.driver = driver;
        this.documentInfo = documentInfo;
    }

    public AbstractDocumentAssemblyResult(DocumentInfo documentInfo) {
        this.documentInfo = documentInfo;
    }

    @Override
    public String getTmpDocumentPath() {
        return this.documentInfo.getTmpDocumentPath();
    }

    @Override
    public String getDocumentName() {
        return this.documentInfo.getDocumentName();
    }
}
