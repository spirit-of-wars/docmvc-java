package docmvc.cartridge;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ExcelCartridge extends AbstractCartridge implements SetupTemplateInterface {
    public ExcelCartridge(HashMap<String, Object> params) {
        super(params);
    }

    @Override
    public String setupTemplate() {
        return null;
    }
}
