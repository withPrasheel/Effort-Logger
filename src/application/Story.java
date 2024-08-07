package application;

public class Story {
	
    private String storyName,storyId;
	private int storyPoints, estimationTime;
    public String getStoryId() {
		return storyId;
	}
	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}
	private boolean selected;
    
    
	public Story(String storyName, String storyId, int storyPoints, int estimationTime, boolean selected) {
		super();
		this.storyName = storyName;
		this.storyId = storyId;
		this.storyPoints = storyPoints;
		this.estimationTime = estimationTime;
		this.selected = selected;
	}
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	public int getStoryPoints() {
		return storyPoints;
	}
	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}
	public int getEstimationTime() {
		return estimationTime;
	}
	public void setEstimationTime(int estimationTime) {
		this.estimationTime = estimationTime;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

    


}