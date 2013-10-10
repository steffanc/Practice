def operation(s):
    a = s.split('+',1)
    if len(a) == 2:
        return operation(a[0]) + operation(a[1])

    a = s.split('-',1)
    if len(a) == 2:
        return operation(a[0]) - operation(a[1])

    a = s.split('*',1)
    if len(a) == 2:
        return operation(a[0]) * operation(a[1])

    a = s.split('/',1)
    if len(a) == 2:
        return operation(a[0]) / operation(a[1])

    return float(s)

print operation('1+1-1/2*6')
print operation('1')

def do_math(s):
    return add(s)

def add(s):
    a = s.split('+')
    out = 0
    for i in a:
        out+=subtract(i)
    return out

def subtract(s):
    a = s.split('-')
    out = multiply(a[0])
    for i in a[1:]:
        out-=multiply(i)
    return out

def multiply(s):
    a = s.split('*')
    out = 1
    for i in a:
        out*=divide(i)
    return out

def divide(s):
    a = s.split('/')
    out = float(a[0])
    for i in a[1:]:
        out/=float(i)
    return out

print do_math('1+1-1/3')
print do_math('1')
