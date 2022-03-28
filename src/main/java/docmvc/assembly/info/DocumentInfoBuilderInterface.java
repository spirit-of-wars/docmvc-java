package docmvc.assembly.info;

public interface DocumentInfoBuilderInterface {

    void initParams();

    void initDocumentExt();

    void init();

    void initTmpDocumentPath();

    DocumentInfo getDocumentInfo();
}
