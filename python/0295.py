class MedianFinder:

    def __init__(self):
        self.small = [] # maxheap
        self.large = [] # minheap

    def addNum(self, num: int) -> None:
        if not self.small and not self.large:
            heapq.heappush(self.small, -num)
            return

        if num > -self.small[0]:
            heapq.heappush(self.large, num)

            if len(self.large) > len(self.small):
                temp = heapq.heappop(self.large)
                heapq.heappush(self.small, -temp)
        else:
            heapq.heappush(self.small, -num)

            if len(self.small)-1 > len(self.large):
                temp = heapq.heappop(self.small)
                heapq.heappush(self.large, -temp)

    def findMedian(self) -> float:
        if (len(self.small) + len(self.large)) % 2 == 0:
            return (-1 * self.small[0] + self.large[0]) / 2
        else:
            return -1 * self.small[0]

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
