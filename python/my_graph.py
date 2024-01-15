from __future__ import annotations

from collections import deque
from typing import Callable, Any


class Node[T]:
    adjacent: list[Node[T]] = []
    visited = False

    def __init__(self, data: T) -> None:
        self.data = data


def dfs(root: Node, visit: Callable[[Any], None]) -> None:
    visit(root.data)
    root.visited = True

    for a in root.adjacent:
        if not a.visited:
            dfs(a, visit)


def bfs(root: Node, visit: Callable[[Any], None]) -> None:
    queue: deque[Node] = deque()
    root.visited = True
    queue.append(root)

    while queue:
        n = queue.popleft()
        visit(n.data)

        for a in n.adjacent:
            if not a.visited:
                a.visited = True
                queue.append(a)


if __name__ == '__main__':
    n0 = Node(0)
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)

    n0.adjacent = [n1, n4, n5]
    n1.adjacent = [n3, n4]
    n2.adjacent = [n1]
    n3.adjacent = [n2, n4]

    print('Depth-First Search:')
    dfs(n0, print)

    nodes = [n0, n1, n2, n3, n4, n5]
    for node in nodes:
        node.visited = False

    print('\nBreadth-First Search:')
    bfs(n0, print)
