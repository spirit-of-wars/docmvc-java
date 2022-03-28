package docmvc.assembly;


import docmvc.assembly.info.DocumentInfo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractDocumentAssembly implements DocumentAssemblyInterface {

    protected DocumentInfo documentInfo;

    protected DocumentRenderer documentRenderer;

    public AbstractDocumentAssembly(DocumentInfo documentInfo) {
        this.documentInfo = documentInfo;
        this.documentRenderer = new DocumentRenderer();
    }

    public String renderFromView(DocumentInfo documentInfo) {
        try {
            return this.documentRenderer.renderFromView(documentInfo.getModel(), documentInfo.getViewPath());
        } catch (IOException e) {
            //todo exception
            return null;
        }

    }

    protected static class DocumentRenderer {
        private static final String REGEX_PATTERN = "\\{%\\s*(\\w+)\\s*%}";

        public String renderFromView(HashMap<String, String> model, String viewPath) throws IOException {
            File htmlFile = new File(viewPath);
            if (!htmlFile.isFile()) {
                //todo exception
            }
            String docStr = Files.readString(htmlFile.toPath(), StandardCharsets.UTF_8);

            Pattern pattern = Pattern.compile(REGEX_PATTERN);
            Matcher matcher = pattern.matcher(docStr);
            StringBuilder stringBuilder = new StringBuilder();

            while (matcher.find()) {
                String replaceString = model.get(matcher.group(1));
                if (replaceString == null) {
                    replaceString = "";
                }
                matcher.appendReplacement(stringBuilder, replaceString);
            }
            matcher.appendTail(stringBuilder);

            return stringBuilder.toString();
        }
    }
}
