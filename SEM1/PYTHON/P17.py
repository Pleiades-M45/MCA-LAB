l=list(map(int,input("Enter a number list : ").split()))
l  = ["Over" if item>100 else item for item in l]
print(l)
