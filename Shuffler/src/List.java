import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name ="list")
@XmlRootElement
public class List {
	
	@XmlElement(name="head")
	private Node head;
	@XmlElement(name="tail")
	private Node tail;
	@XmlElement(name="size")
	private int size;

	@XmlType(name="node")
	private static class Node {
		@XmlElement(name="value")
		private Integer value;
		private Node next;
		private Node prev;
	}

	public List() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public void push(Integer data) {
		Node old = head;
		head = new Node();
		head.value = data;
		head.next = null;
		if (size == 0) {
			tail = head;
		} else {
			old.next = head;
			head.prev = old;
		}
		size++;
	}

	public Integer popT() {
		if (size == 0)
			return 0;
		Integer data = tail.value;
		tail = tail.next;
		tail.prev = null;
		size--;
		return data;
	}

	public Integer popH() {
		if (size == 0)
			return 0;
		Integer data = head.value;
		head = head.prev;
		head.next = null;
		size--;
		return data;
	}

	@Override
	public String toString() {
		if (size == 0)
			return ("[]");
		Node t = tail;
		String s = "";
		while (t.next != null) {
			s = s.concat(t.value + " ");
			t = t.next;
		}
		return "[" + s + "]";
	}

}
