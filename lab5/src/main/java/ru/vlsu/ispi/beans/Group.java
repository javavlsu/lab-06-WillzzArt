package ru.vlsu.ispi.beans;

public class Group {

    private int id;
    private String groupName;

    public Group() {

    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getGroupName() { return groupName; }

    public void setGroupName(String groupName) { this.groupName = groupName; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id: " + id + ", group_name: " + groupName + "]";
    }
}