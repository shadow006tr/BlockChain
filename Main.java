package blockchain;

/*
* The blockchain project from JetBrains Academy.
*
* stage 2/6:
* this code will create a chain of blocks
* each holding previous and current block's SHA-256 value,
* calculated through all of their data.
*
* The project has:
* Block class, creating the blockchain and printing info about each block added,
* BlockChain class which holds the BlockChain Arraylist of blocks and some info,
* BlockChainLoader class which manages saving and loading blockchains from a file,
* Hash class, holding the SHA-256 encoding function,
* Validator class, holding the validator for the whole chain,
* and the Main class for starting the application.
*
*/

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final String PATH = "BlockChain.sch";                    // A path to save the blocks that were mined

    public static void main(String[] args) throws IOException {

        int prefix = getPrefix();                                           // An amount of zeros we want to get to
                                                                            // Complicate hashing time
        BlockChain blockChain = BlockChainLoader.loadBlockChain(prefix, PATH);
        final int repeatTimes = 5;                                          // Repeat times to create blocks for
                                                                            // the Project's checking system.

        for (int i = 0; i < repeatTimes; i++) {                             // A for loop to create an amount of blocks
            Block block = blockChain.addNew();                              // Creating a new block in the chain
            long runtTimeSeconds = new Date().getTime() - block.getTimeStamp();
            BlockChainLoader.saveBlock(PATH, block);                        // Saving the block created to the PATH
            outputResults(block, runtTimeSeconds);                          // Printing the results of creating a block
        }
    }

    static int getPrefix() {                                                // A method to pick the amount of zeros
        int prefix;                                                         // in the prefix
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter how many zeros the hash must start with: ");
            prefix = scanner.nextInt();
        }
        return prefix;
    }

    static void outputResults(Block block, long runtTimeSeconds) {          // A method to print after every created block.
        System.out.println(block);                                          // Printing the block's information
        System.out.println("Block was generating for " + runtTimeSeconds + " seconds\n");
    }                                                                       // and the time it took to create it.
}
