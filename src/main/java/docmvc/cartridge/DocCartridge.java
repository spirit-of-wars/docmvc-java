package docmvc.cartridge;

import java.util.HashMap;

public abstract class DocCartridge extends AbstractCartridge implements SetupTemplateInterface {
    public DocCartridge(HashMap<String, Object> params) {
        super(params);
    }

    @Override
    public String setupTemplate() {
        return null;
    }
}
