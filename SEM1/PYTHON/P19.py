for i in range(1,21):
    if not i%3 and not i%5:
        print("FizzBuzz",end="\t")
    elif not i%3:
        print("Fizz",end="\t")
    elif not i%5:
        print("Buzz",end="\t")
    else:
        print(i,end="\t")