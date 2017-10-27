-------------
# Dont get Angry Test Plan #
-------------
**Dont get Angry**  
**Test Plan**

**Version 1.1**

## Revision History ##

|Date|Version|Description|Author|
|---|---|---|---|
|26/04/2017|1.0|Dokument erstellt|Dimitar|
|18/05/2017|1.1|Dokument mit allen vorhandenen Informationen gefüllt|Dimitar|
|14/06/2017|1.5|Installationstest hinzugefügt|Dimitar|
|22/06/2017|1.6|Update für final|Dimitar|


## Table of Contents ##
1. Introduction
	1. Purpose
	2. Scope
	3. Intended Audience
	4. Document Teminology and Acronyms
	5. References
	6. Document Structure
2. Evaluation Mission and test Motivation
	1. Background
	2. Evaluation Mission
	3. Test Motivators
3. Target test Items
4. Outline of Planned Tests
	1. Outline of Test Inclusions
	2. Outline of other candidates for potential inclusion
	3. Outline of Test Exclusions
5. Test Approach
	1. Initial Test-Idea Catalogs and other reference sources
	2. Testing Techniques and Types
		1. Function Testing
		2. User Interface Testing
		3. Installation Testing
6. Entry and Exit Criteria
	1. Test Plan
		1. Test Plan Entry Criteria
		2. Test Plan Exit Criteria
		3. Suspension and resumption criteria
	2. Test Cycles
7. Deliverables
	1. Test Evaluation Summaries 
	2. Reporting on Test Coverage
	3. Perceived Quality Reports
	4. Incident Logs and Change Requests
	5. Smoke Test Suite and supporting Test Scripts
	6. Additional work products
8. Testing Workflow
9. Environmental Needs
	1. Base System Hardware
	2. Base Software Elements in the Test Environment
	3. Productivity and Support Tools
	4. Test Environment Configurations
10. Responsibilities, Staffing and Training Needs
	1. People and Roles
	2. Staffing and Training Needs
11. Iteration Milestones
12. Risks, Dependencies, Assumptions and Constraints
13. Management Process and Procedures
	1. Measuring and Assessing the Extent of Testing
	2. Assessing the deliverables of this Test Plan
	3. Problem Reporting, Escalation and Issue Resolution
	4. Managing Test Cycles
	5. Traceability Strategies
	6. Approval and Signoff

## 1. Introduction ##
1. **Purpose**  

Testplan ist erstellt, in dem die folgenden Punkten belegt sind:
-Die Funktionalität des Apps wird überprüft
-Das Spiel soll fehlerfrei bzw so wenig Fehler wie möglich
-Interface des Apps wird berücksichtigt

2. **Scope**  

Umfang des Test:
-Funktions-Tests
-JUnit Tests

3. **Intended Audience**  
Projektentwickler

4. **Document Terminology and Acronyms**  
n/a = not applicable  
tbd = to be determined
5. **References**  

|Objekt|Link|
|---|---|
|SAD|https://github.com/mite134/DontGetAngry/blob/master/Software_Architecture.md|
|SRS|https://github.com/mite134/DontGetAngry/blob/master/Software_Requirements_Specification.md|
|Codacy|https://www.codacy.com/app/mite134/DontGetAngry/dashboard?bid=5642024|
6. **Document Structure**  
n/a

## 2. Evaluation Mission and Test Motivation ##
1. **Background**

Tests überprüft die Korrektheit des Programms. Bei Änderung und Verbesserung des Quellcodes soll keine negativen Auswirkungen haben.
  
2. **Evaluation Mission**  
Ziel:
- Quellcode und Design optimieren
- so viel wie möglich Fehler finden und beheben

3. **Test Motivators**  
Tests "bemerken" existierende Fehler und werden dann reduziert. Durch Testen fallen neue Ideen für die Verbesserung des Spiels  ein.

## 3. Target Test Items ##
- Java Application "Dont get Angry"

## 4. Outline of Planned Tests ##
1. **Outline of Test Inclusions**  
	- Unit-tests
	- Funktions-tests
	- Installations-tests

2. **Outline of other candidates for potential inclusion**  
n/a
3. **Outline of Test Exclusions**  
	- Datenbank

## 5. Test Approach ##
1. **Initial Test-Idea Catalogs and other reference sources**  
n/a
2. **Testing Techniques and Types**  
	1. Function Testing

	| | |
	|----|----|
	|Technique Objective|Testen des Ablaufs des Spiels|
	|Technique|Korrekte Daten sollen die entsprechenden Ergebnisse liefern und die falschen Daten - entsprechende Fehlermeldungen|
	|Oracles|Tests sind erfolgreich, wenn jede Interaktion das gewünschte Ergebnis bringt|
	|Required Tools|JUnit|
	|Success Criteria|Die Tests laufen erfolgreich durch|
	|Special Considerations|n/a|  

	2. User Interface Testing  

	| | |
	|----|----|
	|Technique Objective|Testen von Ansichten auf korrektes Verhalten|
	|Technique|Für jede Ansicht einen Test erstellen um die korrekte Darstellung und Navigation sicherzustellen|
	|Oracles|Tests sind erfolgreich, wenn jede Interaktion mit der GUI das gewünschte Ergebnis bringt|
	|Required Tools|Cucumber|
	|Success Criteria|Alle Tests laufen erfolgreich durch|
	|Special Considerations|n/a|  

	3. Installation Testing  
	
	| | |
	|----|----|
	|Technique Objective|Testen, Das spiel auf eine andere PC laufen kann|
	|Technique|Es wird das Spiel zur Verfügung gestellt|
	|Oracles|Tests sind erfolgreich, wenn das Spiel started und keine Fehler aufweist|
	|Required Tools|PC with Java installed|
	|Success Criteria|Das Spiel wird erfolgreich durchgespielt|
	|Special Considerations|n/a|  


## 6. Entry and Exit Criteria ##
1. **Test Plan**
	1. Test Plan Entry Criteria  
Bei jedem Deploy werden Funktionstests automatisch ausgeführt.
Installations-tests werden manuell durchgeführt.
	2. Test Plan Exit Criteria  
Der Testplan ist beendet, sobald alle Tests erfolgreich durchgeführt wurden.
Ausnahme: Installationstest
	3. Suspension and resumption criteria  
Der Testplan ist nicht abbrechbar.
2. **Test Cycles**  
n/a  

## 7. Deliverables ##
1. **Test Evaluation Summaries**  
Junit tests sind auf GitHub als auch die ausfuehrbare .jar File
2. **Reporting on Test Coverage**  
Screenshot: https://github.com/mite134/DontGetAngry/blob/master/other%20pics/coverage.png
3. **Perceived Quality Reports**  
	- Codacy: https://www.codacy.com/app/mite134/DontGetAngry/dashboard?bid=5642024
4. **Incident Logs and Change Requests**  
n/a
5. **Smoke Test Suite and supporting Test Scripts**  
n/a
6. **Additional work products**  
n/a  

## 8. Testing Workflow ##
Unit Tests starten automatisch.

## 9. Environmental Needs ##
1. **Base System Hardware**  
Java 1.8

2. **Base Software Elements in the Test Environment**  

|Software Element|Version|Typ / andere Notizen|
|----|----|----|
|Windows|10|Entwicklungsumgebung und Programmausführung|
|Google Chrome|58.X.X|Einsicht der Testergebnisse|
|JDK|8 Update 111|Programmiersprache|

3. **Productivity and Support Tools**  

|Kategorie|Name|Version|
|----|----|----|
|Metrics|Codacy|n/a|
|Test|JUnit|4.12|
|IDE|Eclipse|4.6.3|
|Projektmanagement|Redmine|3.4.2|

4. **Test Environment Configurations**  
n/a

## 10. Responsibilities, Staffing and Training Needs ##
1. **People and Roles**  
Blog-Eintrag: <a href="dontgetangrysite.wordpress.com/">Don't get angry</a>
2. **Staffing and Training Needs**  
n/a

## 11. Iteration Milestones ##

|Geplanter Meilenstein|Startdatum|Enddatum|
|----|----|----|
|~30% Codecoverage|Projectstart|31.08.2017|
|50%+ Codecoverage|01.09.2017|21.10.2017|
## 12. Risks, Dependencies, Assumptions and Constraints ##
Eine Übersicht über unser gesamtes Risikomanagement findet sich <a href="https://github.com/mite134/DontGetAngry/blob/master/Risk_Management.md">dieser Datei</a>


## 13. Management Process and Procedures ##
1. **Measuring and Assessing the Extent of Testing**  
n/a
2. **Assessing the deliverables of this Test Plan**  
n/a
3. **Problem Reporting, Escalation and Issue Resolution**  
n/a
4. **Managing Test Cycles**  
n/a
5. **Traceability Strategies**  
n/a
6. **Approval and Signoff**  
n/a

## 14. Metrics ##
Wir verwenden Codacy.  
Das Dashboard mit allen Informationen über unseren Quellcode und aktuell bestehende Fehler findet sich hier: <a href="https://www.codacy.com/app/mite134/DontGetAngry/dashboard?bid=5642024">Codacy Dashboard</a>  
Dies ist immer unser aktuellster Commit, d.h. jegliche Fehler die dort angezeigt werden sind entweder nach wie vor vorhanden oder aktuell in Bearbeitung. 