package com.phptravel.utilities.dataprovider;

import org.testng.annotations.DataProvider;
import com.phptravel.utilities.classes.Credentials;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by UX303L on 10.04.2017.
 */
public class CredentialsProvider {

    @DataProvider(name = "cred_prov", parallel = false)
    public static Iterator<Object[]> getCred(){
        List<Object[]> credentialsList = new ArrayList<Object[]>();
        List<Credentials> cred = Credentials.getCredentialsList();
        for(int i=0;i<cred.size();i++){
            credentialsList.add(new Object[]{cred.get(i).getLogin(),cred.get(i).getPassword(),cred.get(i).getExpected_result(),cred.get(i).getExpected_title()});
        }
        return credentialsList.iterator();
    }
}
