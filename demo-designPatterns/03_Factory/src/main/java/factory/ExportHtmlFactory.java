package factory;

/**
 * Created by sheng on 2018/10/17.
 */
public class ExportHtmlFactory implements ExportFactory {

    @Override
    public ExportFile factory(String type) {
        if ("standard".equals(type)) {
            return new ExportStandardHtmlFile();
        } else if ("financial".equals(type)) {
            return new ExportFinancialHtmlFile();
        } else {
            throw new RuntimeException("未找到类型！");
        }
    }
}
