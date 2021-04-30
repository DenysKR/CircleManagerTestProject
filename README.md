# CircleManagerTestProject
CircleManager test application


CircleManager provides API for managing circles of members. The project can be built using InlliJIdea.
The following manipulation with circles are possible:

1. Create a Circle.
2. Delete a Circle.
3. Query Circles by Member count - returns the number of circles with members of size n passed into the function. 
4. Add Member - adds a Member to a circle of the id passed in to the signature.
In the case that the circle does not exist it should be created.
5. Remove Member - removes a Member from the circle of the id passed in to the signature.
If the circle has 0 members after removal the circle should be deleted.
6. Print a list of Circles with their Members.
7. A utility function that takes a list of Circle objects and returns a count of how many Circles are duplicated in the list.
8. Given a list of Circles remove all duplicates and return a list with with unique circles.
