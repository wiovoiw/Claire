# 假设一段楼梯共 15 个台阶，小明一步最多能上 3 个台阶。编写程序计算小明上这段台阶一共有多少种方法。

def f(n):
     first3 = {1: 1, 2: 2, 3: 4}
     if n in first3:
        return first3[n]
     else:
        return f(n-1) + f(n-2) + f(n-3)

n = int( input('please input number:') )
print(f(n))


# 假设一段楼梯共 15 个台阶，小明一步最多能上 4 个台阶。编写程序计算小明上这段台阶一共有多少种方法。

def ff(n):
     a = 1
     b = 2
     c = 4
     d = 8
     first4 = {1: 1, 2: 2, 3: 4, 4: 8}
     if n in first4:
         return first4[n]
     for i in range(n-4):
         d, c, b, a = a+b+c+d, d, c, b
     return d

n = int(input('please input number:'))
print(ff(n))

