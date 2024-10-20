count={}
a=input("Enter a word : ")
for i in a:
    count[i]=count.get(i,0)+1
print("Frequency : ",count)


names = ["Alice", "Bob", "Amanda", "Eve", "Charlie", "David", "Aaron"]
count = sum(1 for i in names if i[0].lower()=='a')
print("Count = ",count)