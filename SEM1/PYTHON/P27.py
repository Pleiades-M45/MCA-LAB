def count_odd_even(n):
    odd_count = 0
    even_count = 0
    
    for i in n:
        if not i%2 :
            even_count += 1
        else:
            odd_count += 1
            
    return odd_count, even_count

n = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
odd_count, even_count = count_odd_even(n)
print(f'Odd numbers: {odd_count}\nEven numbers: {even_count}')
