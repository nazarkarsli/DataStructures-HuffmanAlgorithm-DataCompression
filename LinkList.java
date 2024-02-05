class LinkList {
    Link head;

    public LinkList() {
        this.head = null;
    }

    public void insert(char karakter, int frekans) {
        Link newLink = new Link(karakter, frekans);

        if (head == null || frekans < head.frekans) {
            newLink.next = head;
            head = newLink;
        } else {
            Link current = head;
            while (current.next != null && frekans >= current.next.frekans) {
                current = current.next;
            }
            newLink.next = current.next;
            current.next = newLink;
        }
    }

    public void display() {
        Link current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public void mergeMinNodes() {
        if (head != null && head.next != null) {
            Link first = head;
            Link second = head.next;

            int sum = first.frekans + second.frekans;

            Link newNode = new Link('-', sum);
            newNode.next = second.next;

            head = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }


    public void insert(HuffmanNode newNode) {
        Link newLink = new Link(newNode.karakter, newNode.frekans);

        if (head == null || newNode.frekans < head.frekans) {
            newLink.next = head;
            head = newLink;
        } else {
            Link current = head;
            while (current.next != null && newNode.frekans >= current.next.frekans) {
                current = current.next;
            }
            newLink.next = current.next;
            current.next = newLink;
        }
    }}