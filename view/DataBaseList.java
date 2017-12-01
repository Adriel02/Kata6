package view;

import model.Person;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseList {
    public static List<Person> read() throws IOException, ClassNotFoundException, SQLException {
        List<Person> listPerson = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection connec = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        Statement st = connec.createStatement();
        String query = "SELECT * FROM PEOPLE;";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            Character gender = rs.getString(3).charAt(0);
            String birthDate= rs.getString(4);
            Float weight = rs.getFloat(5);
            String mail = rs.getString(6);
            listPerson.add(new Person(id,name,gender,birthDate,weight,mail));
        }
        return listPerson;
    }

}


