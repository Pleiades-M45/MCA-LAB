def fact(n):
    if n == 0 or n == 1: return 1
    return n * fact(n - 1)

def fib(n):
    if not n: return 0
    elif n == 1: return 1
    return fib(n - 1) + fib(n - 2)

def sum_list(i):
    if not i: return 0
    return i[0] + sum_list(i[1:])

def sum_n_whole(n):
    if not n: return 0
    return n + sum_n_whole(n - 1)

def reverse_string(s):
    if not len(s): return s
    return s[-1] + reverse_string(s[:-1])

# Factorial
print("Factorial of 5:", fact(5))  

# Fibonacci
print("Fibonacci of 7:", fib(7))  

# Sum of List
print("Sum of [1, 2, 3, 4, 5]:", sum_list([1, 2, 3, 4, 5])) 

# Sum of First N Whole Numbers
print("Sum of first 5 whole numbers:", sum_n_whole(5)) 

# Reverse String
print("Reverse of 'hello':", reverse_string('hello')) 
