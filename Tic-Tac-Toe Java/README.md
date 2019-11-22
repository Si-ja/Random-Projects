### Tic-Tac-Toe with Java

While getting into Java I revisited an old project idea of Tic-Tac-Toe.

This version was written in a relativelly simple manner and can be played in the cmd/terminal in the following modes:

----
* Players vs Player
* Player vs Computer:
  - Easy mode - Player Starts and computer is fully random
  - Medium mode - Computer Starts and is fully random
  - Hard mode - Computer Starts and plays by a certain solid strategy
----

The structure of the code:
* `TheGame.java` contains the main method in which the whole game is structured for various ways it can be played.
* `Board.java` creates an field object, that represents the board. All methods saved in it are ment to verify how the board looks, what moves players make, etc.  

Just compile it and play.
```
javac TheGame.java
java TheGame
```

Enjoy.

----
__Regarding Licenses:__

Was made for fun, so use it for fun, not commercial purposes...though with this quality, let's be fair, who will buy it.
