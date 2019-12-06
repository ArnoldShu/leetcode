package com.arnold.www.list.linkedlist;

/**
 * @ClassName ReverseLinkedList
 * @Description: 翻转单链表
 * @Author Arnold
 * @Date 2019/12/6
 * @Version V2.0
 **/
public class ReverseLinkedList {
    /*
    反转一个单链表。
    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    */
    public static void main(String[] args) {
        //初始化单链表输出
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new Node(1,1));
        singleLinkedList.add(new Node(2,2));
        singleLinkedList.add(new Node(3,3));
        singleLinkedList.add(new Node(4,4));
        singleLinkedList.add(new Node(5,5));
        singleLinkedList.foreachList();
        singleLinkedList.reverse();
        singleLinkedList.foreachList();
    }

     /**
      * @ClassName: Node
      * @Description: 内部类 链表数据结构
      * @Author: Arnold
      * @Date: 2019/12/6
     **/
    public static class Node{
        /*
          节点位置
         */
        public int no;
        /*
          节点数据域
         */
        public Object data;
        /*
           下一个节点
         */
        public Node next;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

         public int getNo() {
             return no;
         }

         public void setNo(int no) {
             this.no = no;
         }

         public Node(int no, Object data) {
             this.no = no;
             this.data = data;
         }

         @Override
         public String toString() {
             return "Node{" +
                     "no=" + no +
                     ", data=" + data +
                     ", next=" + next +
                     '}';
         }
     }

      /**
       * @ClassName: SingleLinkedList
       * @Description: 单链表类
       * @Author: Arnold
       * @Date: 2019/12/6
      **/
    public static class SingleLinkedList{
        //初始化以位置=0表示为头节点
        private Node head =new Node(0,"");

        public Node getHead() {
          return head;
        }

         /**
          * @MethodName: add
          * @Description: 添加节点
          * @Param: Node node
          * @Return: void
          * @Author: Arnold
          * @Date: 2019/12/6
         **/
        public void add(Node node){
            Node temp =head;
            while (true){
                //链表只能在链表最后添加数据,一直找到最后就跳出
                if (temp.next==null){
                    break;
                }
                //链表指针一直往后推
                temp = temp.next;
            }
            //找到最后节点之后添加数据
            temp.next = node;
        }

         /**
          * @MethodName: foreachList
          * @Description: 遍历输出节点数据域
          * @Param:
          * @Return:
          * @Author: Arnold
          * @Date: 2019/12/6
         **/
        public void foreachList() {
          if (head.next==null){
              System.out.println("链表为空");
          }
          //临时变量,因为head头移动之后会影响
          Node tempNode = head.next;
          while (true){
            if (tempNode ==null){
                break;
            }
            System.out.println(tempNode.getData().toString());
            tempNode =tempNode.next;
          }
        }

         /**
          * @MethodName: reverse
          * @Description: 翻转链表
          * @Param: SingleLinkedList singleLinkedList
          * @Return: void
          * @Author: Arnold
          * @Date: 2019/12/6
          * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
          * 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用
          *
         **/
        public void reverse(){
            Node currentNode = head;
            Node preNode = null;
            while (currentNode!=null){
                Node nextNode = currentNode.next;
                currentNode.next = preNode;
                preNode = currentNode;
                currentNode = nextNode;
            }
        }
          /*public ListNode reverseList(ListNode head) {
              ListNode prev = null;
              ListNode curr = head;
              while (curr != null) {
                  ListNode nextTemp = curr.next;
                  curr.next = prev;
                  prev = curr;
                  curr = nextTemp;
              }
              return prev;
          }*/
    }
}
