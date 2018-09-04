package POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RangeDatabyPOI {

    /**
     * @param args
     * @throws IOException
     * @throws BiffException
     */
    public static Object[][] poiRangeData(String filePath) {


        File file = new File(filePath);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Workbook workbook = null;
        String extensionName = filePath.substring(filePath.indexOf("."));
        if (extensionName.equals(".xls")) {
            try {
                workbook = new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (extensionName.equals(".xlsx")) {
            try {
                workbook = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件格式不正确");
        }
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<Object[]>();

        for (int i = 1; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            String fields[] = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                fields[j] = row.getCell(j).getStringCellValue();
            }
            records.add(fields);
        }

        Object[][] results = new Object[records.size()][];

        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;

    }


    public static void main(String[] args) throws IOException {
        poiRangeData("/Users/wan/Desktop/test.xlsx");


    }

}
