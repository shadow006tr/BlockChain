package blockchain;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Block implements Serializable {
    /*
    * A class for the Block objects.
    * has a constructor which takes the previous block's hash and the current identifier,
    * creates an object of the class, calculating and assigning the object's own current hash
    * The timestamp is in seconds to create some pseudo randomness
    * also each block holds a reference to the next block, creating a single sided chain.
    */

    private static final long serialVersionUID = 1L;                        // Version for Serializing

    private final String previousHash;                                      // The hash value of the last block.
    private final int identifier;                                           // Block's id within the chain.
    private final Long timeStamp = new Date().getTime();                    // Timestamp in seconds

                                                                            // to create pseudo-randomness
    private int magicNumber;
    private String currentHash;                                             // The hash value of the current block.

    public Block(String previousHash, int identifier) {                     // Constructor. Takes:
        this.previousHash = previousHash;                                   // the previous block's hash
        this.identifier = identifier;                                       // and this block's identifier
        magicNumber = 0;
        this.currentHash = calculateHash();
    }                                                                       // and calculating it own hash
                                                                            // with the data it has.

    public String getPreviousHash() {                                       // Getters for each parameter,
        return previousHash;                                                // except timeStamp.
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public int getIdentifier() {
        return identifier;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void mine(int prefix) {
        Random random = new Random();
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!currentHash.substring(0, prefix).equals(prefixString)) {
            magicNumber = random.nextInt();
            currentHash = calculateHash();
        }
    }

    @Override
    public String toString() {
        return "Block: \n" +
                "Id: " + identifier + "\n" +
                "Timestamp: " + timeStamp + "\n" +
                "Magic number: " + magicNumber + "\n" +
                "Hash of the previous block: \n" +
                previousHash + "\n" +
                "Hash of the block: \n" +
                currentHash;
    }

    private String calculateHash() {
        return Hash.encode(previousHash + identifier + timeStamp + magicNumber);
    }

}
