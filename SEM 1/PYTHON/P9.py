a=input("Enter a string : ")
if(a.lower().endswith("ing")):
    a+="ly"
else:
    a+="ing"
print(a)