package factory;

/**
 * Created by sheng on 2018/10/17.
 */
public class ExportFinancialPdfFile implements ExportFile {

    @Override
    public void export(String data) {
        System.out.println("导出财务版pdf，内容为：" + data);
    }
}
