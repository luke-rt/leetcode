class WordDictionary:

    def __init__(self):
        self.prefixes = {}
        self.isEnd = False

    def addWord(self, word: str) -> None:
        if len(word) == 0:
            self.isEnd = True
            return
        if word[0] not in self.prefixes:
            self.prefixes[word[0]] = WordDictionary()

        self.prefixes[word[0]].addWord(word[1:])

    def search(self, word: str) -> bool:
        if len(word) == 0: return self.isEnd

        if word[0] == ".":
            for prefix in self.prefixes:
                if self.prefixes[prefix].search(word[1:]):
                    return True
            return False

        if word[0] in self.prefixes:
            return self.prefixes[word[0]].search(word[1:])
        return False


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
