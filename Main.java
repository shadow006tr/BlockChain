package blockchain;

/*
* The blockchain project from JetBrains Academy.
*
* stage 1/6:
* this code will create a chain of blocks
* each holding previous and current block's SHA-256 value,
* calculated through all of their data.
*
* The project has:
* Block class, for creating chains in the blockchain
* Hash class, holding the SHA-256 encoding function,
* Validator class, holding the validator for the whole chain,
* and the Main class for starting the application.
*
*/

public class Main {
    public static void main(String[] args) {

        Block head = null;                                                  // Wanted to make a singly linked list,
        Block lastBlock = null;                                             // Saving the last block to change it's next
                                                                            // after creating a new chain.
        long tailIndex = 1;                                                 // so I'm keeping the head as Block object
        String lastHash = "0";                                              // Starting previous hash.

        final int repeatTimes = 5;                                          // Repeat times to create blocks for
                                                                            // the Project's checking system.

        for (; tailIndex <= repeatTimes; tailIndex++) {                     // A for loop to create the first blocks.
            Block block = new Block(lastHash, tailIndex);                   // Block creator.
            lastHash = block.getCurrentHash();                              // Saving the current hash as the last one.
            if (tailIndex == 1) {                                           // If the current block is the first, save
                head = block;                                               // it as the head of the chain.
            } else {                                                        // If not,
                if (!Validator.validate(head)) {                            // validate the whole new chain.
                    System.out.println("The newly created hash is conflicting with the chain!");
                    break;                                                  // If the chain is not valid: Stop!
                }
                lastBlock.setNext(block);
            }
            lastBlock = block;                                              // Saving the current block as the last one
            System.out.println("Block: ");                                  // Prints for the project's checking system.
            System.out.println("Id: " + block.getIdentifier());
            System.out.println("Timestamp: " + block.getTimeStamp());
            System.out.println("Hash of the previous block:\n" + block.getPreviousHash());
            System.out.println("Hash of the block:\n" + block.getCurrentHash() + '\n');
        }


    }
}
