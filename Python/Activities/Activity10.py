	
#num_tuple = (10, 20, 33, 46, 55)
num_tuple = input("Enter your tuple list:").split(", ")
print("Given list is ", num_tuple)
 
num_tuple = int(num_tuple)
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)