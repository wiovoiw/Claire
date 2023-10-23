import string
def kaisa(s, k):
    lower = string.ascii_lowercase
    upper = string.ascii_uppercase
    num = string.digits
    # punct = string.punctuation
    # before = string.ascii_letters + string.digits + string.punctuation
    before = string.ascii_letters + string.digits
    # after = lower[k:] + lower[:k] + upper[k:] + upper[:k] + num[k:] + num[:k] + punct[k:] + punct[:k]
    after = upper[::-1] + lower[::-1] + num[k:] + num[:k]
    table = ' '.maketrans(before, after)
    return s.translate(table)


s = input("请输入明文：")
k = int(input("请输入位移："))
aa = kaisa(s, k)
bb = kaisa(aa, -k)
result_1 = print("加密后：" + aa)
result_2 = print("解密后：" + bb)




