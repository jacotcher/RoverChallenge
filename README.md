# MarsRoverChallenge
MarsRoverChallenge is a Java project that takes various inputs and uses them to define a plateau and initialise two Rover objects. It then takes instructions on moving the Rovers and outputs their final location and orientation to the terminal.
Java documentation can be accessed in the 'Doc' directory where you will find index.html, all methods and classes are further explained here.
## Installation

The system has been designed so that no installation should be required. Simply compile and run MarsPlateau.java by entering the following commands on a terminal after navigating to the "marsRoverChallenge" Directory: 

```bash
javac MarsPlateau.java
```

Followed by

```bash
java MarsPlateau
```



## Inputs
There are 5 lines of required user input (via the command line) and 2 outputs. The required input data is regex checked and is required to be in the form:
(Where '1' represents any integer and where "LRM" represents any string made up only of L R, M and whitespace, and where N represents a directional character of N, E, S or W)

```bash
Plateau size:           1 1 
RoverOne Location:      1 1 N
RoverOne Instructions:  LRM
RoverTwo Location:      1 1 N
RoverTwo Instructions:  LRM

```

## Testing
The program has been unit tested using a TDD approach. In order to run the tests, compile and run MarsRoverTest.java by navigating to the "marsRoverTesting" directory in a terminal and entering the following commands:

```bash
javac MarsRoverTest.java
```
Followed by

```bash
java MarsRoverTest
```

Also feel free to run MarsPlateau.java and manually test with your own test inputs.

