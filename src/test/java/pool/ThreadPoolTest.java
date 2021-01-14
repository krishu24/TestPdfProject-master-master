package pool;

import org.junit.After;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.*;

class ThreadPoolTest {
    PdfCreator p = new PdfCreator("C:\\Users\\wemalo-student\\ThreadPool\\Test.docx",
            "C:\\Users\\wemalo-student\\ThreadPool\\Test.pdf");
    ThreadPool abc = new ThreadPool(p);

    //execute for each test, before executing test
    @Before
    public void init() {
        abc.start();
  }

    @org.junit.jupiter.api.Test
    void testStart() {
        assertNotNull(abc);
    }

    //execute for each test, after executing test
    @After
    void testStop() {
        abc.stop();
        assertTrue(abc.isStop());
    }

}