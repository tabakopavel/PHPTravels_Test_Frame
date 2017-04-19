package com.phptravel;

import com.phptravel.utilities.classes.Credentials;
import com.phptravel.utilities.classes.Propertiess;
import com.phptravel.utilities.classes.Search;
import com.phptravel.utilities.excel.ExcelReadForCredentials;
import com.phptravel.utilities.excel.ExcelReadForSearch;

import java.io.IOException;
import java.util.List;

/**
 * Created by UX303L on 10.04.2017.
 */
public class Main {
    public static void main(String[] args) {

//System.setProperty("test.cred_data","C:\\\\Users\\\\UX303L\\\\Dropbox\\\\программирование\\\\my project\\\\my_project_phptravel.xls");
        Propertiess.init();

        List<Search> cred = Search.getSearchList();
        for (Search qwe : cred) {
            System.out.println(qwe);
            System.out.println(cred.size());
        }
       /* ExcelReadForCredentials.getData();
        List<Credentials> cred = Credentials.getCredentialsList();

        for (Credentials qwe : cred) {
            System.out.println(qwe);
            System.out.println(cred.size());
        }*/
    }
}
