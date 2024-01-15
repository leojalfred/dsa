from __future__ import annotations

from typing import Optional


class AdjacentNode:
    next: AdjacentNode = None

    def __init__(self, vertex: int) -> None:
        self.vertex = vertex


class BidirectionalSearch:
    def __init__(self, vertices: int) -> None:
        self.vertices = vertices
        self.graph: list[Optional[AdjacentNode]] = [None] * self.vertices

        self.source_queue: list[int] = []
        self.source_visited = [False] * self.vertices
        self.source_parent: list[Optional[int]] = [None] * self.vertices

        self.destination_queue: list[int] = []
        self.destination_visited = [False] * self.vertices
        self.destination_parent: list[Optional[int]] = [None] * self.vertices

    def add_edge(self, source: int, destination: int) -> None:
        node = AdjacentNode(destination)
        node.next = self.graph[source]
        self.graph[source] = node

        node = AdjacentNode(source)
        node.next = self.graph[destination]
        self.graph[destination] = node

    def bfs(self, direction='forward'):
        if direction == 'forward':
            current = self.source_queue.pop(0)
            connected_node = self.graph[current]

            while connected_node:
                vertex = connected_node.vertex

                if not self.source_visited[vertex]:
                    self.source_queue.append(vertex)
                    self.source_visited[vertex] = True
                    self.source_parent[vertex] = current

                connected_node = connected_node.next
        else:
            current = self.destination_queue.pop(0)
            connected_node = self.graph[current]

            while connected_node:
                vertex = connected_node.vertex

                if not self.destination_visited[vertex]:
                    self.destination_queue.append(vertex)
                    self.destination_visited[vertex] = True
                    self.destination_parent[vertex] = current

                connected_node = connected_node.next

    def is_intersecting(self) -> int:
        for i in range(self.vertices):
            if self.source_visited[i] and self.destination_visited[i]:
                return i

        return -1

    def print_path(self, intersecting_node: int, source: int, destination: int) -> None:
        path = [intersecting_node]
        i = intersecting_node
        while i != source:
            path.append(self.source_parent[i])
            i = self.source_parent[i]

        path.reverse()
        i = intersecting_node
        while i != destination:
            path.append(self.destination_parent[i])
            i = self.destination_parent[i]

        path_string = ' '.join(list(map(str, path)))
        print(f'Path: {path_string}')

    def bidirectional_search(self, source: int, destination: int) -> None:
        self.source_queue.append(source)
        self.source_visited[source] = True
        self.source_parent[source] = -1

        self.destination_queue.append(destination)
        self.destination_visited[destination] = True
        self.destination_parent[destination] = -1

        while self.source_queue and self.destination_queue:
            self.bfs(direction='forward')
            self.bfs(direction='backward')

            intersecting_node = self.is_intersecting()
            if intersecting_node != -1:
                print(f'Path exists between {source} and {destination}')
                print(f'Intersects at: {intersecting_node}')
                self.print_path(intersecting_node, source, destination)

                return

        print(f'Path does not exist between {source} and {destination}')


if __name__ == '__main__':
    graph = BidirectionalSearch(15)
    graph.add_edge(0, 4)
    graph.add_edge(1, 4)
    graph.add_edge(2, 5)
    graph.add_edge(3, 5)
    graph.add_edge(4, 6)
    graph.add_edge(5, 6)
    graph.add_edge(6, 7)
    graph.add_edge(7, 8)
    graph.add_edge(8, 9)
    graph.add_edge(8, 10)
    graph.add_edge(9, 11)
    graph.add_edge(9, 12)
    graph.add_edge(10, 13)
    graph.add_edge(10, 14)

    graph.bidirectional_search(0, 14)
