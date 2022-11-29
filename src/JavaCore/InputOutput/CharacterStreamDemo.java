package JavaCore.InputOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {
    public static void main(String[] args) throws IOException {
        FileReader readerStream = null;
        FileWriter writerStream = null;

        try {
            readerStream = new FileReader("D:\\Programm Java\\Training\\source.txt");
            writerStream = new FileWriter("D:\\Programm Java\\Training\\dest.txt");

            int content;

            while ((content = readerStream.read()) != -1) {
                writerStream.append((char) content);
            }
        } finally {
            if(readerStream != null) {
                readerStream.close();
            }
            if(writerStream != null) {
                writerStream.close();
            }
        }
    }
}
