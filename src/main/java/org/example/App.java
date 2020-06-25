package org.example;

import org.example.data.AppUserDaoJDBC;
import org.example.model.AppUser;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AppUserDaoJDBC daoJDBC = new AppUserDaoJDBC();

        AppUser appUser = new AppUser(
                "eriks",
                "java_master",
                "Erik Svensson",
                LocalDate.parse("1976-09-11")
        );

        appUser = daoJDBC.create(appUser);
        System.out.println(appUser);

    }
}
