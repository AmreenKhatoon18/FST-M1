num1 = list[1,2,3,4,5]
num2 = list[6,7,8,9,0]
	
#print("First List ", num1)
#print("Second List ", num2)
num3 =[]
for num in num1:
    if(num%2 != 0):
        num3.append(num)
for num in num2:
    if(num%2 == 0):
        num3.append(num)
    print("Result of the list is:")
    print(num3)