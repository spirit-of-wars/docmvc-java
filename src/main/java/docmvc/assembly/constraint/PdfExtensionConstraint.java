package docmvc.assembly.constraint;

public class PdfExtensionConstraint implements ExtensionConstraintInterface {
    public static final String TYPE_PDF = "pdf";

    @Override
    public String[] allowedExt() {
        String[] allowedExt = {TYPE_PDF};
        return allowedExt;
    }

    @Override
    public String defaultExt() {
        return TYPE_PDF;
    }
}
