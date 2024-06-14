def sum(num):
    sum = 0
    for value in num:
        sum += value
    return sum
numList =[3,4,5,10,12,15,36,40]
result = sum(numList)
print("The sum of the list is :" + str(result))