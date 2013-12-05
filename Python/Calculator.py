# edge cases, testing
# handling whitespace
# order of operations

# division and multiplication left to right, addition and subtraction left to right
# ex: 1/2*4, need to do division first
# ex: 1-1+2, need to do subtraction first

# valid equation (only symbols or ints or floats, start and end are both ints or floats)
# division by 0

# questions
# why would you do this linearly vs recursively?
# what would you expect to be faster?

import re
import timeit

def do_math(s):
    a = s.split('+',1)
    if len(a) == 2:
        return do_math(a[0]) + do_math(a[1])

    a = s.split('-',1)
    if len(a) == 2:
        return do_math(a[0]) - do_math(a[1])

    a = s.split('*',1)
    if len(a) == 2:
        return do_math(a[0]) * do_math(a[1])

    a = s.split('/',1)
    if len(a) == 2:
        return do_math(a[0]) / do_math(a[1])

    return float(s)

print "DERP1"
print do_math('1+1-1/2*6')
print do_math('1+1-2+1')
print do_math('1')

def do_math1(s):
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

print "DERP2"
print do_math1('1 +1-1/3')
print do_math('1+1-2+1')
print do_math1('1')


def update_equation(equation, i, res):
    equation[i-1] = ''
    equation[i] = ''
    equation[i+1] = res

def do_math2(s):
    s.replace(' ', '')
    equation = re.split(r'(\D)', s)

    for i,n in enumerate(equation):
        if n == '/':
            res = int(equation[i-1]) / float(equation[i+1])
            update_equation(equation, i, res)

        if n == '*':
            res = float(equation[i-1]) * float(equation[i+1])
            update_equation(equation, i, res)

    equation = filter(lambda x: x != '', equation)

    for i,n in enumerate(equation):
        if n == '-':
            res = int(equation[i-1]) - float(equation[i+1])
            update_equation(equation, i, res)

        if n == '+':
            res = float(equation[i-1]) + float(equation[i+1])
            update_equation(equation, i, res)

    equation = filter(lambda x: x != '', equation)

    return equation[0]

print "DERP3"
print do_math2('2+24*48/32')


print ""
print "TIMINGS"
number=1000
print timeit.timeit("do_math('1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1')", setup='from __main__ import do_math', number=number)
print timeit.timeit("do_math1('1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1')", setup='from __main__ import do_math1', number=number)
print timeit.timeit("do_math2('1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1+1')", setup='from __main__ import do_math2', number=number)
