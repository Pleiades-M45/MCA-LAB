n=int(input("Enter a number : "))
print("Even" if not n%2 else "Odd")

a=input("Enter a list of items : ").split()
item=input("Enter an item to be searched : ")
print("Available" if item.lower() in a else "Not Available")
