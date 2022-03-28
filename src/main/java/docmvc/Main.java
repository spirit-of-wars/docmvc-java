package docmvc;

import docmvc.assembly.DocumentAssemblyInterface;
import docmvc.assemblyFactory.AssemblyFactoryCreator;
import docmvc.assemblyFactory.DocumentAssemblyFactoryInterface;
import docmvc.cartridge.SetupCartridgeInterface;
import docmvc.cartridge.SetupTemplateInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public Main() {
        System.out.println("Hello");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        System.out.println("Hello");

        testPdfAssembly();


        System.out.println("Finish");
    }

    protected static void testDocAssembly() throws IOException {
        DocTest cartridge = new DocTest(new HashMap<String, Object>());
        DocumentAssemblyFactoryInterface documentAssemblyFactory = AssemblyFactoryCreator.createFactoryByCartridge((SetupCartridgeInterface) cartridge);
        DocumentAssemblyInterface documentAssembly = documentAssemblyFactory.createAssemblyDocument();
        documentAssembly.buildDocument();

        File htmlFile = new File("C:\\dev\\work\\docmvc-java\\src\\main\\java\\docmvc" + File.separator + "lol.html");
        String docStr = Files.readString(htmlFile.toPath(), StandardCharsets.UTF_8);
        //        System.out.println(cartridge.getClass().getResource("").toString());
    }

    protected static void testPdfAssembly() throws FileNotFoundException {
        PdfTest cartridge = new PdfTest(new HashMap<String, Object>());
        DocumentAssemblyFactoryInterface documentAssemblyFactory = AssemblyFactoryCreator.createFactoryByCartridge((SetupCartridgeInterface) cartridge);
        DocumentAssemblyInterface documentAssembly = documentAssemblyFactory.createAssemblyDocument();
        documentAssembly.buildDocument();

    }
}
