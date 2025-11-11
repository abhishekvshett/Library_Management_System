# Library Management System (Java, DSA-Based)

## Overview
A simple console-based Library Management System built using **core Data Structures and Algorithms (DSA)** in Java.  
This project demonstrates how to store, search, and manage data efficiently using collections and manual sorting.

No database or external frameworks are used — all operations are performed using in-memory data structures.

---

## Features
- Add, remove, search, issue, and return books  
- Display all books sorted by title  
- Uses only core Java (no libraries)  
- Command-line user interface  

---

## Data Structures Used
| Feature | Data Structure | Purpose |
|----------|----------------|----------|
| Store all books | `HashMap<Integer, Book>` | Fast lookup by book ID |
| Sorting books | `ArrayList<Book>` + Bubble Sort | Demonstrates sorting manually |
| Searching | Linear Search | Simple and easy to understand |

---

## Time Complexity
| Operation | Complexity |
|------------|-------------|
| Add | O(1) |
| Remove | O(1) |
| Search | O(n) |
| Issue / Return | O(1) |
| Sort (Bubble Sort) | O(n²) |

---

## Sample Output

===== LIBRARY MANAGEMENT SYSTEM =====

Add Book

Remove Book

Search Book

Issue Book

Return Book

Display All Books

Exit
Enter your choice: 1
Enter Book ID: 101
Enter Title: Data Structures
Enter Author: Mark Allen
[OK] Book added successfully.

Enter your choice: 6

ID | Title | Author | Status

101 | Data Structures | Mark Allen | Available


## Learning Highlights

Practical application of HashMap and ArrayList

Implementation of Bubble Sort

Reinforces CRUD operations using DSA

Good beginner-level project for GitHub portfolios
