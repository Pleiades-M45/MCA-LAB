try:
    with open('input.txt', 'r') as f:
        lines = f.readlines()
        print(lines)

except IOError as e:
    print(f"Error opening file: {e}")