package blockchain;

import java.io.*;
import java.util.ArrayList;

public class BlockChainLoader {

    /*
     * A BlockChainLoader, managing saving and loading blockchains,
     */


    
    public static BlockChain loadBlockChain(int prefix, String path) {
        try (                                                               // a method to load a BlockChain
                FileInputStream file = new FileInputStream(path);           // Try with resources for a file stream
                ObjectInputStream objectInput = new ObjectInputStream(file) // and a objectInput stream.
                ) {


            ArrayList<Block> blockchain = new ArrayList<>();                // Creating an empty blockchain object
            Block block;                                                    // An empty block for assigning

            do {                                                            // Read all the objects
                block = (Block) objectInput.readObject();                   // one by one into the block field
                if (block != null) {
                    blockchain.add(block);                                  // If loaded successfully, add it
                }                                                           // to the chain
            } while (block != null);
            return new BlockChain(prefix, blockchain);                      // Return a new blockchain with the
                                                                            // loaded chain.

        } catch (IOException | ClassNotFoundException e) {                  // If the loading failed,
            return new BlockChain(prefix);                                  // create a new blockchain.
        }
    }

    
    public static void saveBlock(String path, Block block) throws IOException {
                                                                            //a method to save a new block to the file in the path
        try(                                                                // Try with resources for a file stream
                FileOutputStream file = new FileOutputStream(path, true);
                ObjectOutputStream objectOutput = new ObjectOutputStream(file)
                                                                            // and a objectOutput stream.
                ) {
            objectOutput.writeObject(block);                                // Adding a new object to the file.
        }
    }
}
