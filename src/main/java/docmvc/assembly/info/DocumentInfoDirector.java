package docmvc.assembly.info;

public class DocumentInfoDirector {

    public DocumentInfo buildDocumentInfo(DocumentInfoBuilderInterface documentInfoBuilder) {
        documentInfoBuilder.init();
        documentInfoBuilder.initParams();
        documentInfoBuilder.initDocumentExt();
        documentInfoBuilder.initTmpDocumentPath();

        return documentInfoBuilder.getDocumentInfo();
    }
}
