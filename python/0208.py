class Trie:

    def __init__(self):
        self.suffixes = {}
        self.isEnd = False

    def insert(self, word: str) -> None:
        if len(word) == 0:
            self.isEnd = True
            return
        if word[0] not in self.suffixes:
            self.suffixes[word[0]] = Trie()

        self.suffixes[word[0]].insert(word[1:])

    def search(self, word: str) -> bool:
        if not word: return self.isEnd
        if word[0] not in self.suffixes: return False
        return self.suffixes[word[0]].search(word[1:])

    def startsWith(self, prefix: str) -> bool:
        if not prefix: return True
        if prefix[0] not in self.suffixes: return False
        return self.suffixes[prefix[0]].startsWith(prefix[1:])


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
