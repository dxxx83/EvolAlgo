package evolalgo.problem.sdm;

import java.util.ArrayList;
import java.util.List;

public class SpikeIntervalDistance extends AbstractSpikePenalty implements ISDM {

	/**
	 * Class for computing the Spike Interval Distance
	 * @author Andreas
	 */
	double p = 2.0;
	private double threshold = 35;
	@Override
	public double calculateDistance(double[] target, double[] spiketrain) {
		double d;
		List<Integer> targetSpikes = new ArrayList<Integer>();
        List<Integer> spiketrainSpikes = new ArrayList<Integer>();
       
        for (int i = 0; i < target.length; i++){
            if(spiketrain[i] >= threshold) spiketrainSpikes.add(i);
            if(target[i] >= threshold) targetSpikes.add(i);
        }
      
        int N = (targetSpikes.size() < spiketrainSpikes.size()) ? targetSpikes.size() : spiketrainSpikes.size();
  
        double sum = 0.0;
        
        for (int i = 0; i < N-1; i++){
            sum += (double)Math.pow(
            		(double)Math.abs(
            				(targetSpikes.get(i+1) -targetSpikes.get(i)) - 
            				(spiketrainSpikes.get(i+1) - spiketrainSpikes.get(i))
            				), 
            				p);
        }
        sum += calculatePenalty(targetSpikes.size(), spiketrainSpikes.size(), target.length);
        d = Math.pow(sum, 1.0/p) / (double) N-1.0;
        return d;
	}
	@Override
	public double convertToFitness(double distance) {
		// TODO Auto-generated method stub
		return 0;
	}

}
