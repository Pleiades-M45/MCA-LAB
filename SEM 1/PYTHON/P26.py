n=["white","sos","rear","aa","hair"]
count=0
for i in n:
    if len(i)>1 and i[0]==i[-1]:
        count+=1
print(count)