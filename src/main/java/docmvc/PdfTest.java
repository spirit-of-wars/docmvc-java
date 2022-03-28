package docmvc;

import docmvc.cartridge.PdfCartridge;

import java.util.HashMap;

public class PdfTest extends PdfCartridge {
    public PdfTest(HashMap<String, Object> params) {
        super(params);
    }

    @Override
    public String setupView() {
        return "";
    }


}
