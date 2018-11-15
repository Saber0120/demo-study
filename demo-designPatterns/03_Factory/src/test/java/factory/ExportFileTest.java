package factory;

import org.junit.Test;

/**
 * Created by sheng on 2018/10/17.
 */
public class ExportFileTest {

    @Test
    public void testExportFile() {
        ExportFactory factory;
        String data = "测试内容";

        factory = new ExportHtmlFactory();
        exportFile(factory, data);

        factory = new ExportPdfFactory();
        exportFile(factory, data);
    }

    private void exportFile(ExportFactory factory, String data) {
        String type;
        ExportFile file;
        type = "standard";
        file = factory.factory(type);
        file.export(data);
        type = "financial";
        file = factory.factory(type);
        file.export(data);
    }
}
