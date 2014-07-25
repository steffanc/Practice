# Given a set of [a,b] intervals on the number line, find the longest ordered sequence of (a subset of) the intervals such that each consecutive interval is nested inside the previous one.
# "Nested" means this: If interval X is nested inside Y, then Y.a < X.a and X.b < Y.b.

# intervals = [(3,3),(2,4),(1,5),(3,4),(4,4)]

# |-|
#  |
#|---|
#  ||
#   |

import itertools

# brute force, go over all permutations of a list
# O(N!)
def do_intervals1(seq):
    max_seq = None
    for x in itertools.permutations(seq): #O(N!)
        curr_seq = []
        for y in x:
            l = len(curr_seq)-1
            if curr_seq == [] or (curr_seq[l][0] < y[0] and curr_seq[l][1] > y[1]):
                curr_seq.append(y)
        if max_seq == None or len(curr_seq) > len(max_seq):
            max_seq = curr_seq
    return max_seq

# sorting, sort intervals by left most point
# this means that all intervals from left to right in the list will be
# potentially nested but not from right to left
# O(N + N-1 + N-2 + N-3 + ... + 1)
# O(N^2)
def do_intervals2(seq):
    seq.sort() # sort by left most point, O(N*log(N))
    max_seq = None
    i = 0
    while i < len(seq):
        curr_seq = []
        for x in seq[i:]:
            l = len(curr_seq)-1
            if curr_seq == [] or (curr_seq[l][0] < x[0] and curr_seq[l][1] > x[1]):
                curr_seq.append(x)
        if max_seq == None or len(curr_seq) > len(max_seq):
            max_seq = curr_seq
        i+=1
    return max_seq

# sorting with dynamic programming and memoization
# nodes only have to be visited once after sorting
# sort: O(N*logN)
# compute: O(N)
def do_intervals3(seq):
    seq.sort() # sort by left most point, O(N*log(N))
    dyn_seq = map(lambda x: [x,None], seq) # O(N), [(x,y), None], [[x1,y1], None], ...
    max_seq = None

    def rec_interval(pos):
        if pos == len(dyn_seq)-1:
            return []
        else:
            interval = dyn_seq[pos][0]
            max_sub_seq = None
            for i, x in enumerate(dyn_seq[pos+1:]):
                curr_interval_pos = i+pos+1
                curr_interval = x[0]
                curr_sub_seq = x[1]
                if interval[0] < curr_interval[0] and interval[1] > curr_interval[1]:

                    if curr_sub_seq == None:
                        curr_sub_seq = [curr_interval]
                        curr_sub_seq.extend(rec_interval(curr_interval_pos))
                        dyn_seq[curr_interval_pos][1] = curr_sub_seq

                    if max_sub_seq == None or len(curr_sub_seq) > len(max_sub_seq):
                        max_sub_seq = curr_sub_seq

            if max_sub_seq == None:
                max_sub_seq = []

            return max_sub_seq

    max_sub_seq = None
    for i, x in enumerate(dyn_seq):
        interval = x[0]
        sequence = x[1]
        if sequence == None:
            sequence = [interval]
            sequence.extend(rec_interval(i))
            dyn_seq[i][1] = sequence

        if max_sub_seq == None or len(sequence) > len(max_sub_seq):
            max_sub_seq = sequence

    return max_sub_seq

intervals = [(1,5),(2,4),(3,4),(4,4),(3,3)]
intervals2 = [(1,10),(2,3),(3,9),(4,8),(5,7)]
intervals3 = [(1,10),(2,3),(2,9),(4,8),(5,7)]

#|---|
# |-|
#  ||
#   |
#  |

print do_intervals1(intervals3)
print do_intervals2(intervals3)
print do_intervals3(intervals3)
