from graphics import *

# Calculate area and perimeter of rectangle
length = 5
width = 3
print("Rectangle Area: ",rectangle.area(length, width))
print("Rectangle Perimeter: ",rectangle.perimeter(length, width))

# Calculate area and perimeter of circle
radius = 4
print("Circle Area: ",circle.area(radius))
print("Circle Perimeter: ",circle.perimeter(radius))

# Calculate surface area and volume of cuboid
length = 4
width = 3
height = 2
print("Cuboid Surface Area: ",cuboid.surface_area(length, width, height))
print("Cuboid Volume: ",cuboid.volume(length, width, height))

# Calculate surface area and volume of sphere
radius = 5
print("Sphere Surface Area: ",sphere.surface_area(radius))
print("Sphere Volume: ",sphere.volume(radius))
