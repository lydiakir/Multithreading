# Multithreading


## Description
A multi-threaaded Java application, which contains 5 classes:

#### Main:
Creates an instance of Manager, and calls the three methods.

#### LKThread:
A thread class that inherits from java Thread.

When the thread is started it sits in a while (!isExiting) loop containing the Thread.sleep(threadSleep); statement, waking
up every 1000 milliseconds to see if the isExiting flag is set to true. When the thread wakes up and its isExiting is set to true it will
drop out of the while loop, set the isStarted to false and then exit the run method.

#### Manager:
This class creates the Thread objects, starts them, and manages them.

#### SychronisedData:
Contains synchronised incrementMyValue() and decrementMyValue() methods.

#### Constant:
This contains all the numbers and strings used in all of the above classes, so they can be changed easily when used across multiple
methods, and is also important for security.
