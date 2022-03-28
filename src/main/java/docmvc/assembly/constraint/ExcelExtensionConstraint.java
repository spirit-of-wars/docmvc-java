package docmvc.assembly.constraint;

public class ExcelExtensionConstraint implements ExtensionConstraintInterface {
    public static final String TYPE_XLS = "xls";
    public static final String TYPE_XLSX = "xlsx";

    @Override
    public String[] allowedExt() {
        String[] allowedExt = {TYPE_XLS, TYPE_XLSX};
        return allowedExt;
    }

    @Override
    public String defaultExt() {
        return TYPE_XLSX;
    }
}
