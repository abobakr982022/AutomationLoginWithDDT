package Data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream fileInputStream = null;
    public FileInputStream getFileInputStream() throws FileNotFoundException {
        String filepath = System.getProperty("user.dir")+"/Files/logindata.xlsx";
        File file = new File(filepath);
        fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }
    public Object[][] getExcelData() throws IOException {
        fileInputStream= getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0);
        int total_no_rows = (sheet.getLastRowNum()+1);
        int total_no_cols = 2;
        String[][] excel_data = new String[total_no_rows][total_no_cols];
        for (int i = 0; i < total_no_rows; i++) {
            for (int j = 0; j < total_no_cols; j++) {
                XSSFRow row= sheet.getRow(i) ;
                excel_data[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return excel_data;
    }
}
