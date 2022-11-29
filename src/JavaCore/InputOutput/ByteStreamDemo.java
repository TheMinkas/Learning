package JavaCore.InputOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {

        //Чтение файла
        FileInputStream inputStream = null;
        //Запись в файл
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("D:\\Programm Java\\Training\\source.txt");
            outputStream = new FileOutputStream("D:\\Programm Java\\Training\\dest.txt");


            //Побайтовое чтение файла, пока данные в файле не закончатся
            //Каждый раз когда файл возвращает -1 это означает что файл кончился
            int content;
            while ((content = inputStream.read()) != -1) {
                outputStream.write((byte) content);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
