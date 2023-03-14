# Test Automation

# Test structure

- ## a test case needs to do the following three things:
  - Prepare the system (and/or an appropriate environment) so that it's in a suitable state for us to invoke some behaviour
  - Invoke the desired behaviour
  - Work out whether the system did what we expected it to

# Arrangee-Act-Assert

- if you test is going to be implemented as code, it's often helpful do each of the three things we mentioned in exactly the order given. if you do so, then you're following the **Arrange-Act-Assert** pattern for writing tests.
- **Arrange**
  - Set up an appropriate environment
- **Act**
  - Invoke the desired behaviour
- **Assert**
  - Work out what the observed behaviour was, and check whether it's the same as the expected behaviour

<img src="../image/lec3pic1.png">

# More complex "assertions"

- In the code examples we've seen, it's very simple to check whether the observed behaviour matches the expected behaviour
- All we expected the method under test to do was return a vlue and it's very simple to check whether that value is what we expected.
- But what if the specification for the **evaluate()** method said that the result shouldn't be returned, but rather written to a file called "**myresult.txt**"
- ## How can we tell if the test passed or failed?
  - We'd need to run extra methods to open that file, read its contents, and check that the contents was what we expected. All this would be part of the "assertion" stage

# Terminology:

- test value:
  - anything required to set up a system or component, "ask it do" something, observe the result, and clean up the system so as to put it back in a stable state
- expected values:
  - what the system is expected to do
- "Value" is being used in a very broad sense. Suppose we are designing system tests for a phone - then the "test values" might include, in some cases, physical actions to be done by a tester to put the phone in a particular state

  - e.g. powered on and with the "Contacts" list displayed

- prefix values
  - Which largely correspond to things we do in the "Arrange" part of a test to set up test fixtures
- verification values
  - things we need to do in order to observe or measure the behaviour of a system or component - running a database query, perhaps
- exit values
  - things we need to do in order to reset ofr "tear down" our fixtures, and put the system back into a stable state again
- For the most part, we will not need to make use of this terminology

# Cleaning up/"tear down" methods

- "exit values" don't really correspond to anything in the "A-A-A" pattern
- If we need to do any sort of "cleanup" after a test, we would just do it after the **Assert** stage
- If we have multiple tests that all require the same cleanup steps (deleting files or resetting a database to a known state), it would be poor programming style to copy and paste the same cleanup code again and again (Why?)
- Instead, most test frameworks give us a way of specifying bits of code - often called "teardown methods" - that should be run after each test in some test suite

# e.g. 2

- Test need not always be implemented as code
- For instance, we might want to test whether a whole travel booking system is "easily usable" (maybe as part of an acceptance test)
  - "Travel agents shall be able to use all the system functions after successful completion of a training course designed by the software provider. After this training, the average number of errors made by experienced users shall not exceed two per hour of system use."
- When we document our test, our "input values" might be everything we need to do to get trial versions of the system set up on the customer's premises, and have the system up and available for trial use by a selection of travel agents.
- Input values:
  - everything we need to do to get trial version of the system set up on the customer's premises, and have the system up and available for trail use by a selection of travel agents.
    - In how much detail do we document these "input values"
      - It depends on the situation
      - If a lot is at stake, we might document all the actions/inputs, and what preparation is needed, and what things the customer needs to be provide, in great detail.
      - For a small system, if less is at stake, less detail as needed.
- We give sufficient detail to reduce the risk of things going wrong to an acceptable level - more on this in the lecture on risk
- What are the "expected values" in this scenario?
  - Its the number of errors per user not exceeding two per hour of system use.

# Q
<img src="../image/lec3pic2.png">

# How tests relate
- Unit tests are at the bottom of the hierarchy, and directly test small parts of the system created during system implementation
- 