package org.example.data;

import org.example.model.AppUser;

import java.sql.*;

public class AppUserDaoJDBC {

   public AppUser create(AppUser user){
       if(user.getUserId() != 0){
           throw new IllegalArgumentException("Use update instead");
       }

       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet keySet = null;

       try{

           connection = MyDataSource.getConnection();
           statement = connection.prepareStatement("INSERT INTO app_user (username, password, full_name, birth_date, active) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, user.getUsername());
           statement.setString(2, user.getPassword());
           statement.setString(3, user.getFullName());
           statement.setObject(4, user.getBirthDate());
           statement.setBoolean(5,user.isActive());

           statement.execute();

           keySet = statement.getGeneratedKeys();

           while(keySet.next()){
               user = new AppUser(
                       keySet.getInt(1),
                       user.getUsername(),
                       user.getPassword(),
                       user.getFullName(),
                       user.getBirthDate(),
                       user.isActive()
               );
           }

       } catch (SQLException exception) {
           exception.printStackTrace();
       }finally {
           try{
               if(keySet != null){
                   keySet.close();
               }
               if(statement != null){
                   statement.close();
               }
               if(connection != null){
                   connection.close();
               }
           }catch (SQLException ex){
               ex.printStackTrace();
           }
       }
       return user;
   }

}
