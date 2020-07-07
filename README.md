# Data-Structures

## Basic Structures 

* StringArrayList.java: a basic List of String objects, backed by an array
* ArrayStack.java: a stack backed by an array
* LinkedStack.java: a stack backed by a linked chain of objects (Nodes)
* ArrayQueue.java: a queue backed by an array 
* LinkedQueue.java: a queue backed by a linked chain of objects (Nodes)

## Sorting Algorithms 

The following implement the IntSorter.java interface: 
* InsertionSorter.java
* SelectionSorter.java
* MergeSorter.java

## Hashing

A hashCode method was implemented for the following:
* ProductRecord.java
* Student.java

StudentHashSet.java: class is used for storing Student objects
* This Hash Set uses a linear probing collision resolution strategy.
* StudentHashSetTester.java was used to test the implementation

## Set using Binary Tree

StudentTreeSet.java was built with a binary tree as its backing structure, and a comparator that allows the objects to be kept in their proper order (proper order being, alphabetically by last name, then first name, then ID number).

## Max Heap 

MaxHeap.java is a complete MaxHeap and implements a heapsort algorithm.

## Graph Maze

The Graph.java implementation allows you to load the edges of your graph as a single String; for instance, to represent this undirected, unweighted graph: You can represent this graph with this String: A,B;A,D;B,C;B,F;C,F;D,E;E,H;F,G;G,H
*  the getShortestPath method - this method should find the shortest path between the two specified nodes; if no path exists, it returns null.




