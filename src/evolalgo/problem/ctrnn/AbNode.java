package evolalgo.problem.ctrnn;

import java.util.List;

/**
 *
 * @author Odd
 */
abstract class AbNode {
    double gain;
    double timeConstant;
    double selfWeight;
    
    int timeStep;
    
    List<Object[]> connections;
    
    double y = 0;
    
    double bias;
    
    double dy(double s){
        return (1 / timeConstant) * (-y + s + bias);
    }
    
    abstract double s(boolean[] sensorInputs);
    
    double output(){
        return 1 / (1 + Math.pow(Math.E, -gain * y));
    }
}