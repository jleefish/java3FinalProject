/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
package net.sourceforge.pmd.lang.dfa;

/**
 * @since Created on 14.07.2004
 * @author raik
 */
public class VariableAccessException extends Exception {

    public VariableAccessException() {
        super("VariableAccess error."); //TODO redefinition
    }

    public VariableAccessException(String message) {
        super(message);
    }
}
