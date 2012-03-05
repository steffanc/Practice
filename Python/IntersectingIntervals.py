import sys

intervals = [(1,5),(2,4),(4,4),(4,4)]
if len(intervals) == 0: print "Empty"

a = []
for i in intervals:
  j=0
  while j < len(i):
    a.append((i[j],j))
    j+=1
a.sort()

count=0
maxCount=0
pos=0
for i in a:
  if i[1] == 0:
    count+=1
  else:
    if count > maxCount:
      pos = i[0]
      maxCount = count
    count-=1

print "Position: " + str(pos)
print "Count: " + str(maxCount)
