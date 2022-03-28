package docmvc.assemblyFactory;

import docmvc.assembly.*;
import docmvc.assembly.constraint.DocExtensionConstraint;
import docmvc.assembly.constraint.ExtensionConstraintInterface;
import docmvc.assembly.info.DocumentInfo;
import docmvc.cartridge.DocCartridge;

public class DocAssemblyFactory extends AbstractDocumentAssemblyFactory {

    public DocAssemblyFactory(DocCartridge cartridge) {
        super(cartridge);
    }

    @Override
    public DocumentAssemblyInterface createAssemblyDocument() {
        DocumentInfo documentInfo = DocAssemblyFactory.createDocumentInfo(this.cartridge, this.createExtensionConstraint());

        return new DocAssembly(documentInfo);
    }

    @Override
    public ExtensionConstraintInterface createExtensionConstraint() {
        return new DocExtensionConstraint();
    }


}
