a=input("Enter Colors 1 : ").split()
b=input("Enter Colors 2 : ").split()
print(set(a)-set(b))

a=input("Enter a List : ").split()
print(set(a))

print("List Empty : ",bool(not len(a)))