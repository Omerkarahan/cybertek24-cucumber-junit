package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    String filePath = "Employees.xlsx";

    @Test
    public void writeToExcelSheet() throws IOException {
        // open the Employees.xlsx usingApache POI
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //Goto "data" sheet. or goto first sheet by index
        XSSFSheet dataSheet = workbook.getSheetAt(0);

        // add a column name "salary" and save into file
        XSSFCell salaryColCell = dataSheet.getRow(0).createCell(3);
        salaryColCell.setCellValue("Salary");

        //save the changes:
        //open to write to the file: FileInputStream -> reading
        //                           FileOutputStream -> writing
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);




    }
}
