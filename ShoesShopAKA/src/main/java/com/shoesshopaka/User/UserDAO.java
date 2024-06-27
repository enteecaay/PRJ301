/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoesshopaka.User;

/**
 *
 * @author enteecaay
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shoesshopaka.utils.DBUtils;
import javax.naming.NamingException;

public class UserDAO {

    // List all users with optional keyword and sorting
    public List<UserDTO> list(String keyword) {
        List<UserDTO> list = new ArrayList<>();
        String sql = "SELECT username, password, email, phone, first_name, last_name, sex, birth_date, address_line, province, district_town FROM [User]";

        try (Connection con = DBUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            if (keyword != null && !keyword.isEmpty()) {
                String searchKeyword = "%" + keyword + "%";
                stmt.setString(1, searchKeyword);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthDate(rs.getDate("birth_date").toLocalDate());
                user.setAddressLine(rs.getString("address_line"));
                user.setProvince(rs.getString("province"));
                user.setDistrictTown(rs.getString("district_town"));
                list.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Error listing users. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return list;
    }

    public UserDTO login(String username, String password) {

        UserDTO user = null;
        try {

            Connection con = DBUtils.getConnection();
            String sql = " SELECT username, password FROM [User] ";
            sql += " WHERE username = ?  AND password = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                if (rs.next()) {
                    user = new UserDTO();
                    user.setUsername(rs.getString("username"));
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details:" + ex.getMessage());
            ex.printStackTrace();

        }
        return user;

    }

    // Load a user by username
    public UserDTO load(String username) {
        String sql = "SELECT username, password, email, phone, first_name, last_name, sex, birth_date, address_line, province, district_town FROM [User] WHERE username = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthDate(rs.getDate("birth_date").toLocalDate());
                user.setAddressLine(rs.getString("address_line"));
                user.setProvince(rs.getString("province"));
                user.setDistrictTown(rs.getString("district_town"));
                return user;
            }
        } catch (SQLException ex) {
            System.out.println("Error loading user. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    // Insert a new user
    public boolean insert(UserDTO user) {
        
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO [User] (username, password, email, phone, first_name, last_name, sex, birth_date, address_line, province, district_town)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getFirstName());
            ps.setString(6, user.getLastName());
            ps.setString(7, user.getSex());
            if (user.getBirthDate() != null) {
            ps.setDate(8, java.sql.Date.valueOf(user.getBirthDate()));
        } else {
            ps.setNull(8, java.sql.Types.DATE);
        }

            ps.setString(9, user.getAddressLine());
            ps.setString(10, user.getProvince());
            ps.setString(11, user.getDistrictTown());
            int row = ps.executeUpdate();
            return row >0;
        } catch (SQLException ex) {
            System.out.println("Error signing up user. Details: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally{
            try{
                if(ps != null) ps.close();
                if (conn!= null) conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
//check duplicate

    public boolean checkDuplicate(String username) {
    String sql = "SELECT username FROM [User] WHERE username = ?";
    try {
        Connection con = DBUtils.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        con.close();
        ps.close();
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error checking duplicate username. Details: " + ex.getMessage());
        ex.printStackTrace();
    }
    return false;
}

    // Update an existing user
    public boolean update(UserDTO user) {
        String sql = "UPDATE [User] SET password = ?, email = ?, phone = ?, first_name = ?, last_name = ?, sex = ?, birth_date = ?, address_line = ?, province = ?, district_town = ? WHERE username = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getFirstName());
            ps.setString(6, user.getLastName());
            ps.setString(7, user.getSex());
            ps.setDate(8, java.sql.Date.valueOf(user.getBirthDate()));
            ps.setString(9, user.getAddressLine());
            ps.setString(10, user.getProvince());
            ps.setString(11, user.getDistrictTown());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.out.println("Error updating user. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    // Delete a user by username
    public boolean delete(String username) {
        String sql = "DELETE FROM [User] WHERE username = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            System.out.println("Error deleting user. Details: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
}
