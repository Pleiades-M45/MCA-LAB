try:
    with open('input.txt', 'a+') as f:
        user_input = input("Enter some text (enter an empty line to stop): ")
        
        while user_input:
            f.write(user_input + '\n')
            user_input = input("Enter some text (enter an empty line to stop): ")
            
        print("Content appended successfully.\n")

        f.seek(0)
        
        content = f.readlines()
        print('File contents:')

        for line in content:
            print(line.strip()) 

except IOError as e:
    print(f"Error opening file: {e}")