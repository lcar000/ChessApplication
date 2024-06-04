# Desktop Chess Application

This is a simple desktop chess app written in Java featuring a basic graphical user interface which leverages existing Java Swing functionality. The program allows 
two local users (sharing a computer) to play chess under the standard rules. The application allows players to set their names and choose display options. Users are
able to start a new game, save a current game with all player information, and load a saved game. Draw functionality and timer functionality will be added at a later date

## Features

- **Start Menu**: After launching the program a menu will be displayed with the option to start a new game or load an existing one.
- **New Game Setup**: Users can set up a new game by entering a game name, player name info, choosing display colors and selecting time controls (TBA)
- **Load Saved Game**: Users can load previously saved games, identified by game name.
- **Gameplay**: The board is generated with all pieces in their initial positions. Players can click on pieces to select them and then click on valid squares to move them.
  The game enforces the rules of chess, such as valid moves and checkmate detection (Not perfectly yet).
- **Save Game**: At any point during play users can save the game to be resumed later.

  ## How to Run

  To run the game:
  1. Clone the project or download all files from the DEVELOP branch, develop is the most up to date version at this time
  2. Java must be installed on your system
  3. Compile all Java files in the project (Compiled using OpenJDK version 20, not guaranteed to work with other versions).
  4. Run the 'ChessGUI' class to start the game.

  ## Dependencies
  The program uses Java Swing for the GUI and Junit for testing

  ## File Structure
  
  - `ChessGUI.java`: Contains the main GUI class for the chess game.
- `ChessBoard.java`: Represents the chess board and handles mouse input.
- `ChessController.java`: Manages the game logic and controls interactions between the GUI and game state.
- `UtilityGame.java`: Provides utility functions for the game logic, such as checking valid moves and detecting checkmate.
- `CurrentGame.java`: Represents the current state of a game, including player names, board position, and game settings.
- `ChessGame.java`: Defines the abstract class for the chess game, including the game board and player turns.

## Known Issues

- Checkmate and check detection might not always be accurate in certain edge cases.
- 
## Future Improvements

- Finish implementation of time controls
- Add draw functionality
- Implement more advanced chess features, such as castling and en passant.
- Enhance the GUI with better graphics and animations.
- Add support for multiplayer games over a network. (Longterm?)

  ## Contributors

  - Daniel Kang
  - Robert Petrisor
  - Haoqi Su
