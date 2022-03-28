package docmvc.assemblyFactory;

import docmvc.assembly.DocumentAssemblyInterface;
import docmvc.assembly.ExcelAssembly;
import docmvc.assembly.PdfAssembly;
import docmvc.assembly.constraint.ExtensionConstraintInterface;
import docmvc.assembly.constraint.PdfExtensionConstraint;
import docmvc.assembly.info.DocumentInfo;
import docmvc.cartridge.PdfCartridge;

public class PdfAssemblyFactory extends AbstractDocumentAssemblyFactory {
    public PdfAssemblyFactory(PdfCartridge cartridge) {
        super(cartridge);
    }

    @Override
    public DocumentAssemblyInterface createAssemblyDocument() {
        DocumentInfo documentInfo = DocAssemblyFactory.createDocumentInfo(this.cartridge, this.createExtensionConstraint());

        return new PdfAssembly(documentInfo);
    }

    @Override
    public ExtensionConstraintInterface createExtensionConstraint() {
        return new PdfExtensionConstraint();
    }
}
