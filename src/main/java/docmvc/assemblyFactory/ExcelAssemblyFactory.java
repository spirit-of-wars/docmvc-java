package docmvc.assemblyFactory;

import docmvc.assembly.DocumentAssemblyInterface;
import docmvc.assembly.ExcelAssembly;
import docmvc.assembly.constraint.ExcelExtensionConstraint;
import docmvc.assembly.constraint.ExtensionConstraintInterface;
import docmvc.assembly.info.DocumentInfo;
import docmvc.cartridge.ExcelCartridge;

public class ExcelAssemblyFactory extends AbstractDocumentAssemblyFactory {
    public ExcelAssemblyFactory(ExcelCartridge cartridge) {
        super(cartridge);
    }

    @Override
    public DocumentAssemblyInterface createAssemblyDocument() {
        DocumentInfo documentInfo = DocAssemblyFactory.createDocumentInfo(this.cartridge, this.createExtensionConstraint());

        return new ExcelAssembly(documentInfo);
    }

    @Override
    public ExtensionConstraintInterface createExtensionConstraint() {
        return new ExcelExtensionConstraint();
    }
}
