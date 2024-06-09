function replaceWords(dictionary: string[], sentence: string): string {
    const words = sentence.split(" ");
    dictionary.sort((a, b) => a.length - b.length);
    
    const result = [];
    words.forEach((word) => {
        for(const root of dictionary) {
            if(word.startsWith(root)) {
                word = root;
                break;
            }
        }
        result.push(word);
    })
    return result.join(" ");
};