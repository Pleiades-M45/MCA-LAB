import re
try:
    with open('input.txt','r') as f:
        file = f.read()
        numbers = re.findall(r'\b[6789]\d{9}\b',file)
        print(numbers)
except Exception as e:
    print(f'Error: {e}')