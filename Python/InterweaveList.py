import sys

class Node:
  def __init__(self,v):
    self.v = v
    self.n = None

def addNode(head,tail):
  if head == None:
    head = tail
    head.n = None
  else:
    node = head
    while node.n != None:
      node = node.n
    node.n = tail
    tail.n = None
  return head

def printList(head):
  n = head
  while n != None:
    print n.v,
    n = n.n
  print

head = Node(1)
addNode(head,Node(2))
addNode(head,Node(3))
addNode(head,Node(4))
addNode(head,Node(5))
printList(head)

def reverseList(head):
  if head == None:
    return head
  prev = head
  cur = head.n
  while cur != None:
    temp = cur.n
    cur.n = prev
    prev = cur
    cur = temp
  head.n = None
  return prev

def findMiddle(head):
  if head == None or head.n == None:
    return (head,head)
  n1 = head
  n2 = head
  while True:
    temp = n2
    n2 = n2.n
    if n2 == None:
      return (head,n1)
    
    n1 = n1.n 

    temp = n2
    n2 = n2.n
    if n2 == None:
      return (head,n1)

def mergeLists(h1,h2):
  out = h1
  while h2!=None:
    temp = h1.n
    temp1 = h2.n
    h1.n = h2
    h2.n = temp
    if temp == None: h1 = h1.n
    else: h1 = temp
    h2 = temp1
  return out

def interweaveList(head):
  if head == None or head.n == None or head.n.n == None:
    return head
  # find middle
  n1,n2 = findMiddle(head)
  n2 = reverseList(n2)
  result =  mergeLists(n1,n2)
  printList(result)

interweaveList(head)
