package blockchain;

import java.util.Date;

public class Block {

    /*
    * A class for the Block objects.
    * has a constructor which takes the previous block's hash and an identifier
    * and creates an object of the class, calculating and assigning the object's own current hash
    * The timestamp is in seconds to create some pseudo randomness
    * also each block holds a reference to the next block, creating a single sided chain.
    */

    private final String previousHash;                                      // The hash value of the last block.
    private final String currentHash;                                       // The hash value of the current block.
    private final Long identifier;                                          // Block's id within the chain.
    private final Long timeStamp = new Date().getTime();                    // Timestamp in seconds
                                                                            // to create pseudo-randomness
    private Block next = null;                                              // Reference to the next block in the chain

    public Block(String previousHash, Long identifier) {                    // Constructor. Takes:
        this.previousHash = previousHash;                                   // the previous block's hash
        this.identifier = identifier;                                       // and this block's identifier
        this.currentHash = Hash.encode(previousHash + identifier.toString() + timeStamp);
    }                                                                       // and calculating it own hash
                                                                            // with the data it has.

    public String getPreviousHash() {                                       // Getters for each parameter,
        return previousHash;                                                // except timeStamp.
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public Block getNext () {
        return next;
    }

    public void setNext (Block block) {                                     // Setter for chaining the next block
        this.next = block;
    }

}
