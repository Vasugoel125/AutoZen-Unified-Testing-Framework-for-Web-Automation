package Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.XMLFormatter;

public class dataProviderTest {
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/cred.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        //System.out.println("This is the first test page");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int lastRow = sheet.getLastRowNum();
        System.out.println("lastRow = " + lastRow);
        String value = sheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println("value = " + value);
        int lastcell = sheet.getRow(0).getLastCellNum();
        System.out.println("lastcell = " + lastcell);
        for (int i = 0; i <= lastRow; i++) {
            for (int j = 0; j < lastcell; j++) {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
        }
    }
}
