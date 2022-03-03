Kenny Nguyen
244626
IC211 Lab06
24FEB2022

My design for MovingDot, RedDot, and BlueDot makes use of encapsulation,
information hiding, inheritance, and polymorphism in a couple ways.

For information hiding, the user can only access the methods that they need to
use. All other data such as the variables for storing direction and the random
number generated or private or protected. 

For inheritance, MovingDot is a child of Dot while RedDot and BlueDot are
children of MovingDot. This enables RedDot and BlueDot to utilize the same
constructor as MovingDot and Dot and while having access to MovingDot's step()
method.

This inheritance, for polymorphism, thus allows RedDot and BlueDot objects to
be stored in a MovingDot class while being able to use overridden methods to
fulfill their purpose (i.e. step() and toString()).


The Polymorphic methods that make coding this lab easier are step() and my 
class constructors. In all classes stemming from MovingDot, they all 
override the step(), class constructors, and toString(). However, although
they override the parent's class, they still utilize the parents class through
super.

An example of this is in RedDot.java, step() starts at line 25, but through
calling the step() from the parent, MovingDot, I am able to utilize MovingDot's
code (MovingDot: Line 37-56) which enables the dot to move in directions. 
Thus, to add functionality to RedDot, all I needed to do was to add the 
ability to change directions, which occurs on line 30-46,

