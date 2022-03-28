package docmvc.assemblyFactory;

import docmvc.assembly.DocumentAssemblyInterface;
import docmvc.assembly.constraint.ExtensionConstraintInterface;
import docmvc.cartridge.SetupCartridgeInterface;

public interface DocumentAssemblyFactoryInterface {

    DocumentAssemblyInterface createAssemblyDocument();

    ExtensionConstraintInterface createExtensionConstraint();
}
