a=input("Enter a string : ")
b=a[:2]+a[-2:]
if len(a)<2:
    b=""
print(b)