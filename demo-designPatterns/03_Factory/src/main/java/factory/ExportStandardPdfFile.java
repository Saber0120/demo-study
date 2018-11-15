package factory;

/**
 * Created by sheng on 2018/10/17.
 */
public class ExportStandardPdfFile implements ExportFile {

    @Override
    public void export(String data) {
        System.out.println("导出标准版pdf，内容为：" + data);
    }
}
