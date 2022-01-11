package com.cybertek.tests;

import com.cybertek.pages.VyTrackDashboardPage;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
       // vyTrackPage.login("user1","UserUser123");
    }
//    @After
//    public void tearDown(){
//        // close browser here
//        Driver.closeDriver();
//    }
    @Test
    public void loginDDTTest() throws IOException {
        VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();
        // open excel book
        String vytrackFile = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(vytrackFile);
        XSSFWorkbook workbook = new XSSFWorkbook(in);

        XSSFSheet workSheet = workbook.getSheetAt(0);
//
//      String userName = "user1";
//     String password = "UserUser123";
//        String firstName = "John";
//        String lastName = "Doe";




        int rowsCount = workSheet.getLastRowNum();

        for ( int i = 1; i <=rowsCount; i++ ) {
            String userName = workSheet.getRow(i).getCell(0).toString();
            String password = workSheet.getRow(i).getCell(1).toString();
            String firstName = workSheet.getRow(i).getCell(2).toString();
            String lastName = workSheet.getRow(i).getCell(3).toString();
            VyTrackLoginPage loginPage = new VyTrackLoginPage();
            loginPage.login(userName, password);

            System.out.println("fullname = " + dashboardPage.fullName.getText());

            BrowserUtils.sleep(1);
            String actualFullName = dashboardPage.fullName.getText();
            //Assert.assertTrue(actualFullName.contains(firstName ) && actualFullName.contains(lastName));

            XSSFCell resultCell = workSheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)) {
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }
            dashboardPage.logout();
            BrowserUtils.sleep(1);

        }
        // save changes in the excel file
        FileOutputStream out = new FileOutputStream(vytrackFile);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();

    }
    }

