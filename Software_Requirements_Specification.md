-------------
# Don’t get Angry Software Requirements Specification #
-------------
**Don’t get Angry**  
**Software Requirements Specification**

**Version 1.1**

## Revision History ##
| Date       | Version | Description                                      | Author |
|------------|---------|--------------------------------------------------|--------|
| 20/10/2017 | 1.0     | Dokument created                                | Dimitar Dimitrov     |
| 26/10/2017 | 1.0     | Dokument updated with appropriate links                                | Dimitar Dimitrov     |

## Table of Contents ##
1. Introduction
        1. Purpose
        2. Scope
        3. Definitions, Acronyms and Abbreviations
        4. Document - References
2. Overall Description
        1. Product Perspective
        2. Product Functions
        3. User Characteristics
        4. Constraints
        5. Assumptions and Dependencies
3. Specific Requirements
        1. Functionality
                1. Overall Use-Case-Diagram
                2. Gameplay
                3. Help
                4. Exit
        2. Usability
                1. Training Time
                2. Hardware Requirements
                3. Software Requirements
        3. Reliability
                1. Availability
                2. Mean Time Between Failures (MTBF)
                3. Mean Time To Repair (MTTR)
                4. Accuracy
                5. (Maximum) Bugs or Defect rate
        4. Performance
                1. Response Time
                2. Throughput
                3. Capacity
                4. Degradation modes
                5. Resource utilizations
        5. Supportability
        6. Design Constraints
        7. On-Line User Documentation and Help System Requirements
        8. Purchased Components
        9. Interfaces
                1. User Interfaces
                2. Hardware Interfaces
                3. Software Interfaces
                4. Communication Interfaces
        10. Licensing Requirements
        11. Legal, Copyright, and Other Notices
        12. Applicable Standards
4. Supporting Information

### 1. Introduction ###
My goal is to develop a desktop implementation of the famous game “Don’t get Angry”. More about this on my blog.

1. **Purpose**  
This Document should provide information about the requirements and documents associated with the project.
2. **Scope**  
This document is for internal use and as a guideline for the creation of the project.
3. **Definitions, Acronyms, and Abbreviations**  
n/a = not applicable  
tbd = to be determined 
4. **References**

| File                               | Link                                                                                                           |
|------------------------------------|----------------------------------------------------------------------------------------------------------------|
| Blog                               | https://https://dontgetangrysite.wordpress.com//                                                                                 |
| GitHub                             | https://github.com/mite134/DontGetAngry                                                                            |
| Use-Case Pawn goes in	             | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCasePawnGoesIn.txt                          |
| Use-Case Move Pawn                 | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCaseMovePawn.md                             |
| Use-Case Calculate Moves           | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCaseValidMoves.md                           |
| Use-Case Hit enemy pawn            | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCaseHitEnemyPawn.txt                        |
| Use-Case Can't hit pawn            | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCaseCantHitPawn.txt                         |
| Use-Case Exit                      | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCaseExit.txt                                |
| Use-Case Help                      | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/useCaseHelp.txt                                |
| Software Architecture Document     | https://github.com/mite134/DontGetAngry/blob/master/Software_Architecture.md                                   |
| Function Points                    | https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/FP%20and%20Use%20Case.png                      |
| Risikomanagement                   | https://github.com/mite134/DontGetAngry/blob/master/Risk_Management.md                                         |

### 2. Overall Description ###
This project is about a desktop application written in Java. It lets 4 users play “Don’t get Angry’ via hot-seat co-op. It can be played with the standard rules or using some alternative rules such as the ability to to backwards or removing the option to jump over figures or even allowing you to stack pieces on top of each other to block the opponent's path.

1. **Product Perspective**  
1. **Product Perspective**  
The game should bring fun to all kinds of users. It provides 4 player offline multiplayer so you can have fun even in a remote location where there is no internet.
2. **Product Functions**
        - Start a new game (basic or with additional rule)
        - Start a game from a set of positions
        - Rolling a dice and moving
        - Hitting enemy pawns and sending them to the starting zone
        - Winning the game
3. **User Characteristics**  
There are no requirements for the user since the game is pretty simple and can be played by anyone at anytime.
4. **Constraints**  
The application is stand alone and only requires java runtime environment to be installed on the computer
5. **Assumptions and Dependencies**
        - IDE: Eclipse/InteliJ
        - Versionskontrolle: Selbst, GitHub
        - Scrum: Redmine
        - Programmiersprache: Java
        - Datenbank: keine
        - Tests: Cucumber, .feature-file Test, JUint

### 3. Specific Requirements ###
1. **Funcionality**
        1. Overall Use-Case-Diagram  
GitHub: <a href="https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/Overall_UCD.png">https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/Overall_UCD.png</a>  
![Overall UCD](https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/Overall_UCD.png "Overall UCD")
        2.Gameplay
		The user(s) should be able to play the board game Don't get angry
        3. Help
		There should be a help popup explaining the rules
        4. Exit 
Clicking the Exit button stops the game and exits from the application.
All Use cases ccan be seen here:<a href="https://github.com/mite134/DontGetAngry/tree/master/Use%20Cases">https://github.com/mite134/DontGetAngry/tree/master/Use%20Cases</a>
2. **Usability**
        1. Training Time  
The time it takes to read the rules if the user doesn’t already know them. 
        2. Hardware Requirements  
Coputer that can run a Java application
        3. Software Requirements  
Java Runtime Environment
3. **Reliability**
        1. Availability  
The game is offline and can be run on all modern computers
        2. Mean Time Between Failures (MTBF)
n/a
        3. Mean Time To Repair (MTTR)  
n/a
        4. Accuracy  
n/a
        5. (Maximum) Bugs or Defect Rate  
n/a
4. **Performance**
        1. Response Time  
Start der Applikation: 2 Sekunden  
User commands should be resolved almost instantly.
        2. Throughput  
n/a
        3. Capacity
The application is meant to be played by 4 players but given the right circumstances it can be played with less.
        4. Degrading modes  
n/a
        5. Resource utilization  
The tunnable Java application is about 440KB
5. **Supportability**  
n/a
6. **Design Constraints**  
The application is made with Java so the constraints that apply to Java also apply to the game.
7. **On-Line User Documentation and Help System Requirements**  
The GUI has a “Help” button that brings up a Window with the rules of the game.
8. **Purchased Components**  
n/a
9. **Interfaces**
        1. User Interfaces  
                Screenshot:  
                <a href="https://github.com/mite134/DontGetAngry/blob/master/other%20pics/screenshot.png">https://github.com/mite134/DontGetAngry/blob/master/other%20pics/screenshot.png</a>

                Mock-Ups:  
                <a href="https://github.com/mite134/DontGetAngry/tree/master/mock%20up%20pics">https://github.com/mite134/DontGetAngry/tree/master/mock%20up%20pics</a>
        2. Hardware Interfaces  
n/a
        3. Software Interfaces  
n/a
        4. Communication Interfaces  
n/a
10. **Licensing Requirements**  
n/a
11. **Legal, Copyright and Other Notices**  
n/a
12. **Applicable Standarts**  
Code Conventions by Oracle

### 4. Supporting Information ###
n/a