package workforcemanger.workforce.UnitTestsGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class UnitTestsGeneratorImpl {

    public static void testClassesGenerator() throws IOException {
        FileOutputStream fos = new FileOutputStream("test.java");
        String Genereic = "class Test{" +
                "private int age;"+
                "private int num;"+
                "public void calc(age , num){" +
                "System.out.println(age + num)}"+
                "};";
        fos.write(Genereic.getBytes());
        fos.flush();
    }
    public static void main(String[] args) throws IOException {
        testClassesGenerator();
    }
}
