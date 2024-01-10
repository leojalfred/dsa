from __future__ import annotations


class Node[T]:
    next: Node[T] = None

    def __init__(self, data: T):
        self.data = data
