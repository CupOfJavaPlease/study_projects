package Task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportTask implements Runnable{
    private String dirPath;//строка с директорией
    private String fileExt;//строка с расширением файла

    public ImportTask(String dirPath, String fileExt) {//конструктор
        this.dirPath = dirPath;
        this.fileExt = fileExt;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();//начало исполнения
        ArrayList<String> list = getArrayLines(dirPath, fileExt);//получаем лист строк из всех подходящих файлов директории
        for (int i = 0; i < list.size(); i++) {
            String [] arrStr = checkListLines(list.get(i));//каждую строку разделяем по запятым и кладем в лист объектов
            Product product = doIntoProduct(arrStr);//из данной строки извлекаем данные и кладем их в новый экземпляр Product
            if(checkCodeProduct(product.getCode())){//если код продукта чекается
                updateProduct(product);//то обновляем данные
            } else createProduct(product);//иначе создаем
        }
        long endTime = System.currentTimeMillis();//конец исполнения
        System.out.println("This thread was executing " + (endTime - startTime) + "ms");//выводится время исполнения метода
    }

    //метод который из указанной директории берет все подходящие файлы и извлекает из них все строки в массив ArrayList
    public ArrayList<String> getArrayLines(String dirPath, String fileExt){
        File[] arrFiles = FileNameFilter.findFiles(dirPath, fileExt);//массив в который кладем все подходящие файлы из директории
        ArrayList<String> listLines = new ArrayList<>();//создаем лист для линий
        for (File file : arrFiles) {//через форич читаем массив
            BufferedReader br = null;
            String line;
            try{
                    br = new BufferedReader(new FileReader(file));//читаем файл
                    while((line = br.readLine())!=null){//пока в файле есть линии
                        listLines.add(line);//добавляем их в массив
                    }
                } catch(Exception ex){
                ex.printStackTrace();
            }finally {
                if(br == null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }

        } return listLines;
    }

    //данный метод проверяет есть ли код продукта в базе
    public boolean checkCodeProduct(String codeProduct) {
        final String sql = "SELECT code FROM product where code = ?";//берем SQLзапрос
        try (Connection c = DataBaseUtil.getConnection();//соединяемся с БД
             PreparedStatement s = c.prepareStatement(sql)) {//подготавливаем стейтмент
            s.setString(1, codeProduct);//прописываем интересующий нас код продукта
            try (ResultSet rs = s.executeQuery()) {//отправляем запрос
                if (rs.next()) return true;//если тру значит код уже есть тогда возвращаем тру
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //метод который разделяет строку на разные объекты по разделителю - запятой
    public String[] checkListLines(String line){//метод, который
        String [] arrStr = line.split(",");//каждую строку из масива через сплит разделяем по запятым и кладем результаты в массив строк
        return arrStr;
    }

    //метод из листа объектов переает значения в параметры нового Продукта
    public Product doIntoProduct(String[] arrStr) {
        Product product = new Product();//создаем новый экземпляр Продукта
        product.setCode(arrStr[0]) ;//так как нам известен порядок в котором идет содержимое строки то кладем 1 рез-т в код продукта
        product.setProduct_name(arrStr[1]);//2-й в наименование
        product.setPrice(Integer.parseInt(arrStr[2]));//3-й в цену
        return product;    }

    //метод обновляет новый продукт
    public void updateProduct(Product product) {
        final String sql = "UPDATE product SET product_name= ?, price= ? WHERE code= ?";//SQLзапрос
        try (Connection c = DataBaseUtil.getConnection(); PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, product.getProduct_name());
            s.setInt(2, product.getPrice());
            s.setString(3, product.getCode());
            int i = s.executeUpdate();
            if(i>0)System.out.println("Your product_table successful updated " + i + " columns");
            else System.out.println("May be you made a mistake and broke all around of you");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    //метод создает новый продукт
    public void createProduct(Product product){
        final String sql = "INSERT INTO product (code, product_name, price, creation_date) VALUES(?, ?, ?, ?)";
        try (Connection conn = DataBaseUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, product.getCode());
            ps.setString(2, product.getProduct_name());
            ps.setInt(3, product.getPrice());
            ps.setObject(4, LocalDateTime.now());
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("You successfully create new product");
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

