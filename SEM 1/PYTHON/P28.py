def new(n):
    if n.startswith('Is'):
        return n
    else:
        return 'Is'+n

n=input("Enter a string : ")
print(new(n))