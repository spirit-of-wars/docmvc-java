package docmvc.assembly.info;

import java.util.HashMap;

public class DocumentInfo {

    private HashMap<String, String> model;

    private String viewPath;

    private String templatePath;

    private String documentExt;

    private String documentName;

    private String tmpDocumentPath;

    private HashMap<String, Object> params;

    public HashMap<String, String> getModel() {
        return model;
    }

    public DocumentInfo setModel(HashMap<String, String> model) {
        this.model = model;
        return this;
    }

    public String getViewPath() {
        return viewPath;
    }

    public DocumentInfo setViewPath(String viewPath) {
        this.viewPath = viewPath;
        return this;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public DocumentInfo setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
        return this;
    }

    public String getDocumentExt() {
        return documentExt;
    }

    public DocumentInfo setDocumentExt(String documentExt) {
        this.documentExt = documentExt;
        return this;
    }

    public String getDocumentName() {
        return documentName;
    }

    public DocumentInfo setDocumentName(String documentName) {
        this.documentName = documentName;
        return this;
    }

    public String getTmpDocumentPath() {
        return tmpDocumentPath;
    }

    public DocumentInfo setTmpDocumentPath(String tmpDocumentPath) {
        this.tmpDocumentPath = tmpDocumentPath;
        return this;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public DocumentInfo setParams(HashMap<String, Object> params) {
        this.params = params;
        return this;
    }
}
