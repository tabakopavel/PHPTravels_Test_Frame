package com.phptravel.utilities.excel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import com.phptravel.utilities.classes.Credentials;
import com.phptravel.utilities.classes.Propertiess;

public class ExcelReadForCredentials {
    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet("Data.For.Login.Tests");
            for (int i = 1; i < sheet.getRows(); i++) {
                Cell login_cell = sheet.getCell(1, i);
                Cell password_cell = sheet.getCell(2, i);
                Cell expected_res_cell = sheet.getCell(3, i);
                Cell expected_title_cell = sheet.getCell(4, i);
                String login = login_cell.getContents();
                String password = password_cell.getContents();
                String expected_res = expected_res_cell.getContents();
                String expected_title = expected_title_cell.getContents();
                Credentials.addCredentials(new Credentials(login, password, expected_res, expected_title));

            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void getData() {
        ExcelReadForCredentials test = new ExcelReadForCredentials();
        Propertiess.init();
        test.setInputFile(System.getProperty("test.cred_data"));
        try {
            test.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
