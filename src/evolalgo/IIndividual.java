
package evolalgo;

/**
 * The individual-interface. All would-be individuals must implement these methods.
 * It is currently assumed that only one class of individual will ever be needed.
 * @author Odd
 */
public interface IIndividual {
    public void setPhenotype(Object phenotype);
    
    public Object phenotype();
    
    public Object getGenes();
    
    public void growOlder();
    
    public int age();
    
    public void setFitness(double fitness);
    
    public double fitness() throws Exception;
    
    @Override
    public String toString();
}