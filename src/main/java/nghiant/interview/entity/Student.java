package nghiant.interview.entity;

public class Student {
    private Batch batch;
    private String id;
    private String name;

    public Batch getBatch() {
	return batch;
    }

    public String getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setBatch(Batch batch) {
	this.batch = batch;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }
}
