import numpy as np

# 定义方程的系数矩阵a和常数向量b
a = np.array([[1, 1, 1], [8, 6, 4], [1, 3, 4]])
b = np.array([100, 600, 280])

# 求解方程
solution = np.linalg.solve(a, b)
solution = solution.astype(int)  # 将2D数组从浮点数转换为整数

# 输出结果
print("A类机器人有：", solution[0])
print("B类机器人有：", solution[1])
print("C类机器人有：", solution[2])