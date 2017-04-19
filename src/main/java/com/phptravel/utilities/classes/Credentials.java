package com.phptravel.utilities.classes;

import com.phptravel.utilities.excel.ExcelReadForCredentials;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UX303L on 10.04.2017.
 */
public class Credentials {
    private String login;
    private String password;
    private String expected_result;
    private String expected_title;
    private static List<Credentials> credentialsList = new ArrayList<Credentials>();

    public Credentials(String login, String password, String expected_result, String expected_title) {
        this.login = login;
        this.password = password;
        this.expected_result = expected_result;
        this.expected_title = expected_title;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getExpected_result() {
        return expected_result;
    }

    public String getExpected_title() {
        return expected_title;
    }

    public static List<Credentials> getCredentialsList() {
        ExcelReadForCredentials.getData();
        return credentialsList;
    }

    public static void addCredentials(Credentials credentials) {
        credentialsList.add(credentials);
    }

    @Override
    public String toString() {
        return getLogin() + " " + getPassword() + " " + getExpected_result()+ " "+getExpected_title();
    }
}
