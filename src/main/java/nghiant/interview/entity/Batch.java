package nghiant.interview.entity;

import java.util.Set;

public class Batch {
    private Integer id;
    private String name;
    private Set<Student> students;

    public Integer getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public Set<Student> getStudents() {
	return students;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setStudents(Set<Student> students) {
	this.students = students;
    }
}
