# Test structure

- ## a test case needs to do the following three things:
  -
  -

# Arrangee-Act-Assert

- Arrange
  - Set up an appropriate enviroment
- Act
  - Invoke the desired behaviour
- Assert
  - Work out what the observed behaviour was, and check whether it's the same as the expected behaviour

<img src="../image/lec3pic1.png">

# Terminology:

- test value:
  - anything required to set up a system or component, "ask it do" something, observe the result, and clean up the system so as to put it back in a stable state
- expected values:
  - what the system is expected to do

# e.g. 2

- Test need not always be implemented as code
- For instance, we might want to test whether a whole travel booking system is "easily usable" (maybe as part of an acceptance test)
  - "Travel agents shall be able to use all the system functions after successful completion of a training course designed by the software provider. After this training, the average number of errors made by experienced users shall not exceed two per hour of system use."
- Input values:
  - everything we need to do to get trial version of the system set up on the customer's premises, and have the system up and available for trail use by a selection of travel agents.
    - In how much detail do we document these "input values"?
      - It depends on the situation.
