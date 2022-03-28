package docmvc.assemblyFactory;

import docmvc.assembly.constraint.ExtensionConstraintInterface;
import docmvc.assembly.info.DocumentInfo;
import docmvc.assembly.info.DocumentInfoBuilder;
import docmvc.assembly.info.DocumentInfoDirector;
import docmvc.cartridge.SetupCartridgeInterface;

public abstract class AbstractDocumentAssemblyFactory implements DocumentAssemblyFactoryInterface {

    SetupCartridgeInterface cartridge;

    public AbstractDocumentAssemblyFactory(SetupCartridgeInterface cartridge) {
        this.cartridge = cartridge;
    }

    protected static DocumentInfo createDocumentInfo(SetupCartridgeInterface cartridge, ExtensionConstraintInterface extensionConstraint) {
//        try {
        DocumentInfoBuilder builder = new DocumentInfoBuilder(cartridge, extensionConstraint);
        DocumentInfoDirector documentInfoDirector = new DocumentInfoDirector();

        return documentInfoDirector.buildDocumentInfo(builder);

        //todo exception
//        } catch (DocumentInfoBuilderExceptionInterface $e) {
//            throw new DocumentInfoCreateException($e->getMessage(), $e->getCode(), $e);
//        }
    }
}
