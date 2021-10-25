package Task2;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilter {//класс для фильтрования файлов в директории по принципу совпадения расширения

    public static File[] findFiles(String dir, String ext) {
        File file = new File(dir);
        if(!file.exists()) System.out.println(dir + " папка не существует");
        File[] arrFiles = file.listFiles(new MyFileNameFilter(ext));
        if(arrFiles.length == 0){
            System.out.println(dir + " не содержит файлов с расширением " + ext);
        }
        return arrFiles;
        }
}

class MyFileNameFilter implements FilenameFilter {
    private String ext;

    public MyFileNameFilter(String ext){
        this.ext = ext.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}



