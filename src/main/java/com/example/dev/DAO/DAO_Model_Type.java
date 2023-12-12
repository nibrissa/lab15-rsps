package com.example.dev.DAO;


import com.example.dev.DataClass.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
public class DAO_Model_Type implements RepositoryDAO<Type> {
    public DAO_Model_Type() {}
    private static final String select_all_type = "SELECT * FROM type_account ORDER BY id";
    private static final String select_type_ById = "SELECT * FROM type_account WHERE id = ?";
    private static final String insert_type = "INSERT INTO type_account (type) VALUES(?)";
    private static final String edit_type = "UPDATE type_account SET type = ? WHERE id = ?";
    private static final String delete_type = "DELETE FROM type_account WHERE id = ?";
    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {return builder.getConnection();}
    @Override
    public void insert(Type type){
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(insert_type, new String[] { "id" })) {
            Long Id = -1L;
            pst.setString(1, type.getType());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public void update(Type type){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_type)) {
            pst.setString(1, type.getType());
            pst.setLong(2, type.getId());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public void delete(Long Id){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_type)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public Type findById(Long Id) {
        Type type = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(select_type_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {type = fill(rs);}
            rs.close(); pst.close();
        } catch (Exception e) {System.out.println(e.getMessage());}
        return type;
    }
    @Override
    public List<Type> findAll() {
        List<Type> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_type);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {list.add(fill(rs));}
        } catch (Exception e) {System.out.println(e.getMessage());}
        return list;
    }

    private Type fill(ResultSet rs) throws SQLException {
        Type type = new Type();
        type.setId(rs.getLong("id"));
        type.setType(rs.getString("type"));
        return type;
    }
    public Type FindById(Long id, List<Type> types) {
        if (types != null) {for (Type c: types) {if (c.getId()==id) {return c;}}}
        else {return null;}
        return null;
    }
}

