package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReEstimation {

	private List<Integer> estimationScores;		//Stores list of team members estimation scores.
	private  int estimationThreshold;			//Threshold for which the estimations should converge to complete.
	private  int numTeamMembers;				//Number of team members.
	
	public ReEstimation(List<Integer> initialScores, int estimationThreshold) {			//Constructor
		if (initialScores == null || initialScores.isEmpty()) {		//If initial list of estimation scores is empty.
			throw new IllegalArgumentException("There must be at least one initial score.");	
		}
		this.estimationScores = new ArrayList<>(initialScores);		//Creates new list containing initial scores to be manipulated independently.
		this.estimationThreshold = estimationThreshold;			//Represents bounds between highest and lowest estimates must be to complete estimation process.
		this.numTeamMembers = initialScores.size();			//Number of team members in session recorded by amount of scores recorded.
	}
	
	public void reEstimationRound(List<Integer> newScores) {		//Performs a re-estimation function through updating scores.
		estimationScores = new ArrayList<>(newScores);	//New list created with new estimation scores.
	}
	
	public double reCalculateAvg() {		//Calculates average of current estimation scores.
		return estimationScores.stream().mapToInt(Integer::intValue).average().orElse(0);	//Average of the estimation scores.
	}
	
	public boolean thresholdMet() {			//To check if estimation scores are within bounds to finish estimation process.
		int maxEstimate = estimationScores.stream().max(Integer::compare).orElse(0);		//Uses max method to find maximum value out of estimates.
		int minEstimate = estimationScores.stream().min(Integer::compare).orElse(0);		//Uses min method to find minimum values out of estimates.
		
		return maxEstimate - minEstimate <= estimationThreshold;	//Returns true or false based on if estimation scores are within bounds.
	}
	
	
	public boolean beginReEstimation() {	//To begin the re-estimation process.
		return thresholdMet();		//Returns true for end of re-estimation, false otherwise.
	}
	
}