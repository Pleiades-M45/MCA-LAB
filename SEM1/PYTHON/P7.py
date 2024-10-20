count={}
a=input("Enter a sentence : ")
b=a.split()
for i in b:
    count[i]=count.get(i,0)+1
print("Word Frequency : ",count)

count_char = {i: a.count(i) for i in sorted(set(a)) if i.isalnum()}
print("Character Frequency : ",count_char)