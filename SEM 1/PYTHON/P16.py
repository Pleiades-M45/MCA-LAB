n=int(input("Enter a number : "))
for i in range(1,n+1):
    if not n%i:
        print(i,end="\t")