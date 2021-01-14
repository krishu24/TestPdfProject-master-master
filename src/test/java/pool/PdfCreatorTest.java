package pool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.RejectedExecutionException;

class PdfCreatorTest {
    PdfCreator p = new PdfCreator("C:\\Users\\wemalo-student\\Test.docx",
            "C:\\Users\\wemalo-student\\ThreadPool\\Test.pdf");

    @Test
    void convert_Rejected() {
        Assertions.assertThrows(RejectedExecutionException.class, () -> {
            p.convert();
        });
    }

}