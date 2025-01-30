from graphics.rectangle import area as rect_area, perimeter as rect_perimeter
from graphics.circle import area as circ_area, perimeter as circ_perimeter

from graphics.graphics_3D.cuboid import surface_area as cuboid_surface_area, volume as cuboid_volume
from graphics.graphics_3D.sphere import surface_area as sphere_surface_area, volume as sphere_volume


# Calculate area and perimeter of rectangle
length = 5
width = 3
print("Rectangle Area: ",rect_area(length, width))
print("Rectangle Perimeter: ",rect_perimeter(length, width))

# Calculate area and perimeter of circle
radius = 4
print("Circle Area: ",circ_area(radius))
print("Circle Perimeter: ",circ_perimeter(radius))

# Calculate surface area and volume of cuboid
length = 4
width = 3
height = 2
print("Cuboid Surface Area: ",cuboid_surface_area(length, width, height))
print("Cuboid Volume: ",cuboid_volume(length, width, height))

# Calculate surface area and volume of sphere
radius = 5
print("Sphere Surface Area: ",sphere_surface_area(radius))
print("Sphere Volume: ",sphere_volume(radius))
