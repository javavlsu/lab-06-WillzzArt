package ru.vlsu.ispi.dao;

import ru.vlsu.ispi.beans.Group;
import ru.vlsu.ispi.beans.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOStudents {
    //DAO dao = new DAO();

    private final DAO dao;
    private final Const aConst;

    public DAOStudents(DAO dao, Const aConst) {
        this.dao = dao;
        this.aConst = aConst;
    }

    public void createStudent(Student student) {
        String insert = "INSERT INTO " + aConst.STUDENT_TABLE + "("
                + aConst.STUDENTS_NAME + ","
                + aConst.STUDENTS_BIRTHDATE + ","
                + aConst.STUDENTS_GROUPS + ")"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = dao.getDbConnection().prepareStatement(insert);
            prSt.setString(1, student.getStudentName());
            prSt.setString(2, student.getStudentBirthdate());
            prSt.setInt(3, student.getStudentGroupsId());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Student> getStudents() {
        ArrayList<Student> listStudents = new ArrayList<>();
        String select = "SELECT " + aConst.STUDENTS_ID + ", "
                + aConst.STUDENTS_NAME + ", "
                + aConst.STUDENTS_BIRTHDATE + ", "
                + aConst.GROUPS_NAME
                + " FROM " + aConst.STUDENT_TABLE + ", " + aConst.GROUP_TABLE
                + " WHERE " + aConst.STUDENTS_GROUPS + " = " + aConst.GROUPS_ID
                + " ORDER BY " + aConst.STUDENTS_ID;

        try {
            PreparedStatement prSt = dao.getDbConnection().prepareStatement(select);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {

                Student student = new Student();
                Group group = new Group();
                student.setId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setStudentBirthdate(resultSet.getString(3));
                group.setGroupName(resultSet.getString(4));
                student.setStudentGroups(group.getGroupName());

                listStudents.add(student);

                //System.out.println(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listStudents;
    }

    public void updateStudent(Student student) {
        String update = "UPDATE " + aConst.STUDENT_TABLE + " SET "
                + aConst.STUDENTS_NAME + " = ? , "
                + aConst.STUDENTS_BIRTHDATE + " = ? , "
                + aConst.STUDENTS_GROUPS + " = ? "
                + " WHERE " + aConst.STUDENTS_ID + " = ?";

        try {
            PreparedStatement preparedStatement = dao.getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentBirthdate());
            preparedStatement.setInt(3, student.getStudentGroupsId());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String delete = "DELETE FROM " + aConst.STUDENT_TABLE + " WHERE " + aConst.STUDENTS_ID + " =?";

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
}
