import java.util.HashMap;
import java.util.Map;

/**
 * Created by sheng on 2018/6/20.
 */
public class WriterManager {

    private Map<String, Writer> writerMap = new HashMap<>();

    public void addWriter(Writer writer) {
        writerMap.put(writer.getName(), writer);
    }

    public Writer getWriter(String name) {
        return writerMap.get(name);
    }

    private WriterManager() {}

    public static WriterManager getInstance() {
        return WriterManagerInstance.writerManager;
    }

    private static class WriterManagerInstance {
        public static WriterManager writerManager = new WriterManager();
    }
}
