l=input("Enter a sentence : ")
count=0
v=['a','e','i','o','u']
for i in l.lower():
    if i in v:
        count+=1
print("No. of vowels = ",count)
