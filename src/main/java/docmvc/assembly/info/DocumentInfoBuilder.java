package docmvc.assembly.info;

import docmvc.assembly.constraint.ExtensionConstraintInterface;
import docmvc.cartridge.SetupCartridgeInterface;
import docmvc.cartridge.SetupTemplateInterface;
import docmvc.utils.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class DocumentInfoBuilder implements DocumentInfoBuilderInterface {

    private static final String DEFAULT_VIEW_FOLDER_NAME = "view";
    private static final String DEFAULT_TEMPLATE_FOLDER_NAME = "template";

    private SetupCartridgeInterface cartridge;

    private DocumentInfo documentInfo;

    private ExtensionConstraintInterface extensionConstraint;

    private String userCartridgeFolderPath;


    public DocumentInfoBuilder(SetupCartridgeInterface cartridge, ExtensionConstraintInterface extensionConstraint) {
        this.cartridge = cartridge;
        this.extensionConstraint = extensionConstraint;
        this.documentInfo = new DocumentInfo();
    }

    @Override
    public DocumentInfo getDocumentInfo() {
        return this.documentInfo;
    }

    @Override
    public void initDocumentExt() {
        String setupDocumentExt = this.cartridge.setupDocumentExt();
        String[] allowedExt = this.extensionConstraint.allowedExt();
        String documentExt = (setupDocumentExt == null || setupDocumentExt.isEmpty())
                ? this.extensionConstraint.defaultExt() : this.cartridge.setupDocumentExt();

        if (!Arrays.asList(allowedExt).contains(documentExt)) {
            //todo exception
//            throw new InitExtException(sprintf("Document extension '%s' is not allowed", $documentExt));
        }
        this.documentInfo.setDocumentExt(documentExt);
        this.documentInfo.setDocumentName(this.generateDocumentName(documentExt));
    }

    @Override
    public void init() {
        HashMap<String, String> model = this.cartridge.setupModel();
        if (model == null || model.isEmpty()) {
            //todo exception
//            throw new InitModelException('Model data was not founded');
        }
        this.documentInfo.setModel(model);

        String viewPath = StringUtils.isEmpty(this.cartridge.setupView()) ? null : this.getViewFolderPath() + this.cartridge.setupView();

        File viewFile = new File(viewPath);
        if (!StringUtils.isEmpty(viewPath) && !viewFile.isFile()) {
            //todo exception
//            throw new InitViewException(sprintf("View file was not founded: '%s'", $viewPath));
        }
        this.documentInfo.setViewPath(viewPath);

        if (this.cartridge instanceof SetupTemplateInterface) {
            String setupTemplate = ((SetupTemplateInterface) this.cartridge).setupTemplate();
            String templatePath = StringUtils.isEmpty(setupTemplate)
                    ? null : this.getTemplateFolderPath() + setupTemplate;
            File templateFile = new File(templatePath);
            if (!StringUtils.isEmpty(templatePath) && !templateFile.isFile()) {
                //todo exception
//            throw new InitTemplateException(sprintf("Template file was not founded: '%s'", $templatePath));
            }
            this.documentInfo.setTemplatePath(templatePath);
        }
    }

    @Override
    public void initTmpDocumentPath() {
        String tmpdir = System.getProperty("java.io.tmpdir");
        String uniqIdStr = UUID.randomUUID().toString();
        String documentPath = tmpdir + File.separator + uniqIdStr + "." + this.documentInfo.getDocumentExt();
        this.documentInfo.setTmpDocumentPath(documentPath);
    }

    @Override
    public void initParams() {
        if (this.validateParams(this.cartridge.getParams())) {
            this.documentInfo.setParams(this.cartridge.getParams());
        }
    }

    /**
     * Get full path to class instance view folder
     */
    private String getViewFolderPath()
    {
        return this.getUserCartridgeFolderPath() + File.separator +  DocumentInfoBuilder.DEFAULT_VIEW_FOLDER_NAME + File.separator;
    }

    /**
     * Get full path to class instance template folder
     */
    private String getTemplateFolderPath()
    {
        return this.getUserCartridgeFolderPath() + File.separator +  DocumentInfoBuilder.DEFAULT_TEMPLATE_FOLDER_NAME + File.separator;
    }

    /**
     * Get folder path of class instance
     */
    private String getUserCartridgeFolderPath()
    {
        if (StringUtils.isEmpty(this.userCartridgeFolderPath)) {
            this.userCartridgeFolderPath = this.cartridge.getClass().getResource("").toString();
        }

        return this.userCartridgeFolderPath;
    }

    private String generateDocumentName(String documentExt) {
        String setupDocumentName = this.cartridge.setupDocumentName();
        long unixTime = System.currentTimeMillis() / 1000L;
        String timeStr = Long.toString(unixTime);
        String docName = StringUtils.isEmpty(setupDocumentName) ? timeStr : setupDocumentName;

        return docName + "." + documentExt;
    }

    /**
     * Check params to equal in cartridge method setupRequiredParams
     */
    private boolean validateParams(HashMap<String, Object> params)
    {
        ArrayList<String> requiredParams = this.cartridge.setupRequiredParams();
        for (String param: requiredParams) {
            if(!params.containsKey(param)) {
                //todo exception
//                throw new InitParamsException(sprintf("Required params '%s' weren't passed", $paramName));
            }
        }

        return true;
    }
}
