package nghiant.interview.model;

import nghiant.interview.entity.Batch;
import nghiant.interview.entity.Student;

public class AddBatchModel {
    private Batch batch;
    private Student student;

    public Batch getBatch() {
	return batch;
    }

    public Student getStudent() {
	return student;
    }

    public void setBatch(Batch batch) {
	this.batch = batch;
    }

    public void setStudent(Student student) {
	this.student = student;
    }
}
