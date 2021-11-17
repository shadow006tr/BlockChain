# BlockChain #
## a HyperSkill.org project ##
### Stage 1/6 ###

 This is my code for [JetBrains Academy](https://hyperskill.org/)'s BlockChain Project.


 This application will create a chain of block objects

 each holding previous and current block's SHA-256 value,

 calculated through all of their data.


 Currently, the program will create a sertain amount of Blocks,
 each holding:
> The hash value of the last block,

> the hash value of the current block,

> block's id within the chain,

> timestamp in seconds, to create pseudo-randomness

> and a reference to the next block in the chain

 to create a singly connected linked list of blocks.
 
 The app is built of the following classes:

> Block class, for creating chains in the blockchain

> Hash class, holding the SHA-256 encoding function

> Validator class, holding the validator for the whole chain

> and the Main class for starting the application.

This is a work in progress, it will be updated with each stage I complete.

### Course ###

> Java
