class Huffman {
    LinkList linkList;
    HuffmanNode root;

    public Huffman() {
        this.linkList = new LinkList();
    }

    public void buildHuffmanTree(LinkList linkList) {
        while (!this.linkList.isEmpty() && this.linkList.head != null && this.linkList.head.next != null) {
            this.linkList.mergeMinNodes();

            HuffmanNode newNode = new HuffmanNode('-', this.linkList.head.frekans + this.linkList.head.next.frekans);
            newNode.left = new HuffmanNode(this.linkList.head.karakter, this.linkList.head.frekans);
            newNode.right = new HuffmanNode(this.linkList.head.next.karakter, this.linkList.head.next.frekans);

            this.linkList.head = this.linkList.head.next.next;
            this.linkList.insert(newNode);
        }

        if (!this.linkList.isEmpty()) {
            root = new HuffmanNode(this.linkList.head.karakter, this.linkList.head.frekans);
        }
    }

    public void buildHuffmanCodes(HuffmanNode root, String code, StringBuilder encodedData) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            encodedData.append(code);
        }

        buildHuffmanCodes(root.left, code + "0", encodedData);
        buildHuffmanCodes(root.right, code + "1", encodedData);
    }

    public String encodeData(String dataset) {
        StringBuilder encodedData = new StringBuilder();
        buildHuffmanCodes(root, "", encodedData);

        return encodedData.toString();
    }

    public void displayFrequencyTable() {
        linkList.display();
    }

    public void displayHuffmanCoding() {
        StringBuilder encodedData = new StringBuilder();
        buildHuffmanCodes(root, "", encodedData);
        System.out.println("Encode Data Set: " + encodedData);
    }
}

