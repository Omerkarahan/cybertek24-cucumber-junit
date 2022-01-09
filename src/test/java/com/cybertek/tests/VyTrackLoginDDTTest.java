package com.cybertek.tests;

import com.cybertek.pages.VyTrackPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackPage vyTrackPage = new VyTrackPage();
    String vytrackFile = "VyTrackQa2Users.xlsx";
    @Before
    public void setUp() {
        // set up browser etc if needed
        //open the url

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
        // open excel file
        //add page object
        //loop and read credentials
        //write the result in excel file

        XSSFWorkbook workbook = new XSSFWorkbook(vytrackFile);

        XSSFSheet dataSheet = workbook.getSheetAt(0);

        int rowsCount = dataSheet.getLastRowNum();

        for ( int i = 1; i <=rowsCount; i++ ){

            vyTrackPage.userNameField.sendKeys(dataSheet.getRow(i).getCell(0).toString());
            vyTrackPage.passwordField.sendKeys(dataSheet.getRow(i).getCell(1).toString());
            vyTrackPage.loginBtn.click();
            vyTrackPage.userMenu.click();
            BrowserUtils.sleep(1);
            vyTrackPage.logOut.click();

            System.out.println(dataSheet.getRow(i).getCell(0) +" | " + dataSheet.getRow(i).getCell(1) + " | " + dataSheet.getRow(i).getCell(2) + " | " + dataSheet.getRow(i).getCell(3));
        }
    }
}
