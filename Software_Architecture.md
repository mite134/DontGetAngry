Don’t Get Angry Software Architecture Document

Don’t get Angry
Software Architecture Document
Version 1.0
Revision History
Date
Version
Description
Author
03/09/2017
1.0
Dokument erstellt
Dimitar Dimitrov
Table of Contents
1. Introduction
1. Purpose
2. Definitions, Acronyms and Abbreviations
3. References
2. Architectural Represenation
3. Architectural Goals and Constraints
4. Use-Case View
5. Logical View
1. Architecturally Significant Design Packages
6. Process View
7. Deployment View
8. Implementation View
9. Data View
10. Size and Performance
11. Quality
1. Content
2. Pattern
3. Metrics
1. Introduction
1. Purpose
This document should give an overview of the “Don’t get Angry” game and its architectural structure.
2. Definitions, Acronyms, and Abbreviations
n/a = not applicable
tbd = to be determined
3. References
File
Link
SRS
https://github.com/mite134/DontGetAngry/blob/master/Software_Requirements_Specification.md
2. Architectural Representation
https://github.com/mite134/DontGetAngry/blob/master/other%20pics/500px-MVC-Process.svg.png
3. Achitectural Goals and Constraints
The application is made using the classic Model-View-Controller pattern, where the user sees the GUI and his interactions are transferred using the controller and modifies the model -in this case board pawns etc..
4. Use-Case View
Overall-Use-Case-Diagram:
https://github.com/mite134/DontGetAngry/blob/master/Use%20Cases/Overall_UCD.png
5. Logical View
1. Architecturally Significant Design Packages
1. model
2. view
3. controller
https://github.com/mite134/DontGetAngry/blob/master/other%20pics/UML%20MVC.png
6. Process View
n/a
7. Deployment View
8. Implementation View
n/a
9. Data View
10. Size and Performance
The Application is very small and uses no database which means that it should run very fast on all kinds of modern PCs.
11. Quality
1. Content
The game “Don’t get angry” by itself is pretty basic and most of the fun comes from interacting with the other players which is the reason it is one of the most popular board games in the world. 
2. Pattern
3. Metrics