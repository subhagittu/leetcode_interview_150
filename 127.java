class Solution {

    class QueueElement {
        String word;
        int level;
        QueueElement(String word, QueueElement prev) {
            this.word = word;
            this.level = prev.level+1;
        }
        QueueElement(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return 0;
        Queue<QueueElement> q = new LinkedList<>();
        q.add(new QueueElement(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!q.isEmpty()) {
            QueueElement polled = q.poll();
            if(polled.word.equals(endWord)) {
                return polled.level;
            }
            int L = polled.word.length();
            char[] polledChars = polled.word.toCharArray();
            for(int i = 0; i < L; i++) {
                char temp = polledChars[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    if(c == temp)
                        continue;
                    polledChars[i] = c;
                    String potentialNextWord = new String(polledChars);
                    if(!visited.contains(potentialNextWord) && dict.contains(potentialNextWord)) {
                        visited.add(potentialNextWord);
                        q.add(new QueueElement(potentialNextWord, polled));
                    }
                }
                polledChars[i] = temp;
            }
        }
        return 0;
    }
}
