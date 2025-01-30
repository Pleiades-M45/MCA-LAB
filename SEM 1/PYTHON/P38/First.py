from File import *

n = int(input('Enter a number: '))
x = int(input('First number for modulus: '))
y = int(input('Second number for modulus: '))

r = int(input('Enter radius: '))
l = int(input('Enter length: '))
b = int(input('Enter breadth: '))
h = int(input('Enter height: '))

print(f'Square of {n}: {maths.square(n)}')
print(f'Power of {x,y}: {maths.power(x,y)}')
print(f'Modulus of {x,y}: {maths.modulus(x,y)}')

print(f'Volume of Cuboid: {science.cuboid(l,b,h)}')
print(f'Volume of Sphere: {science.sphere(r)}')
print(f'Volume of Cylinder: {science.cylinder(r,h)}')