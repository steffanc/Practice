# given a list of triplets [(string1, string2, int), (string1, string2, int)...]
# write a function that prints the sum and average of ints where string1 and
# string2 of one triplet equal string1 and string2 of another triplet
# for example: ('ab', 'cd', 2) and ('ab','cd', 4) and any other triplets with
# matching string1 and string2 would be summed and averaged

a = [('a','b',1), ('a','b',2), ('c','d',3), ('ab','c',2), ('a','bc',2)]

def compute(l):
    d = dict()
    for t in l:
        key = (t[0],t[1])
        if key not in d:
            d[key] = [0,0]

        d[key][0] += t[2]
        d[key][1] += 1

    for key, val in d.iteritems():
        print key, val[0], val[0]/float(val[1])

    return d

compute(a)

def unit_test():
    # basic
    a = [('a','b',1), ('a','b',2), ('c','d',3)]
    output = compute(a)
    assert output[('a','b')] == [3,2]
    assert output[('c','d')] == [3,1]

    a = [('a','b',1), ('a','b',2), ('c','d',3)]

unit_test()

firstString -> list of triplets per first string
secondString -> list of triplets per second string
what if first strings are different but have matching seond strings?
looks like they're going to be in the same bucket for the second string hash table
