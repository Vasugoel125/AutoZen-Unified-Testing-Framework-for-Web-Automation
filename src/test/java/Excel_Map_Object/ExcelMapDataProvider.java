package Excel_Map_Object;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelMapDataProvider
{
    @DataProvider
    public static Object[][] getData() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/cred.xlsx");
        FileInputStream inputStream= new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int lastRow = sheet.getLastRowNum();
        System.out.println("lastRow = " + lastRow);
        int lastcell = sheet.getRow(0).getLastCellNum();
        System.out.println("lastcell = " + lastcell);
        Object[][] a = new Object[lastRow][1];
        Map<String,String> map;
        for (int i = 1; i <= lastRow; i++)
        {
            map = new HashMap<>();
            for (int j = 0; j < lastcell; j++)
            {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
            }
            a[i-1][0] = map;
        }
        return a;
    }

    @Test(dataProvider = "getData")
    public void Testing(Map<String,String> data)
    {
        System.out.println(data.get("Username"));
        System.out.println(data.get("Password"));
    }
}
