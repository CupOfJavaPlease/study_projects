package Task2;

public class Main2 {
    public static void main(String[] args) {
        String fileExt = ".csv";//образцы переменных
        String[] dirPaths = {"D:/111", "D:/222", "D:/333"};

        ImportService is = new ImportService(dirPaths, fileExt);//создаем экземпляр метода и передаем туда параметры
        is.executingAll();//запускаем выполнение метода и всей задачи



    }
}
