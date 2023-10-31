import sympy  # 引入解方程的专业模块sympy

# 申明未知数"x"和"y"
x, y = sympy.symbols("x y")

# 写入需要解的方程组
a = sympy.solve([(y - 20) - (x - 20)*2, 1.5*x - y], [x, y])
print(a)
