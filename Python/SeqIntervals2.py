import itertools
import functools

def xOverY(x, y):
    return x[0] < y[0] and x[1] > y[1]

def seqIntervals(seq):
    max_seq = []
    for perm in itertools.permutations(seq):
        cur_seq = []
        for x in perm:
            l = len(cur_seq)-1
            if cur_seq == [] or xOverY(cur_seq[l], x):
                cur_seq.append(x)

        if len(cur_seq) > len(max_seq):
            max_seq = cur_seq
    return max_seq

def seqIntervals2(seq):
    seq.sort()
    max_seq = []
    for x in seq:
        l = len(cur_seq)-1
        if cur_seq == [] or xOverY(cur_seq[l], x):
            cur_seq.append(x)

        if len(cur_seq) > len(max_seq):
            max_seq = cur_seq
    return max_seq
    
intervals = [(1,5),(2,4),(3,4),(4,4),(3,3)]

print seqIntervals(intervals)
