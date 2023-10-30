# AssignmentSudoku

## Description 
This project solves sudoku puzzles, which are loaded from the input directory. In the **Inputs** directory there are subdirectories for 9x9, 16x16, and 25x25 puzzles. Solutions for those puzzles are produced in the **Outputs** directory in the same manner as input. </br>

The sudoku puzzle can be modeled as a Constraint Satisfaction Problem (CSP). Basically, it is a problem defined as a set of objects that needs to satisfy some constraints. The main idea for solving these problems is to eliminate large portions of the search space by identifying value combinations that violate the constraints. </br>

In this project forward checking and backtracking search algorithms were used. Each cell of a puzzle is represented as a Node class, which includes attributes such as row, col, box, and domain that are essential for modeling Sudoku constraints. These attributes help in identifying the row, column, and box to which a cell belongs, and the domain stores the possible values that can be placed in the cell.</br>

For more details on the project, algorithms, pseudocode, and time complexity, check the [paper](https://github.com/felipecacique/SudokuSolver/blob/main/Sudoku%20Solver%20-%20Felipe%20Vital.pdf).


## Requirements
* [Git](https://git-scm.com/downloads) to download code
* [Java Development Kit JDK](https://www.oracle.com/in/java/technologies/downloads/) to run this code. In order to configure SDKs for this project you can visit this link: https://www.jetbrains.com/help/idea/sdk.html#define-sdk.

## How to run a project
You just need to specify the number N in the Main class. It could be 9,16 and 25 as this solver can successfully solve 9x9, 16x16, and 25x25 puzzles.</br>
Also in this class, you can specify the input and output name of the file. 

## Results
In the below section, you can find out the performance of this sudoku solver that is represented in milliseconds.

### 9x9 Sudoku puzzle
| Name of input file  | Elapsed Time(ms) |
| ------------- | ------------- |
|  9x9sudoku | 37ms  |
|  9x9Unsolvable |  29ms  |
|  easy9x9       | 35ms |
|  easy9x9_1    | 40ms      |
|  medium9x9  | 69ms    |
|  hard9x9 |  44ms  |

### 16x16 Sudoku puzzle
| Name of input file  | Elapsed Time(ms) |
| ------------- | ------------- |
|  16x16sudoku | 384ms  |
|  easy16x16      | 56ms |
|  medium16x16  | 85ms    |
|  hard16x16|  2050ms  |

### 25x25 Sudoku puzzle
| Name of input file  | Elapsed Time(ms) |
| ------------- | ------------- |
|  25x25Empty | 695ms  |
|  25x25sudoku      | 118ms |
| 25x25sudoku_1  | 126ms    |
|  25x25sudoku_3|  116ms  |
| easy25x25| 202ms|



