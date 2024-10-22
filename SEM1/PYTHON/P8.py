a=[40,-23,-50,9,-2,28,0]
b=[i for i in a if i>0]
print("List of positive numbers : ",b)

b=[i**2 for i in a]
print("List of squares : ",b)

a=input("Enter a word : ")
v=['a','e','i','o','u']
b=[i for i in a if i.lower() in v]
print("List of vowels : ",b)

a=[40,-23,-50,9,-2,28,0]
b=[i for i in a if i%2]
print(b)

from datetime import date
current_year=date.today().year
future_year=int(input("Enter a future year : "))
leaps=[i for i in range(current_year,future_year+1) if not i % 400 or ( not i % 4 and i % 100)]
print("Leap years : ",leaps)