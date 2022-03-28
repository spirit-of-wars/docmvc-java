package docmvc.assembly.constraint;

public class DocExtensionConstraint implements ExtensionConstraintInterface {
    public static final String TYPE_DOC = "doc";
    public static final String TYPE_DOCX = "docx";

    @Override
    public String[] allowedExt() {
        String[] allowedExt = {TYPE_DOCX, TYPE_DOC};
        return allowedExt;
    }

    @Override
    public String defaultExt() {
        return TYPE_DOCX;
    }
}
