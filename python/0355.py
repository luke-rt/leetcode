class Twitter:

    def __init__(self):
        self.tweets = deque()
        self.following = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets.append((userId, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        feed = []
        n = 0
        for i in range(len(self.tweets)-1, -1, -1):
            if self.tweets[i][0] == userId or self.tweets[i][0] in self.following[userId]:
                feed.append(self.tweets[i][1])
                n += 1
            
            if n == 10: break
        
        return feed

    def follow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].discard(followeeId)

# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
