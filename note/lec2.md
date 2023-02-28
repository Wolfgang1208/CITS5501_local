# Still faults failures errors
## in software engineering: 
- the behaviour of a running system (what we can observe about what the system does)
- the static artifacts fro which the system is produced
- the runtime state of the system

# Failure e.g.
- Ctrl+s -> should save the file, but crashes when the filename contains a space
    - The program would be failing to meet a functional requirement
- If a program should always respond to user input within 0.1 sec, but instead starts "lagging" when more than 5 document are opened
    - This time, the program would be failing to meet a non-functional requirement, that the system meet particular standards for responsiveness

# Faults
- also bugs or defects
    - can be source codes

# wider definition of faults

# Erroneous State

# Invariants
- We will mostly be interested in erroneous states that happen because some class or program invariant has been violated

# What sorts of things can we test?
- test some code which is a small part of a large system
    - for instance: a single procedure, method or function
    - unit test
- test how units, classes, modules or other components of a system work together 
    - intergration testing
- test an entire system
    - system testing
- we can test whether the system meets its specifications (system testing proper), and whether it properly executes some scenario in ana appropriate environment
    - end-to-end testing