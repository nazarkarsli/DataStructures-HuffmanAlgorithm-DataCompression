public class Main {
    public static void main(String[] args) {
        String dataset = "AAAABBCDDDDDDDDEEEEEEEEEEFFFFFFFFFFFF";
        int[] frequencyArray = new int[256];
        for (char c : dataset.toCharArray()) {
            frequencyArray[c]++;
        }

        LinkList linkList = new LinkList();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                linkList.insert((char) i, frequencyArray[i]);
            }
        }

        System.out.println("Karakter - Frekans");
        linkList.display();

        Huffman huffman = new Huffman();
        huffman.buildHuffmanTree(linkList);

        System.out.println("Encode Data Set: " + huffman.encodeData(dataset));
    }
}

