word_count={}
a=input("Enter a sentence : ")
for i in a.lower().split():
    word_count[i]=word_count.get(i,0)+1
print("Word Frequency : ",word_count)

char_count = {i: a.count(i) for i in sorted(set(a.lower())) if i.isalnum()}
print("Character Frequency : ",char_count)