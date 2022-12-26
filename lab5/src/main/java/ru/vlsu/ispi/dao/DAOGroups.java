package ru.vlsu.ispi.dao;

import ru.vlsu.ispi.beans.Group;
import ru.vlsu.ispi.beans.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOGroups {
    private final DAO dao;
    private final Const aConst;

    public DAOGroups(DAO dao, Const aConst) {
        this.dao = dao;
        this.aConst = aConst;
    }

    public void createGroup(Group group) {
        String insert = "INSERT INTO " + aConst.GROUP_TABLE + "("
                + aConst.GROUPS_NAME + ")"
                + "VALUES(?)";

        try {
            PreparedStatement prSt = dao.getDbConnection().prepareStatement(insert);
            prSt.setString(1, group.getGroupName());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Group> getGroups() {
        ArrayList<Group> listGroup = new ArrayList<>();
        String select = "SELECT * FROM " + aConst.GROUP_TABLE;

        try {
            PreparedStatement prSt = dao.getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt(1));
                group.setGroupName(resultSet.getString(2));

                listGroup.add(group);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listGroup;
    }

    public Group getGroupById(int id) {
        String select = "SELECT * FROM " + aConst.GROUP_TABLE
                + " Where " + aConst.GROUPS_ID + " = " + id;
        Group group = new Group();

        try {
            PreparedStatement prSt = dao.getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                group.setId(resultSet.getInt(1));
                group.setGroupName(resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return group;
    }

    public void updateGroup(Group group) {
        String update = "UPDATE " + aConst.GROUP_TABLE + " SET "
                + aConst.GROUPS_NAME + " = ? "
                + " WHERE " + aConst.GROUPS_ID + " = ?";

        try {
            PreparedStatement preparedStatement = dao.getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, group.getGroupName());
            preparedStatement.setInt(2, group.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup(int id) {
        String delete = "DELETE FROM " + aConst.GROUP_TABLE + " WHERE " + aConst.GROUPS_ID + " =?";

        try {
            PreparedStatement preparedStatement = dao.getDbConnection().prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isExists(Group group) {
        String query = "Select * from " + aConst.GROUP_TABLE
                + " WHERE " + aConst.GROUPS_ID + " =?";

        try (PreparedStatement preparedStatement = dao.getDbConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, group.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
