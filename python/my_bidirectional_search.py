from __future__ import annotations

from collections import deque


class Node[T]:
    def __init__(self, val: T):
        self.val = val
        self.neighbors: list[Node[T]] = []
        self.visited_right = False
        self.visited_left = False
        self.parent_right = None
        self.parent_left = None


def bidirectional_search(s: Node, t: Node):
    def extract_path(intersecting_node: Node):
        path = []

        left_node = intersecting_node
        while left_node:
            path.append(left_node.val)
            left_node = left_node.parent_left

        path.reverse()
        del path[-1]

        right_node = intersecting_node
        while right_node:
            path.append(right_node.val)
            right_node = right_node.parent_right

        return path

    queue: deque[Node] = deque()
    queue.append(s)
    queue.append(t)
    s.visited_left = True
    t.visited_right = True

    while len(queue) > 0:
        current_node = queue.pop()

        if current_node.visited_left and current_node.visited_right:
            return extract_path(current_node)

        for neighbor_node in current_node.neighbors:
            if current_node.visited_left and not neighbor_node.visited_left:
                neighbor_node.parent_left = current_node
                neighbor_node.visited_left = True
                queue.append(neighbor_node)
            if current_node.visited_right and not neighbor_node.visited_right:
                neighbor_node.parent_right = current_node
                neighbor_node.visited_right = True
                queue.append(neighbor_node)

    return False


if __name__ == '__main__':
    n0 = Node(0)
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)
    n6 = Node(6)
    n7 = Node(7)

    n0.neighbors = [n1, n5]
    n1.neighbors = [n0, n2, n6]
    n2.neighbors = [n1]
    n3.neighbors = [n4, n6]
    n4.neighbors = [n3]
    n5.neighbors = [n0, n6]
    n6.neighbors = [n1, n3, n5, n7]
    n7.neighbors = [n6]

    print(bidirectional_search(n0, n4))
