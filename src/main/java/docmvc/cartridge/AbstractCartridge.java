package docmvc.cartridge;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractCartridge implements SetupCartridgeInterface {

    protected HashMap<String, Object> params;

    public AbstractCartridge(HashMap<String, Object> params) {
        this.params = params;
    }

    @Override
    public HashMap<String, Object> getParams() {
        return this.params;
    }

    @Override
    public HashMap<String, String> setupModel() {
        return null;
    }

    @Override
    public String setupDocumentExt() {
        return null;
    }

    @Override
    public ArrayList<String> setupRequiredParams() {
        return null;
    }

    @Override
    public String setupDocumentName() {
        return null;
    }

//    @Override
//    public void beforeRenderBehavior(Object driver) {
//
//    }

}
