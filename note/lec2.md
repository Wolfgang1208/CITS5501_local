# Hightlights
- Documentation and APIs: how do we work out what the correct behaviour of a piece of software is *so that we can test it?*
- Unit testing: What is unit testing, what is the terminology, and how do we write unit tests?

# Faults, failures and errors
- In normal English, we might not make much distinction between them.
## in software engineering:

- the behaviour of a running system (what we can observe about what the system does)
- the static artifacts for which the system is produced (e.g. files of source code, or data files in formats like HTML or CSS)
- the runtime state of the system (i.e., what's currently stored in memory)

# Failure
- Recall that:  
  - A failure is any deviation of the observed behaviour of a program or system from the specification.
- It describes the system's behaviour
- (Can we say a file of source code contains a "failure"? No. But can we say a failure occurs when some program is run? Yes)

# Failure e.g.

- Ctrl+s -> should save the file, but crashes when the filename contains a space
  - The program would be failing to meet a functional requirement
- If a program should always respond to user input within 0.1 sec, but instead starts "lagging" when more than 5 document are opened
  - This time, the program would be failing to meet a non-functional requirement, that the system meet particular standards for responsiveness
- If an electronic voting booth should accurately record votes cast , but due to a cosmic ray flipping a bit in memory, 4096 addtional votes are counted for one candidate
  - that is also a failure
-  __failures are systems failied to fulfill the specification or its functionality design.__

# Faults

- also called bugs or defects - A fault is something in the statci artifacts of a system that cause a failure
  <img src="../image/lec2pic1.png">
  Should be "<"

# wider definition of faults

- Some sources will use "fault" more broadly to mean the cause of a faliure besides just defects in the code - e.g. perhaps cosmic rays - but we'll mostly be concerned with problems in the code.
- Not every failure can be tracked back to a *single spot* in the code: failures of security, scalability, performances etc. are global properties of the system artifacts.

# Erroneous State

- By "**Error**" or "**Erroneous state**", the textbook authors mean the situation at runtime, where some fault has become reflected in the system's runtime state
  - So you can have a fault in the code (e.g. off-by-one Java loop error in previous pic), but if we execute the program and (at least this time round) that bit of code doesn't happen to get run, we don't get a corresponding erroneous state

# Invariants

- We will mostly be interested in erroneous states that happen because some class or program invariant has been violated
- ## **invariant has been violated->lead to system erroneous status**

# e.g. Class invariant example - a stack
- here: class invariant: topOfStack always points to current top item (or -1 if empty)
<img src="../image/lec2pic2.png">

# Reliability

- The reliability of a system is the degree to which its **observed behaviour** conforms to its **specification**

# What sorts of things can we test?

- test some code which is a small part of a large system
  - for instance: a single procedure, method or function
  - unit test
- test how units, classes, modules or other components of a system work together
  - intergration testing
- test an entire system
  - system testing
- we can test whether the system meets its specifications (system testing proper), and whether it properly executes some scenario in ana appropriate environment - end-to-end testing
  ...

# Testing

- testing requires a different mind-set from construction: when
