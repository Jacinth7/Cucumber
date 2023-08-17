package com.pages;

import java.io.IOException;
import java.sql.*;

public class DrawdownPage {

    public void drawdowncheck() throws ClassNotFoundException, SQLException {
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    String dbURL ="jdbc:sqlserver://sql-lvfs-non-prod-shared-uksouth-001.database.windows.net:1433;database=sqldb-st2-qa-aks-non-prod-uksouth-001;user=admqasqlst2;password=UsNq%^^7q*h~2tAN;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    Connection con = DriverManager.getConnection(dbURL);
    Statement stat = con.createStatement();
    String s ="SELECT column_name,DATA_TYPE,character_maximum_length,NUMERIC_PRECISION, NUMERIC_SCALE FROM information_schema.columns WHERE table_name ='DrawdownArrangementValuation';";
    System.out.println("sql command"+s);
    ResultSet rs = stat.executeQuery(s);


		System.out.println("value"+rs);
    while(rs.next()){
        System.out.println(rs.getString(1)+"          "+(rs.getString(2))+"       "+
                (rs.getString(3))+"       "+(rs.getString(4))+"       "+(rs.getString(5)));

    }


    con.close();
    System.out.println("verification completed");
}

    public void drawdownvaluescheck() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String dbURL ="jdbc:sqlserver://sql-lvfs-non-prod-shared-uksouth-001.database.windows.net:1433;database=sqldb-st2-qa-aks-non-prod-uksouth-001;user=admqasqlst2;password=UsNq%^^7q*h~2tAN;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection con = DriverManager.getConnection(dbURL);
        Statement stat = con.createStatement();
        String s ="SELECT * from DrawdownArrangementValuation;";
        System.out.println("sql command"+s);
        ResultSet rs = stat.executeQuery(s);


        System.out.println("value"+rs);
        while(rs.next()){
            System.out.format(rs.getString(1)+"          "+(rs.getString(2))+"       "+
                    (rs.getString(3))+"       "+(rs.getString(4))+"       "+(rs.getString(5)));
            System.out.println(          "          ");

            System.out.format(" ");
        }


        con.close();
        System.out.println("verification completed");
    }


    public void drawdowntableconstraints() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String dbURL ="jdbc:sqlserver://sql-lvfs-non-prod-shared-uksouth-001.database.windows.net:1433;database=sqldb-st2-qa-aks-non-prod-uksouth-001;user=admqasqlst2;password=UsNq%^^7q*h~2tAN;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection con = DriverManager.getConnection(dbURL);
        Statement stat = con.createStatement();
        String s ="SELECT column_name, constraint_name FROM information_schema.constraint_column_usage WHERE table_name ='DrawdownArrangementValuation';";
        System.out.println("sql command"+s);
        ResultSet rs = stat.executeQuery(s);


        System.out.println("value"+rs);
        while(rs.next()){
            System.out.println(rs.getString(1)+"          "+(rs.getString(2)));
            System.out.println(          "          ");

            System.out.format(" ");
        }


        con.close();
        System.out.println("verification completed");
    }

    public void drawdowntablefundproportion() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String dbURL ="jdbc:sqlserver://sql-lvfs-non-prod-shared-uksouth-001.database.windows.net:1433;database=sqldb-st2-qa-aks-non-prod-uksouth-001;user=admqasqlst2;password=UsNq%^^7q*h~2tAN;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Connection con = DriverManager.getConnection(dbURL);
        Statement stat = con.createStatement();
        String s ="select FundProportion from  DrawdownArrangementValuation;";
        System.out.println("sql command"+s);
        ResultSet rs = stat.executeQuery(s);


        System.out.println("value"+rs);
        while(rs.next()){
            System.out.println(rs.getString(1));

        }


        con.close();
        System.out.println("verification completed");
    }

}
