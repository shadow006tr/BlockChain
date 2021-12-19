package blockchain;

import java.util.ArrayList;

public class BlockChain {

    /*
     * A BlockChain class, holding the blockchain itself,
     * which is an ArrayList of Blocks,
     * and the requested prefix length
     */

    private final int prefix;                                               // The length of the prefix requested
    private final ArrayList<Block> blockChain;                              // The BlockChain itself


    public BlockChain(int prefix) {                                         // A constructor if we don't have
        this.prefix = prefix;                                               // an existing saved blockchain
        blockChain = new ArrayList<>();
    }

    public BlockChain(int prefix, ArrayList<Block> blockChain) {
        this.prefix = prefix;
        this.blockChain = blockChain;
    if(Validator.notValid(blockChain)) {                                    // Validating the loaded chain
            throw new RuntimeException("The newly created hash is conflicting with the chain!");
        }
    }

    public Block addNew() {
        Block block;
        if (blockChain.size() == 0) {
            block = new Block("0", 1);                                      // In case the block is the first one
        } else {
            block = new Block(blockChain.get(blockChain.size() - 1).getCurrentHash(), blockChain.size() + 1);
        }
        block.mine(prefix);                                                 // Mine a correct hash with prefix len
        blockChain.add(block);                                              // Adding newly mined block to the chain
        if(Validator.notValid(blockChain)) {                                // Validating the chain with new block
            throw new RuntimeException("The newly created hash is conflicting with the chain!");
        }
        return block;
    }

}
