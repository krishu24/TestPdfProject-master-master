package pool;

//<editor-fold desc="All Imports">

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.*;
import java.util.concurrent.RejectedExecutionException;
//</editor-fold>

/**
 * @author wemalo-student
 */

public class PdfCreator implements Convertor {

    private final String docFile_Path;
    private final String pdfFile_Path;

    /**
     * @param doc .docx file to convert
     * @param pdf .pdf file to generate using doc
     */

    public PdfCreator(String doc, String pdf) {
        this.docFile_Path = doc;
        this.pdfFile_Path = pdf;
    }

    public void convert() {
        try {
            InputStream docFile = new FileInputStream(docFile_Path);
            XWPFDocument doc = new XWPFDocument(docFile);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(pdfFile_Path);
            PdfConverter.getInstance().convert(doc, out, options);
            out.close();
        } catch (Exception e) {
            throw new RejectedExecutionException("Conversion terminated");
        }
    }


    //<editor-fold desc="ThreadPool Executor main method">
   /* public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable SimpleThread = new PdfCreator("C:\\Users\\wemalo-student\\ThreadPool\\Test.docx",
                "C:\\Users\\wemalo-student\\ThreadPool\\Test.pdf");

        System.out.println("PDF generated...");
        executor.execute(SimpleThread);
        executor.shutdown();

    }*/
    //</editor-fold>
}
