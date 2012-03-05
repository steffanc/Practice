import sys

target = float(pow(2,45))

low=float(0)
up=target
while True:
  num = float((low + up)/2)
  if abs(num*num - float(target)) < pow(10,-10): break
  elif num > target/num: up = num
  else: low = num

print num
