class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = Counter(tasks)
        maxheap = [-f for f in freq.values()]
        heapq.heapify(maxheap)
        
        cooldown = deque()

        time = 0
        while maxheap or cooldown:
            if cooldown and cooldown[0][0] == time:
                heapq.heappush(maxheap, cooldown.popleft()[1])
            
            if maxheap:
                count = 1 + heapq.heappop(maxheap)
                if count: cooldown.append((time + n + 1, count))
                
                time += 1
            else:
                time = cooldown[0][0]

        return time
