import sys

sets = [[3,2],[5,2,3],[2,3,4]]

def i1(a):
  for i in a:
    i.sort()
  if len(a) <= 1: return a

  temp1 = a[0]
  temp2 = a[1]
  posA = 1
  pos1 = 0
  pos2 = 0
  out = []
  while True:
    if pos1 == len(temp1) or pos2 == len(temp2):
      posA+=1
      if posA >= len(a): return out
      temp1 = out
      out = []
      temp2 = a[posA]
      pos1=0
      pos2=0
    elif temp1[pos1] == temp2[pos2]:
      out.append(temp1[pos1])
      pos1+=1
      pos2+=1
    elif temp1[pos1] < temp2[pos2]: pos1+=1
    elif temp2[pos2] < temp1[pos1]: pos2+=1

def i2(a):
  if len(a) <= 1: return a
  d1 = dict()
  out = []
  for i in a[0]:
    d1[i] = True
  i=1
  while i < len(a):
    d2 = dict()
    for j in a[i]:
      if j in d1:
        if i == len(a)-1: out.append(j)
        else: d2[j] = True
    d1 = d2
    i+=1

  return out

print i1(sets)
print i2(sets)
