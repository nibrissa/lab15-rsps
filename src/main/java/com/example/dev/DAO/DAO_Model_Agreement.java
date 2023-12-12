package com.example.dev.DAO;

import com.example.dev.DataClass.Agreement;
import com.example.dev.DataClass.Type;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
public class DAO_Model_Agreement implements RepositoryDAO<Agreement> {
    private static final String select_all_agreement = "SELECT * FROM agreement";
    private static final String select_agreement_ById = "SELECT * FROM agreement WHERE id = ?";
    private static final String insert_agreement = "INSERT INTO agreement(number, note, open, close) VALUES(?,?,?,?)";
    private static final String edit_agreement = "UPDATE agreement SET number=?, note=?, open=?, close=? WHERE id = ?";
    private static final String delete_agreement = "DELETE FROM agreement WHERE id = ?";
    private ConnectionBuilder builder = new DbConnectionBuilder();
    private Connection getConnection() throws SQLException {return builder.getConnection();}
    @Override
    public void insert (Agreement agreement) {
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(insert_agreement, new String[] { "id" })) {
            Long Id = -1L;
            pst.setString(1, agreement.getNumber());
            pst.setString(2, agreement.getNote());
            pst.setTimestamp(3,Timestamp.from(agreement.getDataOpen().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pst.setTimestamp(4, Timestamp.from(agreement.getDataClose().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    @Override
    public void update(Agreement agreement){
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(edit_agreement)) {
            pst.setString(1, agreement.getNumber());
            pst.setString(2, agreement.getNote());
            pst.setTimestamp(3,Timestamp.from(agreement.getDataOpen().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pst.setTimestamp(4, Timestamp.from(agreement.getDataClose().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pst.setLong(5, agreement.getId());
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    @Override
    public void delete(Long Id) {
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(delete_agreement)) {
            pst.setLong(1, Id);
            pst.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
    }
    @Override
    public Agreement findById(Long Id) {
        Agreement agreement = null;
        try (Connection con = getConnection()) {
            PreparedStatement pst = con.prepareStatement(select_agreement_ById);
            pst.setLong(1, Id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {agreement = fill(rs);}
            rs.close();
            pst.close();
        } catch (Exception e) {System.out.println(e.getMessage());}
        return agreement;
    }

    @Override
    public List<Agreement> findAll() {
        List<Agreement> list = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(select_all_agreement);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {list.add(fill(rs));}
        } catch (Exception e) {System.out.println(e.getMessage());}
        return list;
    }
    private Agreement fill(ResultSet rs) throws SQLException {
        Agreement agreement = new Agreement();
        agreement.setId(rs.getLong("id"));
        agreement.setNumber(rs.getString("number"));
        agreement.setNote(rs.getString("note"));
        agreement.setDataOpen(LocalDate.parse(rs.getDate("open").toString()));
        agreement.setDataClose(LocalDate.parse(rs.getDate("close").toString()));
        return agreement;
    }
    public Agreement FindById(Long id, List<Agreement> agreements) {
        if (agreements != null) {for (Agreement c: agreements) {if (c.getId()==id) {return c;}}}
        else {return null;}
        return null;
    }
}