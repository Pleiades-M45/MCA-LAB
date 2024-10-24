a=input("Enter a sentence : ").split()
a.sort(key=len)
print("Length of the longest word = ",len(a[-1]))
if len(a[-1])==len(a[-2]):
    print("BINGO")