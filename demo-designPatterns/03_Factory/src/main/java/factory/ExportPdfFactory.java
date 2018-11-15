package factory;

/**
 * Created by sheng on 2018/10/17.
 */
public class ExportPdfFactory implements ExportFactory {

    @Override
    public ExportFile factory(String type) {
        if ("standard".equals(type)) {
            return new ExportStandardPdfFile();
        } else if ("financial".equals(type)) {
            return new ExportFinancialPdfFile();
        } else {
            throw new RuntimeException("未找到类型！");
        }
    }
}
