package javastuff;

import java.util.Random;
import java.util.Arrays;
import java.math.*;

public class DataEvaluator{

    private double[] agent_input;
    private double[] expected_output;
    private double[] agent_output;
    private double[] agent_output_validated;
    private double[][] input;
    private int training_epoches = 150;
    private int cell_blocks = 10;
    private Random r = new Random(1);
    private boolean validationMode = true;
    private int training_input_size = 4;
    private int total_inputs;
    private int current_input;
    private LSTM agent;
    
    public DataEvaluator(double[][] input){
	this.input = input;
	this.total_inputs = input.length;
	this.current_input = 0;
    }

    public void truncateData(){
	int number;
	
	for(int i = 0; i < this.input.length; i ++){
	    for(int j = 0; j < 4; j++){
		number = (int)this.input[i][j];

		this.input[i][j] = (double)number;
	    }
	}
    }

    public void evaluateData() throws Exception {

	this.truncateData();
	
	agent = new LSTM(r, training_input_size, training_input_size, cell_blocks);

	//reset the agent
	agent.Reset();
	
	//main training loop
	for(int i = 0; i < training_epoches; i++){

	    //agent.Reset();

	    agent_input = input[current_input];

	    // for debugging
	    //for(double[] row : input){
	    //System.out.println(Arrays.toString(row));
	    //}

	    //if you are on the last set of data there is nothing to check the response against
	    if(current_input < total_inputs - 1){
		expected_output = input[current_input + 1];

		agent_output_validated = agent.Next(agent_input, expected_output);

		agent_output = agent.Next(agent_input);

		System.out.println("\n iteration " + i + "    \n\n\ninput:" + Arrays.toString(agent_input) + " \nexpected output:" + Arrays.toString(expected_output) + " \nvalidated output:" + Arrays.toString(agent_output_validated) + " \noutput:" + Arrays.toString(agent_output) + " \n\nPercentage Errors" + Arrays.toString(this.getErrorPercentage(agent_input, agent_output)));

		System.out.println("\n\n**********The Overall Error for this Iteration is**********");

		double[] outcent = this.getErrorPercentage(agent_input, agent_output);
		double average, total = 0;

		for(double d : outcent)
		    total += d;

		average = total/outcent.length * 100;
		
		System.out.println(average);
	    }

	    else{

		agent_output = agent.Next(agent_input);

		System.out.println(i + "    \n\n\ninput:" + Arrays.toString(agent_input) + " \noutput:" + Arrays.toString(agent_output));

	    }

	    if(current_input == total_inputs - 1){
		current_input = 0;
		agent.Reset();
	    }
	    else
		current_input++;
	    
	}
	
    }

    public void setValidationMode(boolean bool){
	this.validationMode = bool;
    }

    public double[] getErrorPercentage(double[] input, double[] output){

	double[] returnArray = new double[input.length];
	
	for(int i = 0; i < input.length; i++){
	    returnArray[i] = Math.abs(input[i] - output[i])/input[i];
	}

	return returnArray;
    }
    
}
