package com.phptravel.utilities.excel;

import com.phptravel.utilities.classes.Credentials;
import com.phptravel.utilities.classes.Propertiess;
import com.phptravel.utilities.classes.Search;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * Created by UX303L on 17.04.2017.
 */
public class ExcelReadForSearch {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet("Data.For.Search.Tests");
            for (int i = 1; i < sheet.getRows(); i++) {
                Cell search_cell = sheet.getCell(1, i);
                Cell expected_res_cell = sheet.getCell(2, i);
                Cell expected_city_or_title_cell = sheet.getCell(3, i);

                String searchInput = search_cell.getContents();
                String expectedResult = expected_res_cell.getContents();
                String expectedCityOrTitle = expected_city_or_title_cell.getContents();
                Search.addSearchOption(new Search(searchInput, expectedResult, expectedCityOrTitle));

            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static void getData() {
        ExcelReadForSearch test = new ExcelReadForSearch();
        Propertiess.init();
        test.setInputFile(System.getProperty("test.cred_data"));
        try {
            test.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
