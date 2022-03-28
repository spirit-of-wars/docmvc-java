package docmvc;

import docmvc.cartridge.DocCartridge;

import java.util.ArrayList;
import java.util.HashMap;

public class DocTest extends DocCartridge {
    public DocTest(HashMap<String, Object> params) {
        super(params);
    }

    @Override
    public String setupView() {
        return "";
    }

//    @Override
//    public void beforeRenderBehavior(Object driver) {}
}
