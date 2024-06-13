num = list(input("Enter a list of numbers:").split(", "))
print("Given List is ", num)
firstElement = num[0]
lastElement = num[-1]
if (firstElement == lastElement):
    print(True)
else:
    print(False)