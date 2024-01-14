class MinHeap[T]:
    def __init__(self) -> None:
        self.heap = [0]
        self.size = 0
        self.TOP = 1

    @staticmethod
    def parent(i: int) -> int:
        return i // 2

    @staticmethod
    def left(i: int) -> int:
        return i * 2

    @staticmethod
    def right(i: int) -> int:
        return i * 2 + 1

    def bubble_up(self, i: int) -> None:
        while self.parent(i) > 0 and self.heap[i] < self.heap[self.parent(i)]:
            self.heap[i], self.heap[self.parent(i)] = self.heap[self.parent(i)], self.heap[i]
            i = self.parent(i)

    def insert(self, element: T) -> None:
        self.heap.append(element)
        self.size += 1
        self.bubble_up(self.size)

    def bubble_down(self, i: int) -> None:
        while self.left(i) <= self.size:
            if self.right(i) > self.size:
                min_child = self.left(i)
            else:
                if self.heap[self.left(i)] < self.heap[self.right(i)]:
                    min_child = self.left(i)
                else:
                    min_child = self.right(i)

            if self.heap[i] > self.heap[min_child]:
                self.heap[i], self.heap[min_child] = self.heap[min_child], self.heap[i]

            i = min_child

    def extract_min(self) -> T:
        if len(self.heap) == 1:
            raise IndexError

        minimum = self.heap[self.TOP]

        self.heap[self.TOP] = self.heap[self.size]
        *self.heap, _ = self.heap
        self.size -= 1
        self.bubble_down(1)

        return minimum


if __name__ == '__main__':
    my_heap = MinHeap()
    my_heap.insert(-213)
    my_heap.insert(1)
    my_heap.insert(-28467)
    my_heap.insert(123)
    my_heap.insert(9)
    my_heap.insert(0)
    my_heap.insert(8737)

    for _ in range(my_heap.size):
        print(my_heap.extract_min())
