n=int(input("Enter a number : "))
fact=1
for i in range(2,n+1):
    fact*=i
print("Factorial = ",fact)

n=int(input("Enter a number : "))
a,b=0,1
for i in range(n):
    print(a,end=" ")
    c=a+b
    a,b=b,a
    b,c=c,b

print("\n")

l=[1,2,3,4]
sum=0
for i in l:
    sum+=i
print("Sum = ",sum)