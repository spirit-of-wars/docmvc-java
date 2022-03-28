package docmvc.assembly;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import docmvc.assembly.info.DocumentInfo;

import java.io.*;
import java.util.stream.Stream;

public class PdfAssembly extends AbstractDocumentAssembly {

    public PdfAssembly(DocumentInfo documentInfo) {
        super(documentInfo);
    }

    @Override
    public DocumentAssemblyResultInterface buildDocument() {
        try {
            Document document = new Document();
            // Создаем writer для записи в pdf
            FileOutputStream fileOutputStream = new FileOutputStream(this.documentInfo.getTmpDocumentPath());

            String htmlString = this.renderFromView(this.documentInfo);
//            HtmlConverter.convertToPdf(htmlString, fileOutputStream);

            PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);
            InputStream is = new ByteArrayInputStream(htmlString.getBytes());
//             Открываем для чтения html страничку
            document.open();

//             Парсим её и записываем в PDF
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
            document.close();
            fileOutputStream.close();
//            writer.close();
        } catch (IOException | DocumentException exception) {
            exception.getStackTrace();
            //todo exception
        }

//        $viewContent = $this->renderFromView($driver, $this->documentInfo);
//        $driver->loadHtml($viewContent);
//        $driver->render();
//        $content = $driver->output();
//        $this->saveToTmpDocument($content);
        return new AssemblyResult(this.documentInfo);
    }

    public static class AssemblyResult extends AbstractDocumentAssemblyResult {

        public AssemblyResult(DocumentInfo documentInfo) {
            super(documentInfo);
        }

        @Override
        public void download() {
            //todo download
        }
    }
}
