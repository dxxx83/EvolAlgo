
package evolalgo;

/**
 * Interface for development methods. All methods that want to develop a genotype
 * need to implement this method
 * @author Odd
 */
public interface IDevelopMethod {
    
    /**
     * Converts the input genotype to a phenotype that suits the problem
     * @param geno Genotype in bit string form. We currently assume that all
     * problems will contain genotypes in bit string form.
     * @return Phenotype in the form of an array of objects. Can be anything, 
     * as the fitness evaluator is the only other class that relies on the phenotype,
     * and this needs to be implemented on a per problem basis anyway.
     * @throws Exception 
     */
    public Object[] developPheno(Object geno) throws Exception;
}
