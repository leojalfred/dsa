from __future__ import annotations

from node import Node


class Stack[T]:
    __top: Node[T] = None

    def push(self, item: T) -> None:
        t = Node(item)
        t.next = self.__top
        self.__top = t

    def pop(self) -> T:
        if self.__top is None:
            raise ReferenceError

        data = self.__top.data
        self.__top = self.__top.next

        return data

    def peek(self) -> T:
        if self.__top is None:
            raise ReferenceError

        return self.__top.data

    def is_empty(self) -> bool:
        return self.__top is None


stack = Stack()
stack.push(1)
stack.push(2)
stack.push(3)

print(f'stack.peek(): {stack.peek()}')
print(f'stack.pop()s: {stack.pop()}, {stack.pop()}, {stack.pop()}')
print(f'stack.is_empty(): {stack.is_empty()}')
