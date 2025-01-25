n = int(input('Enter limit: '))
a, b, sum = 0, 1, 0

for i in range(n):
    a, b = b, a+b
    if not a%2:
        sum+=a
        
print(sum)