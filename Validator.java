package blockchain;

import java.util.ArrayList;

public class Validator {

    /*
     * A validator to check the chain's correctness,
     * by comparing the previous hash field of each object
     * with the real hash stored in the previous object
     */

    public static boolean notValid(ArrayList<Block> blockChain) {
        boolean result = false;                                             // Return result
        String lastHash = "0";                                              // The hash of each block

        for (Block block : blockChain) {                                    // Run on the whole chain
            if (!lastHash.equals(block.getPreviousHash())) {                // If it finds inconsistency,
                result = true;                                              // the chain is not valid.
                break;                                                      // So it stops running.
            } else {                                                        // if the chain is correct so far
                lastHash = block.getCurrentHash();                          // update the last hash
            }
        }

        return result;
    }
}
