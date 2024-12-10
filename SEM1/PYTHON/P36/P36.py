import re
pattern = re.compile(r'\(?(\d{3})\)?[ -.]?(\d{3})[ -.]?(\d{4})')

try:
    with open("input.txt", 'r') as inf:
        lines = inf.readlines() 
        
        if lines: 
            # Find the length of the longest line(s)
            max_length = max(len(line) for line in lines)
            
            print(f"Length of the line: {max_length} characters.")
            print("Longest line(s):")
            for line in lines:
                if len(line) == max_length:
                    print(line.strip())

            # Print all phone numbers
            print("\nPhone numbers found in the file:")
            for line in lines:
                for i in pattern.finditer(line):
                    print(i.group(0))  

            # Remove comment lines
            non_comment_lines = [line for line in lines if not line.strip().startswith('#')]

            with open("output.txt", 'w') as outf:
                outf.writelines(non_comment_lines)
            print("\nComment lines have been removed and saved to 'output.txt'.")
            

except IOError as e:
    print(f"Error opening file: {e}")