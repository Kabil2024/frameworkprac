package utils;

import org.apache.poi.xssf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String filePath;

    // Load Excel file
    public static void loadExcel(String path, String sheetName) throws IOException {
        filePath = path;
        FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+filePath));

        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    // Get data from Excel
    public static String getData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }

    // Get row count
    public static int getRowCount() {
        return sheet.getLastRowNum()+1;
    }

    // Write data into Excel
    public static void writeData(int rowNum, int colNum, String value) throws IOException {
        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        XSSFCell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(value);

        // Write to file
        FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+filePath);
        workbook.write(fileOut);
        fileOut.close();
    }

    // Close workbook
    public static void closeWorkbook() throws IOException {
        workbook.close();
    }

    // Get column count
    public static int getColCount() {
        return sheet.getRow(1).getPhysicalNumberOfCells();
    }

    // Get all data as a 2D Object array
    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        loadExcel(filePath, sheetName);
        int rowCount = getRowCount();
        int colCount = getColCount();

        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude header row

        for (int i = 1; i < rowCount; i++) { // Start from row 1 (skip headers)
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = sheet.getRow(i).getCell(j);
                data[i - 1][j] = cell.getStringCellValue();
            }
        }
        closeWorkbook();
        return data;
    }
}