try:
    with open('input.txt', 'r') as inf, open('output.txt', 'w') as outf:

        lines = inf.readlines()
        odd = [lines[i] for i in range(len(lines)) if not i % 2]
        outf.writelines(odd)

        print("Odd lines have been copied successfully.")

except IOError as e:
    print(f"Error: {e}")