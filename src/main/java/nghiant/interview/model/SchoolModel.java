package nghiant.interview.model;

import java.util.List;

import nghiant.interview.entity.Batch;

public class SchoolModel {
    private List<Batch> batches;
    private Batch selectedBatch;

    public List<Batch> getBatches() {
	return batches;
    }

    public Batch getSelectedBatch() {
	return selectedBatch;
    }

    public void setBatches(List<Batch> batches) {
	this.batches = batches;
    }

    public void setSelectedBatch(Batch selectedBatch) {
	this.selectedBatch = selectedBatch;
    }
}
