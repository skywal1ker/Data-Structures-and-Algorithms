def merge(S1, S2, S):
    """Merge two sorted Python lists S1 and S2 into properly sized list S."""
    i = j = 0
    while i + j < len(S):
        if j == len(S2) or (i < len(S1) and S1[i] < S2[j]):
            S[i + j] = S1[i]  # copy ith element of S1 as next item of S
            i += 1
        else:
            S[i + j] = S2[j]  # copy jth element of S2 as next item of S
            j += 1




# invoke this
def merge_sort(S):
    """Sort the elements of Python list S using the merge-sort algorithm."""
    n = len(S)
    if n < 2:  # list is already sorted
        return
    mid = n // 2  # divide
    S1 = S[0:mid]  # copy of first half
    S2 = S[mid:n]  # copy of second half
    merge_sort(S1)  # sort copy of first half
    merge_sort(S2)  # sort copy of second half
    merge(S1, S2, S)  # merge sorted halves back into S
    # return S


# invoke this
def inplace_quick_sort(S, a, b):
    """Sort the list from S[a] to S[b] inclusive using the quick-sort algorithm."""
    if a >= b:  # range is trivially sorted
        return
    pivot = S[b]  # last element of range is pivot
    left = a  # will scan rightward
    right = b - 1  # will scan leftward
    while left <= right:
        # scan until reaching value equal or larger than pivot (or right marker)
        while left <= right and S[left] < pivot:
            left += 1
        # scan until reaching value equal or smaller than pivot (or left marker)
        while left <= right and pivot < S[right]:
            right -= 1
        if left <= right:  # scans did not strictly cross
            S[left], S[right] = S[right], S[left]  # swap values
            left, right = left + 1, right - 1  # shrink range

    # put pivot into its final place (currently marked by left index)
    S[left], S[b] = S[b], S[left]
    # make recursive calls
    inplace_quick_sort(S, a, left - 1)
    inplace_quick_sort(S, left + 1, b)
    # return S


def insertionSort(A):
    """Sort list of comparable elements into nondecreasing order."""
    for k in range(1, len(A)):  # from 1 to n-1
        cur = A[k]  # current element to be inserted
        j = k  # find correct index j for current
        while j > 0 and A[j - 1] > cur:  # element A[j-1] must be after current
            A[j] = A[j - 1]
            j -= 1
        A[j] = cur  # cur is now in the right place


import time
import random
import copy

for n in range(1, 11):  # Here i created range from 1 to 10
    K = random.sample(range(1, 1000000), n * 10000)  # Arrays of 10k but after each loop size will be multipled by one unit
    K2 = copy.deepcopy(K)  # Creating copy of arrays
    K3 = copy.deepcopy(K)  # Creating copy of arrays

    start_time = time.time()  # Start time
    merge_sort(K)  # Invoked merge sort
    end_time = time.time()  # End time
    print(f"Elapsed time for th merge_sort of array size {len(K)} = {end_time - start_time}")

    start_time = time.time()  # Start time
    inplace_quick_sort(K2, 0, len(K2) - 1)  # Invoked quick sort
    end_time = time.time()  # End time
    print(f"Elapsed time for th inplace_quick_sort of array size {len(K2)} = {end_time - start_time}")

    start_time = time.time()  # Start time
    insertionSort(K3)  # Invoked insertionSort
    end_time = time.time()  # End time
    print(f"Elapsed time for th insertionSort of array size {len(K3)} = {end_time - start_time}")
    print()
