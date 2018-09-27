import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

import java.io.File;

public class TestOCR {
    @Test
    public void test() {
        File imageFile = new File("D:/1.jpg");
        Tesseract tessreact = new Tesseract();
        tessreact.setDatapath("D:/tessdata");
        try {
            String result = tessreact.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

}
