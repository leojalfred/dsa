def quicksort(array):
    if len(array) <= 1:
        return array

    pivot = array[0]
    left = [x for x in array[1::] if x < pivot]
    right = [x for x in array[1::] if x >= pivot]
    return quicksort(left) + [pivot] + quicksort(right)


test = [89, 3, -44, 787, -8888, 0]
print(quicksort(test))
