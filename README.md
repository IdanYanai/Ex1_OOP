# Summary of the repository
In this task we were required to use observers to watch over an UndoableStringBuilder object. So that every change to the string will notify the observers.

# GroupAdmin class
Class that implements Sender to notify the observers when a change is made to the String. 
This class has 2 variables: an ArrayList of Members observers, which is the list of observers to watch the subject. And the UndoableStringBuilder new_usb, which is the subject of the observers. Explanations to the methods are in the code.

# ConcreteMember class
Class that implements Member interface. It observes the new_usb variable of GroupAdmin. 
This class holds 1 variable UndoableStringBuilder new_usb, which is a pointer to the GroupAdmin new_usb. Explanations to the methods are in the code.

# Important Files
Tests are in src/test/java/ in Test.java file.
GroupAdmin.java and ConcreteMember.java are in src/main/java/observer/
