package Task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImportService {
    private String[] dirPaths;//переменные
    private String fileExt;

    public ImportService(String[] dirPaths, String fileExt) {//конструктор
        this.dirPaths = dirPaths;
        this.fileExt = fileExt;
    }

    public void executingAll() {//метод создающий и запускающий потоки
        ExecutorService executor = Executors.newFixedThreadPool(dirPaths.length);
        for (String dirPath : dirPaths) {
            executor.execute(new ImportTask(dirPath, fileExt));
        }
        executor.shutdown();//выкл потоки
    }
}
