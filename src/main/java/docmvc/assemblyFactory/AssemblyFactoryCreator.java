package docmvc.assemblyFactory;

import docmvc.cartridge.*;

public class AssemblyFactoryCreator {
    public static DocumentAssemblyFactoryInterface createFactoryByCartridge(SetupCartridgeInterface cartridge) {

        if (cartridge instanceof DocCartridge) {
            return new DocAssemblyFactory((DocCartridge) cartridge);
        } else if (cartridge instanceof ExcelCartridge) {
            return new ExcelAssemblyFactory((ExcelCartridge) cartridge);
        } else if (cartridge instanceof PdfCartridge) {
            return new PdfAssemblyFactory((PdfCartridge) cartridge);
        } else {
            //todo exception
            return null;
        }
    }
}
