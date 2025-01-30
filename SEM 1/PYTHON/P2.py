a=input("Enter String 1 : ")
b=input("Enter String 2 : ")
c=b[0]+a[1:]+" "+a[0]+b[1:]
print(c)

a=input("Enter comma seperated colors : ").split(",")
print(a[::2])