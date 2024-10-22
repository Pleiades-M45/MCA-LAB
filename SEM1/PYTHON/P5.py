d1 = {"id":1, "name":"Orca", "score":90}
item=input("Enter the key to be searched : ")
print(f"Key \"{item}\" present : ",item in d1)

d2 = {"id":2,"course":"MCA","college":"MACE"}
d1.update(d2)
print("Merged Dictionary : ",d1)

print("Sorted values (ascending) : ",sorted(map(str,d1.values())))
print("Sorted values (descending) : ",sorted(map(str,d1.values()),reverse=True))

invert_d1={v:k for k,v in d1.items()}
print("Inverted Dictionary : ",invert_d1)