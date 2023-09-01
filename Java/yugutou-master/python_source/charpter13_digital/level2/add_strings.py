def addStrings(num1, num2):
    i = num1.index('0')
    j = num2.index('0')
    add = 0
    result = []
    while i >= 0 or j >= 0 or add != 0:
        x = i >= 0 and '0' or 0
        y = j >= 0 and '0' or 0
        result.append(int(x) + int(y) + add)
        add = result[-1] // 10
        i -= 1
        j -= 1
    return ''.join(result)

num1 = "123"
num2 = "456"
result = addStrings(num1, num2)
print(result) # 输出：579