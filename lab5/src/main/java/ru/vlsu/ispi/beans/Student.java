package ru.vlsu.ispi.beans;

public class Student{

    private int id;
    private String studentName;
    private String studentBirthdate;
    private int studentGroupsId;

    Group group = new Group();

    public Student() {

    }

    public Student(String studentName, String studentBirthdate, int studentGroups) {
        this.studentName = studentName;
        this.studentBirthdate = studentBirthdate;
        this.studentGroupsId = studentGroups;
    }

    public Student(int id, String studentName, String studentBirthdate, int studentGroups) {
        this.id = id;
        this.studentName = studentName;
        this.studentBirthdate = studentBirthdate;
        this.studentGroupsId = studentGroups;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getStudentName() { return studentName; }

    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentBirthdate() { return studentBirthdate; }

    public void setStudentBirthdate(String studentBirthdate) { this.studentBirthdate = studentBirthdate; }

    public int getStudentGroupsId() { return studentGroupsId; }

    public void setStudentGroupsID(int studentGroups) { this.studentGroupsId = studentGroups; }

    public String getStudentGroups() { return group.getGroupName(); }

    public void setStudentGroups(String groupName) { group.setGroupName(groupName); }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id: " + id
                + ", studentName: " + studentName
                + ", studentBirthdate: " + studentBirthdate
                + ", studentGroup: " + getStudentGroups()
                + "]";
    }
}
