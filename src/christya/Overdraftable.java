/*
        Overdraftable
        Author: Josua Christyanton
        Date: January 28th 2020

        Description:
        This interface, is supposed to be forced upon any other class that 
        inherits.
 */

package christya;

/**
 *
 * @author joss
 */
public interface Overdraftable {
    
    public final double OVERDRAFT_LIMIT = -500.00;

    /**
     * Abstract method setOverdraftAmount forces children, to inherit the ability
     * to set an overdraft limit.
     */
    public abstract void setOverdraftAmount();
 
}