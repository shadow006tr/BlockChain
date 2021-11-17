package blockchain;

public class Validator {

    /*
     * A validator to check the chain's correctness,
     * by comparing the previous hash field of each object
     * with the real hash stored in the previous object
     */

    public static boolean validate(Block block) {
        boolean result = true;                                                  // Return result
        String lastHash = block.getCurrentHash();                               // The hash of each block

        while (block.getNext() != null) {                                       // Run on the whole chain
            block = block.getNext();                                            // One block at a time
            if (!lastHash.equals(block.getPreviousHash())) {                    // If it finds inconsistency,
                result = false;                                                 // the chain is not valid.
                break;                                                          // So it stops running.

            } else {                                                            // if the chain is correct so far
                lastHash = block.getCurrentHash();                              // update the last hash
            }
        }

        return result;
    }
}
