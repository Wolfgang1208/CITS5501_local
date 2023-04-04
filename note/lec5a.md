# Graph-based testing

- Graph-based testing - we identify inputs which will exercise particular paths through a graph representing the software in some way.
- The graph could represent
  - control flow through a program
  - data flow between variables
  - an activity diagram, showing the workflow when a user interacts with the system
  - a state diagram, showing states of a system and transitions between them

# Graph deifinition

- A graph consists of
  - A set N of nodes
  - A set E of edges, each edge being an "arrow" from one node to another

# Graph-based testing

- We will start by considering control flow. Our approach is:
  - Use the source code (or pseudocode) to produce a control flow graph
  - Using the graph produce a set of tests for the given program

# Constructing the graph

- In a control flow graph, nodes represent points in the program control flow can go "from" or "to"
- Loops, thrown exceptions and gotos (in languages that have them) are locations control flow can go from - statements representing these spots are "sources"
- Locations control flow can go to are "sinks"
