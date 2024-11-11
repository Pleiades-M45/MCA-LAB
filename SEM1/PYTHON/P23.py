n=list(map(int,input("Enter integers : ").split()))
for i in n:
    if i == 237:
        break
    elif not i%2:
        print(i,end=" ")
