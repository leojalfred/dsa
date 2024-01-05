def binary_search(a, low, high, x):
    if high >= low:
        mid = (high + low) // 2

        if x == a[mid]:
            return mid
        elif x < a[mid]:
            return binary_search(a, low, mid - 1, x)
        else:
            return binary_search(a, mid + 1, high, x)
    else:
        return -1


a = [1, 2, 3, 7, 9, 9, 9, 9, 9]
print(binary_search(a, 0, len(a) - 1, 7))
