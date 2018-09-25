/*Created by Okza*/
class DoubleLinkedList {

  private Node head;
  private Node tail;

  /* Mengecek apakah DLL kosong atau tidak */
  public boolean isEmpty() {
    return head == null;
  }

  public void sisipDiDepan(int data) {
    Node nodeBaru = new Node(data);
    if (isEmpty()) {
      head = tail = nodeBaru;
      nodeBaru.next = null;
      nodeBaru.prev = null;
    } else {
      nodeBaru.next = head;
      nodeBaru.prev = null;
      head.prev = nodeBaru;
      head = nodeBaru;
    }
  }

  public void sisipDiBelakang(int data) {
    Node nodeBaru = new Node(data);
    if (isEmpty()) {
      head = tail = nodeBaru;
      nodeBaru.next = null;
      nodeBaru.prev = null;
    } else {
      tail.next = nodeBaru;
      nodeBaru.next = null;
      nodeBaru.prev = tail;
      tail = nodeBaru;
    }
  }

  public void sisipSetelah(int dataDicari, int dataBaru) {
    Node find = head;
    /* Melakukan looping hingga null untuk mengecek tiap data dari node */
    while (find != null) {
      if (find.data == dataDicari) {
        // System.out.println("DATA KETEMU " + find.data);
        Node nodeBaru = new Node(dataBaru);
        nodeBaru.next = find.next;
        find.next.prev = nodeBaru;
        find.next = nodeBaru;
        nodeBaru.prev = find;
        break;
      }
      /* Pindah ke node selanjutnya jika data tidak ditemukan */
      find = find.next;
    }
  }

  public void sisipSebelum(int dataDicari, int dataBaru) {
    Node find = head;
    /* Melakukan looping hingga null untuk mengecek tiap data dari node */
    while (find != null) {
      if (find.next.data == dataDicari) {
        Node nodeBaru = new Node(dataBaru);
        nodeBaru.next = find.next;
        find.next.prev = nodeBaru;
        find.next = nodeBaru;
        nodeBaru.prev = find;
        break;
      }
      /* Pindah ke node selanjutnya jika data tidak ditemukan */
      find = find.next;
    }
  }

  public void cetak(String details) {
    System.out.println(details);
    Node print = head;
    while (print != null) {
      if (print.next == null) {
        System.out.print(print.data);
      } else {
        System.out.print(print.data + " <-> ");
      }
      print = print.next;
    }
  }

  public void sisipDataUrut(int data) {
    sisipDiBelakang(data);
    Node temp1 = head;
    while (temp1.next != null) {
      Node temp2 = temp1.next;
      /*Looping Node kedua hingga null, jika sudah null maka node pertama yang akan diloop*/
      while (temp2 != null) {
        if (temp1.data > temp2.data) {
          int tempAngka = temp2.data;
          temp2.data = temp1.data;
          temp1.data = tempAngka;
        }
        temp2 = temp2.next;
      }
      temp1 = temp1.next;
    }

  }

  public static void main(String[] args) {
    DoubleLinkedList dll = new DoubleLinkedList();
    dll.sisipDiDepan(10);
    dll.sisipDiBelakang(20);
    dll.sisipDiDepan(5);
    dll.sisipSetelah(5, 7);
    dll.cetak("Sisip biasa");

    DoubleLinkedList dll2 = new DoubleLinkedList();
    dll2.sisipDataUrut(10);
    dll2.sisipDataUrut(5);
    dll2.sisipDataUrut(9);
    dll2.sisipDataUrut(12);
    dll2.sisipDataUrut(3);
    dll2.sisipDataUrut(19);
    dll2.sisipDataUrut(25);
    dll2.cetak("\nSisip Data Urut");

  }
}