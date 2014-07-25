# Given an input number of cents, print all combinations of change that
# would total the number of cents

def cents(target):
    doCents(target, [], 0, 4)

def doCents(target, output, current, level):
    if current == target:
        print output
    else:
        if current+100 <= target and level >= 4:
            output.append("o")
            doCents(target,output,current+100, 4)
            output.pop()
        if current+25 <= target and level >= 3:
            output.append("q")
            doCents(target,output,current+25, 3)
            output.pop()
        if current+10 <= target and level >= 2:
            output.append("d")
            doCents(target,output,current+10, 2)
            output.pop()
        if current+5 <= target and level >= 1:
            output.append("n")
            doCents(target,output,current+5, 1)
            output.pop()
        if current+1 <= target and level >= 0:
            output.append("p")
            doCents(target,output,current+1, 0)
            output.pop()

cents(100)
