def merge_sort(array: list) -> None:
    if len(array) <= 1:
        return

    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]

    merge_sort(left)
    merge_sort(right)

    i = j = k = 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            array[k] = left[i]
            i += 1
        else:
            array[k] = right[j]
            j += 1

        k += 1

    while i < len(left):
        array[k] = left[i]
        i += 1

    while j < len(right):
        array[k] = right[j]
        j += 1


if __name__ == '__main__':
    test = [89, 3, -44, 787, -8888, 0]
    merge_sort(test)
    print(test)
