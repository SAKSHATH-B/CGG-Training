package cgg.map;

import java.util.List;

public class Detail {

	private int detialId;
	private List<String> details;
	
	public Detail(int detialId, List<String> details) {
		super();
		this.detialId = detialId;
		this.details = details;
	}

	public int getDetialId() {
		return detialId;
	}

	public List<String> getDetails() {
		return details;
	}
	
	
}
