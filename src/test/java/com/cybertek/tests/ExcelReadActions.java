package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {
    String filePath = "Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        //open the Employees.xlsx using Apache POI
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //Goto "data" sheet or goto first sheet by index
        XSSFSheet dataSheet = workbook.getSheetAt(0);

        //print column names row is 0. sells 0,1,2
        System.out.println("COLUMN NAME");
        System.out.println(dataSheet.getRow(0).getCell(0));
        System.out.println(dataSheet.getRow(0).getCell(1));
        System.out.println(dataSheet.getRow(0).getCell(2));
        //loop nd print all 3 column name

        for (int i = 0; i <= 2; i++) {
            System.out.println(dataSheet.getRow(0).getCell(i));
        }
        int rowsCount = dataSheet.getPhysicalNumberOfRows();
        System.out.println("rowsCount = " + rowsCount);

        int useRowsCount = dataSheet.getLastRowNum();
        System.out.println("useRowsCount = " + useRowsCount);

        System.out.println("ALL FIRST NAMES");
        for (int i = 1; i <= useRowsCount; i++) {
            System.out.println(dataSheet.getRow(i).getCell(0));
        }

        System.out.println("\nFadime INFO");
        for (int i = 0; i <= dataSheet.getLastRowNum(); i++) {

            if (dataSheet.getRow(i).getCell(0).toString().equals("Fadime")) {
                System.out.println(dataSheet.getRow(i).getCell(0) + " | " + dataSheet.getRow(i).getCell(1) + " | " + dataSheet.getRow(i).getCell(2));
            }
        }

    }
}
