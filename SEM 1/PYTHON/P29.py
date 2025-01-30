x=int(input("Enter first number : "))
y=int(input("Enter second number : "))
max_value = (lambda x, y: x if x > y else y)(x, y)
print(max_value)

div_five = lambda x: not x%5
print("Divisible by 5 : ",div_five(x))

n=["white","sos","rear","bag","apple"]
filtered_strings = list(filter(lambda i: len(i) >= 5, n))
print(filtered_strings)

n = [950, 1200, 850, 2000, 300, 1500]
incremented = list(map(lambda i: round(i * 1.10, 2) if i > 1000 else round(i * 1.05, 2), n))
print(incremented)