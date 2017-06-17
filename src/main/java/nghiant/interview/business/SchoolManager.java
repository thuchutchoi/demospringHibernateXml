package nghiant.interview.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nghiant.interview.dao.BatchDAO;
import nghiant.interview.dao.StudentDAO;
import nghiant.interview.entity.Batch;
import nghiant.interview.entity.Student;
import nghiant.interview.model.SchoolModel;

@Component
public class SchoolManager {
    @Autowired
    private BatchDAO batchDAO;
    @Autowired
    private StudentDAO studentDAO;

    public void addBatch(Batch batch, Student student) {
	batchDAO.addBatch(batch);
	student.setBatch(batch);
	studentDAO.addStudent(student);
    }

    public BatchDAO getBatchDAO() {
	return batchDAO;
    }

    public void getBatchInfo(SchoolModel schoolModel) {
	Batch selectedBatch = schoolModel.getSelectedBatch();
	List<Batch> batches = batchDAO.getBatchList();
	if (selectedBatch != null) {
	    Integer batchId = selectedBatch.getId();
	    for (Batch batch : batches) {
		if (batch.getId().equals(batchId)) {
		    selectedBatch = batch;
		    break;
		}
	    }
	} else {
	    selectedBatch = batches.get(0);
	}
	schoolModel.setBatches(batches);
	schoolModel.setSelectedBatch(selectedBatch);
    }

    public void setBatchDAO(BatchDAO batchDAO) {
	this.batchDAO = batchDAO;
    }
}
