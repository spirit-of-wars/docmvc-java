package docmvc.cartridge;

import com.itextpdf.text.pdf.PdfWriter;

import java.util.ArrayList;
import java.util.HashMap;

public interface SetupCartridgeInterface extends CartridgeInterface {

    HashMap<String, String> setupModel();

    String setupDocumentExt();

    ArrayList<String> setupRequiredParams();

    String setupView();

    String setupDocumentName();

//    void beforeRenderBehavior(T driver);
}
