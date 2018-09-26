import com.by_syk.graphiccr.core.GraphicCTranslator;
import java.io.File;

public class TestGraphiccr {

    public String code(String path){
        File testFile1 = new File(path);
        String result1 = GraphicCTranslator.translate(testFile1, GraphicCTranslator.TYPE_2);
        return result1;
    }
}
