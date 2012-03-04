import sys

# Given a string consisting of a,b and c's, we can perform the following
# operation: Take any two adjacent distinct characters and replace it with the
# third character. For example, if 'a' and 'c' are adjacent, they can replaced
# with 'b'. What is the smallest string which can result by applying this
# operation repeatedly?

def reduceString(inStr):
  cA=0
  cB=0
  cC=0
  for i in inStr:
    if i == 'a': cA+=1
    if i == 'b': cB+=1
    if i == 'c': cC+=1
  if cA == len(inStr) or cB == len(inStr) or cC == len(inStr):
    return len(inStr)
  if cA%2==0 and cB%2==0 and cC%2 ==0:
    return 2
  if cA%2==1 and cB%2==1 and cC%2 ==1:
    return 2
  else:
    return 1

print reduceString("cab")
print reduceString("bcab")
print reduceString("ccccc")
