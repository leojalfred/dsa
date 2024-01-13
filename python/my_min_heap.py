class MinHeap:
    def __init__(self):
        self.heap = [0]
        self.size = 0

    def bubble_up(self, i):
        while i // 2 > 0 and self.heap[i] < self.heap[i // 2]:
            self.heap[i], self.heap[i // 2] = self.heap[i // 2], self.heap[i]
            i = i // 2

    def insert(self, k):
        self.heap.append(k)
        self.size += 1
        self.bubble_up(self.size)

    def bubble_down(self, i):
        while (i * 2) <= self.size:
            mc = self.min_child(i)

            if self.heap[i] > self.heap[mc]:
                self.heap[i], self.heap[mc] = self.heap[mc], self.heap[i]

            i = mc

    def min_child(self, i):
        if (i * 2) + 1 > self.size:
            return i * 2
        else:
            if self.heap[i * 2] < self.heap[(i * 2) + 1]:
                return i * 2
            else:
                return (i * 2) + 1

    def extract_min(self):
        if len(self.heap) == 1:
            raise IndexError

        root = self.heap[1]

        self.heap[1] = self.heap[self.size]
        *self.heap, _ = self.heap
        self.size -= 1
        self.bubble_down(1)

        return root


if __name__ == '__main__':
    my_heap = MinHeap()
    my_heap.insert(5)
    my_heap.insert(6)
    my_heap.insert(7)
    my_heap.insert(9)
    my_heap.insert(13)
    my_heap.insert(11)
    my_heap.insert(10)

    print(my_heap.extract_min())  # removing min node i.e 5
