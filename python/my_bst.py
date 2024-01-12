from __future__ import annotations

from typing import Callable, Any


class Node[T]:
    left: Node[T] = None
    right: Node[T] = None

    def __init__(self, data: T) -> None:
        self.data = data


def pre_order(node: Node, visit: Callable[[Any], None]) -> None:
    if node is not None:
        visit(node.data)
        pre_order(node.left, visit)
        pre_order(node.right, visit)


def in_order(node: Node, visit: Callable[[Any], None]) -> None:
    if node is not None:
        in_order(node.left, visit)
        visit(node.data)
        in_order(node.right, visit)


def post_order(node: Node, visit: Callable[[Any], None]) -> None:
    if node is not None:
        post_order(node.left, visit)
        post_order(node.right, visit)
        visit(node.data)


a = Node(1)
b = Node(2)
c = Node(3)

a.left = b
a.right = c

print('Pre-Order:')
pre_order(a, print)

print('\nIn-Order:')
in_order(a, print)

print('\nPost-Order:')
post_order(a, print)
