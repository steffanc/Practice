import sys

# output number of ways to go up stairs by taking 1, 2 or 3 steps

steps = []
steps.append(1)
steps.append(2)
steps.append(4)

n = 20

if n >= 4:
  pos = 4
  while pos <= n:
    steps[(pos-1)%3] = sum(steps)
    pos+=1

print steps[(n-1)%3]
