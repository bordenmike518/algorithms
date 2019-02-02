import numpy as np

BITS = 15

def scramble(A):
	""" scramble(self, A)
		Arguments:
	----------
	A (list) - A list to be scrambled
		Notes:
	------
	Rearranges a list to a different permutation
	"""
	np.random.shuffle(A)

def bubbleSort(A, reverse=False):
	""" bubbleSort(self, A)
		Arguments:
	----------
	A (list) - A list to be sorted
	reverse (bool) - If False, sorts in ascending order, else, descending order

	Notes:
	------
	Complexity is Theta(n**2)
	Sorts in place
	"""
	for i in range(len(A)):
		for j in reversed(range(i+1, len(A))):
			if ((reverse and A[j] > A[j-1]) or (not reverse and A[j] < A[j-1])):
					A[j], A[j-1] = A[j-1], A[j]

def insertionSort(A, reverse=False):
	""" insertionSort(self, A)
		Arguments:
	----------
	A (list) - A list to be sorted
	reverse (bool) - If False, sorts in ascending order, else, descending order

	Notes:
	------
	Complexity is Theta(n**2)
	Sorts in place
	"""
	for j in range(1,len(A)):
		key = A[j]
		i = j - 1
		while (i >= 0 and ((reverse and A[i] < key) or (not reverse and A[i] > key))):
			A[i+1] = A[i]
			i = i - 1
		A[i+1] = key

def mergeSort(A, p, r, reverse=False):
	""" mergeSort(self, A, p, r)
		Arguments:
	----------
	A (list) - A list to be sorted
	p (int) - Starting index
	r (int) - Ending index
		Notes:
	------
	Complexity is Theta(nlogn)
	Does not sort in place
	"""
	if (p < r):
		q = (p+r)>>1
		mergeSort(A, p, q, reverse)
		mergeSort(A, q+1, r, reverse)
		merge(A, p, q, r, reverse)

def merge(A, p, q, r, reverse):
	""" merge(self, A, p, q, r)
		Arguments:
	----------
	A (list) - A list to be sorted
	p (int) - Starting index
	q (int) - Middle index (p <= q <= r)
	r (int) - Ending index

	TODO:
	-----
	Add reverse argument
	"""
	n1 = q - p + 1
	n2 = r - q
	L = np.zeros(n1 + 1, dtype=int)
	R = np.zeros(n2 + 1, dtype=int)
	for i in range(n1):
		L[i] = A[p+i]
	L[n1] = 1<<BITS
	for j in range(n2):
		R[j] = A[q+j+1]
	R[n2] = 1<<BITS
	if (reverse):
		L[n1] *= -1
		R[n2] *= -1
	i = 0
	j = 0
	for k in range(p, r+1):
		if ((reverse and L[i] >= R[j]) or (not reverse and L[i] <= R[j])):
			A[k] = L[i]
			i += 1
		else:
			A[k] = R[j]
			j += 1

def Parent(i):
	return i>>1

def Left(i):
	return i<<1

def Right(i):
	return (i<<1)+1

def heapSort(A, reverse=False):
	""" heapSort(A)

	Arguments:
	----------
	A (list) - A list to be sorted

	Notes:
	------
	Best complexity is O(nlgn)
	Sorts in place
	reverse (bool) - If False, sorts in ascending order, else, descending order

	TODO:
	-----
	Randomly outputs wrong answer
	"""
	heap_size = len(A)
	buildHeap(A, reverse)
	for i in reversed(range(1, heap_size)):
		A[0], A[i] = A[i], A[0]
		heap_size -= 1
		heapify(A, 0, heap_size, reverse)

def buildHeap(A, reverse):
	""" buildMaxHeap(A)

	Arguments:
	----------
	A (list) - A list to be sorted
	reverse (bool) - If False, sorts in ascending order, else, descending order
	"""
	heap_size = len(A)
	for i in reversed(range(len(A)>>1)):
		heapify(A, i, heap_size, reverse)

def heapify(A, i, heap_size, reverse=False):
	""" maxHeapify(A, i, heap_size)

	Arguments:
	----------
	A (list) - A list to be sorted
	i (int) - Index to be passed
	heap_size (int) - Current heap size count
	reverse (bool) - If False, sorts in ascending order, else, descending order
	"""
	l = Left(i)
	r = Right(i)
	if (l < heap_size and ((reverse and A[l] < A[i]) or (not reverse and A[l] > A[i]))):
		largest = l
	else :
		largest = i
	if (r < heap_size and ((reverse and A[r] < A[largest]) or (not reverse and A[r] > A[largest]))):
		largest = r
	if (largest != i):
		A[i], A[largest] = A[largest], A[i]
		heapify(A, largest, heap_size, reverse)

def quickSort(A, p, r, reverse=False):
	""" quickSort(A, reverse=False)

	Arguments:
	----------
	A (list) - A list to be sorted
	reverse (bool) - If False, sorts in ascending order, else, descending order

	Notes:
	------
	Worst Case is Theta(n**2)
	Average case is Theta(nlgn)
	Sorts in place
	
	TODO:
	-----
	Does not work right.
	"""
	if (p < r):
		q = partition(A, p, r, reverse)
		quickSort(A, p, q-1, reverse)
		quickSort(A, q+1, r, reverse)

def partition(A, p, r, reverse):
	x = A[r]
	i = p
	for j in range(p, r):
		if ((reverse and A[j] >= x) or (not reverse and A[j] <= x)):
			A[i], A[j] = A[j], A[i]
			i += 1
	A[i], A[r] = A[r], A[i]
	return i

def randomizedQuickSort(A, p, r, reverse=False):
	if (p < r):
		q = partition(A, p, r, reverse)
		randomizedQuickSort(A, p, q-1, reverse)
		randomizedQuickSort(A, q+1, r, reverse)

def randomizedPartion(A, p, r, reverse):
	i = np.random.randint(p, r+1)
	A[r], A[i] = A[i], A[r]
	return partition(A, p, r, reverse)

def countingSort(A, reverse=False):
	A_len = len(A)
	C = np.zeros(A_len, dtype=int)
	B = np.zeros(A_len, dtype=int)
	for j in range(A_len):
		C[A[j]] = C[A[j]] + 1
	for i in range(A_len-1):
		C[i+1] += C[i]
	for j in range(A_len):
		B[C[A[j]]-1] = A[j]
		C[A[j]] -= 1
	if (reverse):
		for i in range(A_len>>1):
			B[i], B[-(i+1)] = B[-(i+1)], B[i]		
	return B

#------------------------------------------------------------------------------
def findMaxSubarray(A, low, high):
	if (high == low):
		return (low, high, A[low])
	else:
		mid = (low+high)>>1
		(left_low, left_high, left_total) = findMaxSubarray(A, low, mid)
		(right_low, right_high, right_total) = findMaxSubarray(A, mid+1, high)
		(cross_low, cross_high, cross_total) = findMaxCrossingSubarray(A, low, mid+1, high+1)
		if (left_total >= right_total and left_total >= cross_total):
			return (left_low, left_high, left_total)
		elif (right_total >= left_total and right_total >= cross_total):
			return (right_low, right_high, right_total)
		else:
			return (cross_low, cross_high, cross_total)

def findMaxCrossingSubarray(A, p, q, r):
	max_left = 0
	max_right = 0
	left_total = -(1<<BITS)
	total = 0
	for i in reversed(range(p, q)):
		total += A[i]
		if (total > left_total):
			left_total = total
			max_left = i
	right_total = -(1<<BITS)
	total = 0
	for j in range(q, r):
		total += A[j]
		if (total > right_total):
			right_total = total
			max_right = j
	return (max_left, max_right, left_total+right_total)

def heapMaximum(A):
	return A[0]

def heapExtractMax(A):
	if (heap_size < 1):
		print("ERROR :: Heap underflow.")
	else:
		max_ = A.pop(0)
		heapify(A, 0 , len(A))
		return max_

def heapIncreaseKey(A, i, key):
	if (key < A[i]):
		print("ERROR :: New key is smaller than current key.")
	else:
		while(i > 0 and A[Parent(i)] < A[i]):
			A[i], A[Parent(i)] = A[Parent(i)], A[i]
			i = Parent(i)

def maxHeapInsert(A, key):
	A.append(key)
	heapIncreaseKey(A, len(A), key)

#------------------------------------------------------------------------------
def main():

	reverse = True

	# Original Array
	array = np.arange(12)
	scramble(array)
	print(array)
	
	# Bubble Sort
	bubbleSort(array, reverse)
	print("Bubble Sort ----------")
	print(array)
	scramble(array)
	
	# Insertion Sort
	insertionSort(array, reverse)
	print("Insertion Sort -------")
	print(array)
	scramble(array)
	
	# Merge Sort
	mergeSort(array, 0, len(array)-1, reverse)
	print("Merge Sort -----------")
	print(array)
	scramble(array)

	# Heap Sort
	heapSort(array, reverse)
	print("Heap Sort ------------")
	print(array)
	scramble(array)
	
	# Quick Sort
	quickSort(array, 0, len(array)-1, reverse)
	print("Quick Sort -----------")
	print(array)
	scramble(array)

	# Randomized Quick Sort
	randomizedQuickSort(array, 0, len(array)-1, reverse)
	print("Randomized quick Sort -----------")
	print(array)
	scramble(array)

	# Counting Sort
	array = countingSort(array, reverse)
	print("Counting Sort -------------")
	print(array)
	scramble(array)
	

if __name__ == "__main__":
	main()
