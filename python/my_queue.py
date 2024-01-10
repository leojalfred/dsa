from typing import Optional

from my_node import Node


class Queue[T]:
    __first: Optional[Node[T]] = None
    __last: Optional[Node[T]] = None

    def add(self, item: T) -> None:
        n = Node(item)
        if self.__last is not None:
            self.__last.next = n

        self.__last = n

        if self.__first is None:
            self.__first = self.__last

    def remove(self) -> T:
        if self.__first is None:
            raise ReferenceError

        item = self.__first.data
        self.__first = self.__first.next

        if self.__first is None:
            self.__last = None

        return item

    def peek(self) -> T:
        return self.__first.data

    def is_empty(self):
        return self.__first is None

if __name__ == '__main__':
    queue = Queue()
    queue.add(1)
    queue.add(2)
    queue.add(3)

    print(f'queue.peek(): {queue.peek()}')
    print(f'queue.remove()s: {queue.remove()}, {queue.remove()}, {queue.remove()}')
    print(f'queue.is_empty(): {queue.is_empty()}')
