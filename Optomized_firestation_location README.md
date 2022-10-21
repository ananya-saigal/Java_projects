An important question in planning cities is fire station location. Each fire station can service houses within a given radius, and every house must be serviced by 
at least one fire station. My program would help city planners determine where best to locate a fire station, given up to 20 house locations.


The project is inspired by a classical Facility Location Problem (FLP). In these problems, there is a set of potential facility sites where a facility can be opened, 
and a set of demand points that must be serviced. The goal is to pick a subset of facilities to open, to minimize the sum of distances from each demand point to its 
nearest facility. My program on simmilar lines will allow the city planner to input possible fire station locations and then calculate a score to indicate how good 
that fire station location is. 

The program assumes that only one fire station needs to be placed, and costs are not a concern. We place all homes and fire station locations onto a grid, and the 
score of a fire station will be the sum of the Euclidean distances of all the un-serviced homes from the fire station. The program will keep a database of house 
locations, which in this project will be a 2D array of  the x- and y-coordinates of each house. The user will be able to enter houses into the database and clear 
the database.



